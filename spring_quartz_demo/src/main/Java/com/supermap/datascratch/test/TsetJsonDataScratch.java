package com.supermap.datascratch.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.supermap.datascratch.utils.JsonDataScratch;
import org.junit.jupiter.api.Test;

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

    @Test void test2(){
        String requestURL = "http://data.stats.gov.cn/easyquery.htm?m=QueryData&dbcode=fsyd&rowcode=zb&colcode=sj&wds=%5B%7B%22wdcode%22%3A%22reg%22%2C%22valuecode%22%3A%22110000%22%7D%5D&dfwds=%5B%7B%22wdcode%22%3A%22zb%22%2C%22valuecode%22%3A%22A1301%22%7D%5D&k1=1542273586409";
        String requestMethod = "GET";
        JSONObject jsonObject = JsonDataScratch.objectResponse(requestURL, requestMethod);
        System.out.println(jsonObject);
    }

    public String modelOut(String num){
        String requestURL = "http://nxdata.gov.cn/easyquery.htm?cn=D0102&id=" + num + "&dbcode=qxnd&wdcode=zb&m=getTree";
        return requestURL;
    }
}
