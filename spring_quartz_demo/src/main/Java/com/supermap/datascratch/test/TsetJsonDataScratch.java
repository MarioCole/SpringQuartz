package com.supermap.datascratch.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.supermap.datascratch.utils.JsonDataScratch;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Map;

public class TsetJsonDataScratch {

    @Test
    public void test1(){
        //String requestURL = "http://data.stats.gov.cn/easyquery.htm?cn=C01&id=A02&dbcode=hgnd&wdcode=zb&m=getTree";
        String strings[] = {"A01","A02","A03","A04","A05","A06","A07","A08","A09","A0A","A0B","A0C","A0D","A0E","A0F","A0G","A0H","A0I","A0J","A0K","A0L","A0M","A0N","A0O","A0P","A0R","A0S","A0T","A0U"};
        //String requestURL = modelOut("A01");
        String requestMethod = "GET";
        for (int m=0;m<strings.length;m++){
            String requestUrl = modelOut(strings[m]);
            //String requestMethod1 = "GET";
            JSONArray jsonArray = JsonDataScratch.arrayResponse(requestUrl, requestMethod);
            String s = jsonArray.toString();
            List<List<Object>> list = JsonDataScratch.parseArray(s);
            for (int i=0;i<list.size();i++){
                System.out.println(list.get(i));
            }
            //System.out.println("==================================================================");
        }
    }

    @Test
    public void test2(){
        String requestURL = "http://www.cqdata.gov.cn/easyquery.htm?cn=A0103&id=A0203&dbcode=hgnd&wdcode=zb&m=getTree";
        String requestMethod = "GET";
        JSONArray jsonArray = JsonDataScratch.arrayResponse(requestURL, requestMethod);
        String s = jsonArray.toString();
        List<List<Object>> list = JsonDataScratch.parseArray(s);
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }

    /**
     * 国家三级指标
     * @throws IOException
     */
    @Test
    public void testChinaThirdIndex() throws IOException {
        //String requestURL = "http://data.stats.gov.cn/easyquery.htm?m=QueryData&dbcode=fsyd&rowcode=zb&colcode=sj&wds=%5B%7B%22wdcode%22%3A%22reg%22%2C%22valuecode%22%3A%22110000%22%7D%5D&dfwds=%5B%7B%22wdcode%22%3A%22zb%22%2C%22valuecode%22%3A%22A1301%22%7D%5D&k1=1542273586409";
        String firstIndex[] = {"A01","B01","C01"};
        String timeIndex[] = {"hgyd","hgjd","hgnd"};
        String secondIndex[] = {"A01","A02","A03","A04","A05","A06","A07","A08","A09","A0A","A0B","A0C","A0D","A0E","A0F","A0G","A0H","A0I","A0J","A0K","A0L","A0M","A0N","A0O","A0P","A0R","A0S","A0T","A0U"};
        String thirdIndex[] = {"01","02","03","04","05","06","07","08","09","0A","0B","0C","0D","0E","0F","0G","0H","0I","0J","0K","0L"};
        String requestMethod = "GET";
        for (int i=0;i<firstIndex.length;i++){
            for (int j=0;j<secondIndex.length;j++){
                for (int k=0;k<thirdIndex.length;k++){
                    String requestURL = "http://data.stats.gov.cn/easyquery.htm?cn=" + firstIndex[i] +"&id=" + secondIndex[j] + thirdIndex[k] + "&dbcode="+ timeIndex[i] + "&wdcode=zb&m=getTree";
                    JSONArray jsonArray = JsonDataScratch.arrayResponse(requestURL, requestMethod);
                    String s = jsonArray.toString();
                    List<List<Object>> list = JsonDataScratch.parseArray(s);
                    for (int m = 0;m<list.size();m++){
                        if (list.get(m) == null){
                            //fileOut("");
                            System.out.println("");
                        }else {
                            System.out.println(list.get(m));
                            //fileOut(list.get(m).toString());
                        }
                    }
                }
            }
        }
    }

