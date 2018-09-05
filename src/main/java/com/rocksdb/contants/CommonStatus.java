package com.rocksdb.contants;


public enum CommonStatus{

    FAIL(-1, ""),
    
    COMMON_INVALID(0,"无效、未校验、未上线"),
    COMMON_VALID(1,"有效、已校验、已上线"),

    SUCCESS(200,"成功"),
    
    TOCKEN_NOT_CORRECT(3201,"token错误"),
    ITEMSET_ID_NOT_CORRECT(3202,"物料集ID无效"),
    ITEMSET_BUSINESS_NOT_MATCH(3203,"物料集ID和商家ID不匹配"),
    ITEM_FINISH_URL_ERROR(3204,"上报的url为空或者无效"),
    ITEM_SET_NO_CRAWL(3205,"该物料集已经停止抓取"),
    
    PARAM_ERROR(400,"参数异常,请检查"),
    SERVER_ERROR(500,"服务器内部错误");
    
    private int    value;
    private String text; 

    private static final KV<Integer, CommonStatus> lookUp = new KV<Integer, CommonStatus>();

    static {
        for (CommonStatus status : CommonStatus.values()) {
            lookUp.put(status.getValue(), status);
        }
    }

    private CommonStatus(int value, String text) {
        this.value = value;
        this.text = text;
    }

    public int getValue() {
        return this.value;
    }

    public String getText() {
        return this.text;
    }
    
    public static CommonStatus of(Integer value) {
        return lookUp.get(value);
    }

}
