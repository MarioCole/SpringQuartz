package com.supermap.test;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {

    @Test
    public void test1(){
        String time = "2018-08-16";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = simpleDateFormat.parse(time);
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testReplaceString(){
        //String model = "* * * * * ?";
        String ss = "0/1";
        String mm = "5";
        String HH = "1";
        String dd = "12";
        String MM = "8";

        StringBuilder replace = null;
        if (ss != null){
            StringBuilder stringBuilder = new StringBuilder("*  *  *  *  *  ?");
            replace = stringBuilder.replace(0, 1, ss);
            System.out.println(replace);
        }
    }
}