    /**
     * 国家四级指标
     */
    @Test
    public void fourthChinaIndex(){
        String firstIndex[] = {"C01"};
        String timeIndex[] = {"hgnd"};
        String secondIndex[] = {"A01","A02","A03","A04","A05","A06","A07","A08","A09","A0A","A0B","A0C","A0D","A0E","A0F","A0G","A0H","A0I","A0J","A0K","A0L","A0M","A0N","A0O","A0P","A0R","A0S","A0T","A0U"};
        String thirdIndex[] = {"01","02","03","04","05","06","07","08","09","0A","0B","0C","0D","0E","0F","0G","0H","0I","0J","0K","0L","0M","0N","0P"};
        String fourthIndex[] = {"01","02","03","04","05","06","07","08","09","0A","0B","0C","0D","0E","0F","0G","0H","0I","0J","0K","0L","0M","0N","0P"};
        String requestMethod = "GET";
        for (int i=0;i<firstIndex.length;i++){
            for (int j=0;j<secondIndex.length;j++){
                for (int k=0;k<thirdIndex.length;k++){
                    for (int n=0;n<fourthIndex.length;n++){
                        String requestURL = "http://data.stats.gov.cn/easyquery.htm?cn=" + firstIndex[i] +"&id=" + secondIndex[j] + thirdIndex[k] + fourthIndex[n] + "&dbcode="+ timeIndex[i] + "&wdcode=zb&m=getTree";
                        JSONArray jsonArray = JsonDataScratch.arrayResponse(requestURL, requestMethod);
                        if (jsonArray!=null){
                            String s = jsonArray.toString();
                            List<List<Object>> list = JsonDataScratch.parseArray(s);
                            for (int m = 0;m<list.size();m++){
                                if (list.get(m) == null){
                                    //fileOut("");
                                    System.out.println("");
                                }else {
                                    System.out.println(list.get(m));
                                    //fileOut(list.get(m).toString());
                                }
                            }
                        }else {
                         System.out.println("");
                        }
                    }

                }
            }
        }
    }

    /**
     * 重庆四级指标
     */
    @Test
    public void testChongqingFourthIndex(){
        String secondIndex[] = {"A0H","A0I","A0J","A0K","A0L","A0M","A0N","A0O","A0P","A0R","A0S","A0T","A0U"};
        String thirdIndex[] = {"01","02","03","04","05","06","07","08","09","0A","0B","0C","0D","0E","0F","0G","0H","0I","0J","0K","0L"};
        String fourthIndex[] = {"01","02","03","04","05","06","07","08","09","0A","0B","0C","0D","0E","0F","0G","0H","0I","0J","0K","0L","0M","0N","0P"};
        String requestMethod = "GET";
        for (int i=0;i<secondIndex.length;i++){
            for (int j=0;j<thirdIndex.length;j++){
                for (int n=0;n<fourthIndex.length;n++){
                    String requestURL = "http://www.cqdata.gov.cn/easyquery.htm?cn=A0103&id=" + secondIndex[i] + thirdIndex[j] + fourthIndex[n] + "&dbcode=hgnd&wdcode=zb&m=getTree";
                    JSONArray jsonArray = JsonDataScratch.arrayResponse(requestURL, requestMethod);
                    if (jsonArray != null){
                        String s = jsonArray.toString();
                        List<List<Object>> list = JsonDataScratch.parseArray(s);
                        for (int m = 0;m<list.size();m++){
                            if (list.get(m) == null){
                                //fileOut("");
                                System.out.println("");
                            }else {
                                System.out.println(list.get(m));
                                //fileOut(list.get(m).toString());
                            }
                        }
                    }else {
                        System.out.println("");
                    }
                }


            }
        }
    }


