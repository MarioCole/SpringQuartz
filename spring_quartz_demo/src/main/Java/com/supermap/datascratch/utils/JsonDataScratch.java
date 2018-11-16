package com.supermap.datascratch.utils;





import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数据抓取方法
 */
public class JsonDataScratch {

    /**
     * 指标数据抓取
     * @param requestUrl
     * @param requestMethod
     * @return JSONArray
     */
    public static JSONArray arrayResponse(String requestUrl, String requestMethod){

        JSONArray jsonArray = null;
        StringBuffer buffer = new StringBuffer();
        try {
            URL url = new URL(requestUrl);

            //http协议传输
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            //设置请求方式
            httpURLConnection.setRequestMethod(requestMethod);

            if ("GET".equalsIgnoreCase(requestMethod)){
                httpURLConnection.connect();
            }
            //将返回的输入流转换成字符串
            InputStream inputStream = httpURLConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String str = null;
            while ((str = bufferedReader.readLine())!=null){
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            //释放资源
            inputStream.close();
            inputStream = null;
            httpURLConnection.disconnect();
            jsonArray = JSONArray.parseArray(buffer.toString());
        }catch (Exception e){
            //e.printStackTrace();
        }
        return jsonArray;
    }

    /**
     * 具体数据抓取
     * @param requestUrl
     * @param requestMethod
     * @return JSONObject
     */
    public static JSONObject objectResponse(String requestUrl, String requestMethod){

        JSONObject jsonObject = null;
        StringBuffer buffer = new StringBuffer();
        try {
            URL url = new URL(requestUrl);

            //http协议传输
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            //设置请求方式
            httpURLConnection.setRequestMethod(requestMethod);

            if ("GET".equalsIgnoreCase(requestMethod)){
                httpURLConnection.connect();
            }
            //将返回的输入流转换成字符串
            InputStream inputStream = httpURLConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String str = null;
            while ((str = bufferedReader.readLine())!=null){
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            //释放资源
            inputStream.close();
            inputStream = null;
            httpURLConnection.disconnect();
            jsonObject = JSONObject.parseObject(buffer.toString());
        }catch (Exception e){
            //e.printStackTrace();
        }
        return jsonObject;
    }


    /**
     * 指标数据格式化
     * @param jsonArray
     * @return List
     */
    public static List<List<Object>> parseArray(String jsonArray){

        List<List<Object>> list = new ArrayList<>();
        JSONArray jsonArray1 = JSONObject.parseArray(jsonArray);
        for (int i=0;i<jsonArray1.size();i++){
            JSONObject jsonObject = (JSONObject) JSONObject.toJSON(jsonArray1.get(i));
            String dbcode = (String) jsonObject.get("dbcode");
            Object isParent =  jsonObject.get("isParent");
            String name = (String) jsonObject.get("name");
            String pid = (String) jsonObject.get("pid");
            String wdcode = (String) jsonObject.get("wdcode");
            String id = (String) jsonObject.get("id");
            List<Object> list1 = new ArrayList<>();
            list1.add(dbcode);
            list1.add(isParent);
            list1.add(name);
            list1.add(pid);
            list1.add(wdcode);
            list1.add(id);
            list.add(list1);
        }
        return list;
    }


}
