package com.rocksdb.contants;

import com.rocksdb.tools.DateTools;

public class RedisConstants {
	// Redis key prefix  
	// 1-%s: itemSetId ，2-%s: year:week
    public static final String ITEM_SET_HAVE_URL = "itemset:url:%s:%s";
    public static final String ITEM_SET_NEED_QUERY_URL = "itemset:url:query:%s:%s";
    
    public static String getItemSetHaveUrlKey(String itemSetId){
    	return String.format(ITEM_SET_HAVE_URL, itemSetId,DateTools.getWeekOfYear());
    }
    
    public static String getItemSetNeedQueryUrlKey(String itemSetId){
    	return String.format(ITEM_SET_NEED_QUERY_URL, itemSetId,DateTools.getWeekOfYear());
    }
    
    
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            String itemSetId = String.valueOf(i);
            System.out.println(getItemSetHaveUrlKey(itemSetId));
            System.out.println(getItemSetNeedQueryUrlKey(itemSetId));
        }
    }
}