    /**
     * 重庆三级指标
     */
    @Test
    public void testChongqinThirdIndex(){
        String firstIndex[] = {"A0101","A0102","A0103"};
        String timeIndex[] = {"hgyd","hgjd","hgnd"};
        String secondIndex[] = {"A01","A02","A03","A04","A05","A06","A07","A08","A09","A0A","A0B","A0C","A0D","A0E","A0F","A0G","A0H","A0I","A0J","A0K","A0L","A0M","A0N","A0O","A0P","A0R","A0S","A0T","A0U"};
        String thirdIndex[] = {"01","02","03","04","05","06","07","08","09","0A","0B","0C","0D","0E","0F","0G","0H","0I","0J","0K","0L"};
        String requestMethod = "POST";
        for (int i=0;i<firstIndex.length;i++){
            for (int j=0;j<secondIndex.length;j++){
                for (int k=0;k<thirdIndex.length;k++){
                    String requestURL = "http://www.cqdata.gov.cn/easyquery.htm?cn=" + firstIndex[i] +"&id=" + secondIndex[j] + thirdIndex[k] + "&dbcode="+ timeIndex[i] + "&wdcode=zb&m=getTree";
                    JSONArray jsonArray = JsonDataScratch.arrayResponse(requestURL, requestMethod);
                    String s = null;
                    if (jsonArray != null){
                        s = jsonArray.toString();
                    }
                    List<List<Object>> list = JsonDataScratch.parseArray(s);
                    for (int m = 0;m<list.size();m++){
                        if (list.get(m) == null){
                            //fileOut("");
                            System.out.println("");
                        }else {
                            System.out.println(list.get(m));
                            //fileOut(list.get(m).toString());
                        }
                    }
                }
            }
        }
    }

    /**
     * 宁夏三级指标
     */
    @Test
    public void testNingxiaThirdIndex(){
        String firstIndex[] = {"A0103","D0102"};
        String timeIndex[] = {"hgnd","qxnd"};
        String secondIndex[] = {"A01","A02","A03","A04","A05","A06","A07","A08","A09","A0A","A0B","A0C","A0D","A0E","A0F","A0G","A0H","A0I","A0J","A0K","A0L","A0M","A0N","A0O","A0P","A0R","A0S","A0T","A0U"};
        String thirdIndex[] = {"01","02","03","04","05","06","07","08","09","0A","0B","0C","0D","0E","0F","0G","0H","0I","0J","0K","0L"};
        String requestMethod = "GET";
        for (int i=0;i<firstIndex.length;i++){
            for (int j=0;j<secondIndex.length;j++){
                for (int k=0;k<thirdIndex.length;k++){
                    String requestURL = "http://nxdata.gov.cn/easyquery.htm?cn=" + firstIndex[i] +"&id=" + secondIndex[j] + thirdIndex[k] + "&dbcode="+ timeIndex[i] + "&wdcode=zb&m=getTree";
                    JSONArray jsonArray = JsonDataScratch.arrayResponse(requestURL, requestMethod);
                    if (jsonArray != null){
                        String s = jsonArray.toString();
                        List<List<Object>> list = JsonDataScratch.parseArray(s);
                        for (int m = 0;m<list.size();m++){
                            if (list.get(m) == null){
                                //fileOut("");
                                System.out.println("");
                            }else {
                                System.out.println(list.get(m));
                                //fileOut(list.get(m).toString());
                            }
                        }
                    }else {
                        System.out.println("");
                    }
                }
            }
        }
    }


    /**
     * 宁夏四级指标
     */
    @Test
    public void testNingxiaFourthIndex(){
        String firstIndex[] = {"A0103"};
        String timeIndex[] = {"hgnd"};
        String secondIndex[] = {"A05","A06","A07","A08","A09","A0A","A0B","A0C","A0D","A0E","A0F","A0G","A0H","A0I","A0J","A0K","A0L","A0M","A0N","A0O","A0P","A0R","A0S","A0T","A0U"};
        String thirdIndex[] = {"01","02","03","04","05","06","07","08","09","0A","0B","0C","0D","0E","0F","0G","0H","0I","0J","0K","0L"};
        String fourthIndex[] = {"01","02","03","04","05","06","07","08","09","0A","0B","0C","0D","0E","0F","0G","0H","0I","0J","0K","0L"};
        String requestMethod = "GET";
        for (int i=0;i<firstIndex.length;i++){
            for (int j=0;j<secondIndex.length;j++){
                for (int k=0;k<thirdIndex.length;k++){
                    for (int n=0;n<fourthIndex.length;n++){
                        String requestURL = "http://nxdata.gov.cn/easyquery.htm?cn=" + firstIndex[i] +"&id=" + secondIndex[j] + thirdIndex[k] + fourthIndex[n] + "&dbcode="+ timeIndex[i] + "&wdcode=zb&m=getTree";
                        JSONArray jsonArray = JsonDataScratch.arrayResponse(requestURL, requestMethod);
                        if (jsonArray != null){
                            String s = jsonArray.toString();
                            List<List<Object>> list = JsonDataScratch.parseArray(s);
                            for (int m = 0;m<list.size();m++){
                                if (list.get(m) == null){
                                    //fileOut("");
                                    System.out.println("");
                                }else {
                                    System.out.println(list.get(m));
                                    //fileOut(list.get(m).toString());
                                }
                            }
                        }else {
                            System.out.println("");
                        }
                    }
                }
            }
        }
    }


