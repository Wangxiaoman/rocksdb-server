package com.rocksdb.log;


import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonLogger {
    private static Logger infoLog = LoggerFactory.getLogger("info");
    private static Logger warnLog = LoggerFactory.getLogger("warn");
    private static Logger errorLog = LoggerFactory.getLogger("error");
    private static Logger actionLog = LoggerFactory.getLogger("actionLogger");
    private static Logger urlLog = LoggerFactory.getLogger("urlPostLogger");
    
    
    
    public static void info(String msg) {
    	infoLog.info(msg);
    }
    
    public static void infoOnePercent(String msg) {
    	if(RandomUtils.nextInt(0, 10000) < 10){
			infoLog.info("1/1000 info sampling," + msg);
    	}
    }
    
    public static void warn(String msg) {
    	warnLog.warn(msg);
    }
    
    public static void warnOnePercent(String msg) {
    	if(RandomUtils.nextInt(0, 10000) < 10){
    		warnLog.warn("1/1000 warn sampling," +msg);
    	}
    }
    
    public static void errorOnePercent(String msg,Throwable t) {
    	if(RandomUtils.nextInt(0, 10000) < 10){
			errorLog.error("1/1000 error sampling," + msg, t);
    	}
    }
    
    public static void error(String msg,Throwable t) {
    	errorLog.error(msg,t);
    }
    
    public static void action(String msg) {
    	actionLog.info(msg);
    }

    public static void urlLog(String msg) {
    	urlLog.info(msg);
    }

}
