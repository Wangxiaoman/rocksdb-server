package com.rocksdb.tools;

import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.util.Base64Utils;

import com.github.luben.zstd.Zstd;
import com.rocksdb.log.CommonLogger;

public class ContextTools {
	
	private static SecretKeySpec spec = new SecretKeySpec(Base64.getDecoder().decode("zKCvVGnIphe+R8yNQwIpCb=="), "AES");

	public static String getContext(String sourceContext) {
		try {
			byte[] base64array = Base64Utils.decodeFromString(sourceContext);
			final byte[] iv = Arrays.copyOfRange(base64array, 0, 12);
			final byte[] pass = Arrays.copyOfRange(base64array, 12, base64array.length);
			final GCMParameterSpec ivSpec = new GCMParameterSpec(128, iv);
			final Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");

			cipher.init(Cipher.DECRYPT_MODE, spec, ivSpec);

			byte[] result = cipher.doFinal(pass);
			return new String(Zstd.decompress(result, 100000));
		} catch (Exception ex) {
			CommonLogger.errorOnePercent("get context error,context:" + sourceContext + ",ex:", ex);
		}
		return "";
	}
	
	public static String getItemSetId(String itemSetContent){
		if(itemSetContent.contains("_")){
			return itemSetContent.substring(itemSetContent.lastIndexOf("_")+1);
		}
		return itemSetContent;
	}
}