    /**
     * 重庆年度三级指标
     */
    @Test
    public void testChongqinYearThirdIndex(){
        String secondIndex[] = {"A01","A02","A03","A04","A05","A06","A07","A08","A09","A0A","A0B","A0C","A0D","A0E","A0F","A0G","A0H","A0I","A0J","A0K","A0L","A0M","A0N","A0O","A0P","A0R","A0S","A0T","A0U"};
        String thirdIndex[] = {"01","02","03","04","05","06","07","08","09","0A","0B","0C","0D","0E","0F","0G","0H","0I","0J","0K","0L"};
        String requestMethod = "GET";
        for (int i=0;i<secondIndex.length;i++){
            for (int j=0;j<thirdIndex.length;j++){
                String requestURL = "http://www.cqdata.gov.cn/easyquery.htm?cn=A0103&id=" + secondIndex[i] + thirdIndex[j] + "&dbcode=hgnd&wdcode=zb&m=getTree";
                JSONArray jsonArray = JsonDataScratch.arrayResponse(requestURL, requestMethod);
                if (jsonArray != null){
                    String s = jsonArray.toString();
                    List<List<Object>> list = JsonDataScratch.parseArray(s);
                    for (int m = 0;m<list.size();m++){
                        if (list.get(m) == null){
                            //fileOut("");
                            System.out.println("");
                        }else {
                            System.out.println(list.get(m));
                            //fileOut(list.get(m).toString());
                        }
                    }
                }else {
                    //System.out.println("");
                }

            }
        }
    }


    /**
     * 国家地区三级指标
     */
    @Test
    public void testChinaRegionIndex(){
        String firstIndex[] = {"E0101","E0102","E0103","E0104"};
        String timeIndex[] = {"fsyd","fsjd","fsnd","csyd"};
        String secondIndex[] = {"A01","A02","A03","A04","A05","A06","A07","A08","A09","A0A","A0B","A0C","A0D","A0E","A0F","A0G","A0H","A0I","A0J","A0K","A0L","A0M","A0N","A0O","A0P","A0R","A0S","A0T","A0U"};
        String thirdIndex[] = {"01","02","03","04","05","06","07","08","09","0A","0B","0C","0D","0E","0F","0G","0H","0I","0J","OK","0L"};
        String requestMethod = "GET";
        for (int i=0;i<firstIndex.length;i++){
            for (int j=0;j<secondIndex.length;j++){
                for (int k=0;k<thirdIndex.length;k++) {
                    String requestURL = "http://data.stats.gov.cn/easyquery.htm?cn=" + firstIndex[i] + "&id=" + secondIndex[j] + thirdIndex[k] + "&dbcode=" + timeIndex[i] + "&wdcode=zb&m=getTree";
                    JSONArray jsonArray = JsonDataScratch.arrayResponse(requestURL, requestMethod);
                    String s = jsonArray.toString();
                    List<List<Object>> list = JsonDataScratch.parseArray(s);
                    for (int m = 0; m < list.size(); m++) {
                        if (list.get(m) == null) {
                            //fileOut("");
                            System.out.println("");
                        } else {
                            System.out.println(list.get(m));
                            //fileOut(list.get(m).toString());
                        }
                    }
                }
            }
        }
    }

    public String modelOut(String num){
        String requestURL = "http://nxdata.gov.cn/easyquery.htm?cn=D0102&id=" + num + "&dbcode=qxnd&wdcode=zb&m=getTree";
        return requestURL;
    }

    public void fileOut(String list) throws IOException {
        // 1：利用File类找到要操作的对象
        File file = new File("D:" + File.separator + "demo" + File.separator + "test.txt");
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }

        //String s = list.toString();
        //2：准备输出流
        Writer out = new FileWriter(file);
        out.write(list);
        out.close();
    }
}
