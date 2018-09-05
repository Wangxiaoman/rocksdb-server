package com.rocksdb.contants;

public class Constants {
    public static final String dbPath = "/cluster/data/rocksdb/itemset_url";
//    public static final String dbPath = "/cluster/data/rocksdb-nossd/itemset_url";
    public static final String INNER_TEMP_TOKEN = "ai4paradigm";

    public static final String ITEM_URL_PREFIX = "item_url_";
    public static final String ITEM_CRAWLED_URL_PREFIX = "item_crawled_url_";
    public static final int BATCH_MAX_URL_COUNT = 1000;
    public static final int SEARCH_MAX_URL_COUNT = 3;


    public static String getItemUrlTable(String itemSetId) {
        return ITEM_URL_PREFIX + itemSetId;
    }

    public static String getItemCrawledUrlTable(String itemSetId) {
        return ITEM_CRAWLED_URL_PREFIX + itemSetId;
    }
    
    
    public static final String ACCESS_TOKEN_FIELD = "clientToken";
    public static final String VERSION_FIELD = "version";
    public static final String SCENE_ID_FIELD = "sceneId";
    public static final String ITEM_SET_ID = "itemSetId";
    public static final String ITEM_URL = "url";
}
