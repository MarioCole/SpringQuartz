package com.supermap.utils.dateToCron;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateToCronUtils {

    public static Date formatStringToDate(String s, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = simpleDateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String formatDateByPattern(Date date,String dateFormat){
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        String formatTimeStr = null;
        if (date != null) {
            formatTimeStr = sdf.format(date);
        }
        return formatTimeStr;
    }
    /***
     * convert Date to cron ,eg.  "0 06 10 15 1 ? 2014"
     * @param date  : 时间点
     * @return
     */
    public static String getCron(java.util.Date  date){
        String dateFormat="ss mm HH dd MM ?";
        return formatDateByPattern(date, dateFormat);
    }

    @Test
    public void test1(){
        String cron = getCron(new Date());
        System.out.println(cron);
    }

    @Test
    public void testFromatStringToDate(){
        String date = "00-00 10:10:10";
        String format = "MM-dd HH:mm:ss";
        Date date1 = formatStringToDate(date, format);
        String cron = getCron(date1);
        System.out.println(cron);
    }
}
