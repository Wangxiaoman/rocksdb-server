package com.rocksdb.tools;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.rocksdb.log.CommonLogger;

public class DateTools {

    private static final ThreadLocal<SimpleDateFormat> sdf = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };
    
    public static Date getDate(String time,String formatStr) throws ParseException{
    	DateFormat sdf = new SimpleDateFormat(formatStr);
    	return sdf.parse(time);
    }     

    public static String formatDate(Date time) {
        return sdf.get().format(time);
    }
    
    public static String formatDate(Date time,String formatStr) {
    	SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
        return sdf.format(time);
    }
    
    public static String formatDate(long time) {
        return formatDate(new Date(time));
    }
    
    public static Date getNDate(int nDay){
    	Calendar calendar = Calendar.getInstance();
    	int day = calendar.get(Calendar.DATE); 
    	calendar.set(Calendar.DATE, day+nDay);
    	return calendar.getTime();
    }
    
    public static int getDays(Date beginTime,Date endTime){
    	int days = (int) ((endTime.getTime() - beginTime.getTime()) / (1000*3600*24));
        return days;
    }
    
    // 和当前时间相差30年以上，认为时间无效
    public static boolean validDate(Date date){
    	if(date != null && date.getTime() > 0){
    		try{
	    		Calendar calendar = Calendar.getInstance();
	    		calendar.add(Calendar.YEAR, -30);
	    		return date.after(calendar.getTime());
    		}catch(Exception ex){
    			CommonLogger.error("date parse error,ex", ex);
    		}
    	}
    	return false;
    }
    
    public static long getTimesSecond(Date beginTime,Date endTime){
    	return (endTime.getTime() - beginTime.getTime())/1000;
    }
    
    public static String getWeekOfYear(){
    	Calendar calendar = Calendar.getInstance();
    	int year = calendar.get(Calendar.YEAR);
    	return year+""+calendar.get(Calendar.WEEK_OF_YEAR);
    }
    
    public static String getLastWeekOfYear(){
    	Calendar calendar = Calendar.getInstance();
    	calendar.add(Calendar.DATE, -7);
    	int year = calendar.get(Calendar.YEAR);
    	return year+""+calendar.get(Calendar.WEEK_OF_YEAR);
    }
}
