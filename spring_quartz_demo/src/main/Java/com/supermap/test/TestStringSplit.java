package com.supermap.test;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class TestStringSplit {

    public Map<String,String> StringToMap(String s){
        Map<String,String> map = new HashMap<>();
        String s1 = s.replaceAll("addItemString", "\\$");

        String[] split = s1.split("\\$");

        String[] ss = new String[split.length-1];
        System.arraycopy(split,1,ss,0,ss.length);
        for (int i=0;i<ss.length;i++) {
            ss[i] = ss[i].substring(0, ss[i].length() - 1);
            ss[i] = ss[i].substring(0, ss[i].length() - 1);
            String step = ss[i].substring(ss[i].indexOf("(") + 1);
            String behind = step.substring(step.indexOf(",") + 1);
            String behind2 = behind.substring(0, behind.length() - 1);
            String behind3 = behind2.substring(behind2.indexOf("\"") + 1);

            String front = step.substring(0, step.indexOf(","));
            String front2 = front.substring(0, front.length() - 1);
            String front3 = front2.substring(front2.indexOf("\"") + 1);

            map.put(front3,behind3);
        }
        return map;
    }

    @Test
    public void test1(){
        String s = "removeAllItem();" +
                "addItemString(\"8600000002017111407280265WFTECHM20WFTECH0WFTECH0WFTECH上年同期;1-本月;工业销售产值(当年价格);千元\", \"上年同期;1-本月;工业销售产值(当年价格);千元\");" +
                "addItemString(\"8600000002017111407280265WFTECHM21WFTECH0WFTECH0WFTECH本月;工业销售产值(当年价格);出口交货值;千元\", \"本月;工业销售产值(当年价格);出口交货值;千元\");" +
                "addItemString(\"8600000002017111407280265WFTECHM22WFTECH0WFTECH0WFTECH1-本月;工业销售产值(当年价格);出口交货值;千元\", \"1-本月;工业销售产值(当年价格);出口交货值;千元\");";
        String s1 = s.replaceAll("addItemString", "\\$");
        //System.out.println(s1);
        String[] split = s1.split("\\$");

        String[] ss = new String[split.length-1];

        System.arraycopy(split,1,ss,0,ss.length);
        for (int i=0;i<ss.length;i++){
            //ss[i] = ss[i].substring(0, ss[i].length() - 1);
            ss[i] = ss[i].substring(0, ss[i].length() - 1);
            ss[i] = ss[i].substring(0, ss[i].length() - 1);
            String step4 = ss[i].substring(ss[i].indexOf("(") + 1);
            //System.out.println(step4);
            String behind = step4.substring(step4.indexOf(",") + 1);
            String behind2 = behind.substring(0, behind.length() - 1);
            String behind3 = behind2.substring(behind2.indexOf("\"") + 1);

            String front = step4.substring(0, step4.indexOf(","));
            String front2 = front.substring(0, front.length() - 1);
            String front3 = front2.substring(front2.indexOf("\"") + 1);
            System.out.println(front3);
            System.out.println(behind3);

        }
    }



    @Test
    public void test2(){
        String s = "removeAllItem();" +
                "addItemString(\"8600000002017111407280265WFTECHHANDLEORGWFTECH1WFTECH0WFTECH数据处理地\", \"数据处理地\");" +
                "addItemString(\"8600000002017111407280265WFTECHM1WFTECH1WFTECH0WFTECH组织机构代码\", \"组织机构代码\");" +
                "addItemString(\"8600000002017111407280265WFTECHM4WFTECH1WFTECH0WFTECH单位详细名称\", \"单位详细名称\");" +
                "addItemString(\"8600000002017111407280265WFTECHM2WFTECH1WFTECH0WFTECH期别(月)\", \"期别(月)\");" +
                "addItemString(\"8600000002017111407280265WFTECHM3WFTECH1WFTECH0WFTECH期别(年)\", \"期别(年)\");" +
                "addItemString(\"8600000002017111407280265WFTECHM5WFTECH1WFTECH0WFTECH统一社会信用代码\", \"统一社会信用代码\");" +
                "addItemString(\"8600000002017111407280265WFTECHM6WFTECH1WFTECH0WFTECH单位负责人\", \"单位负责人\");" +
                "addItemString(\"8600000002017111407280265WFTECHM7WFTECH1WFTECH0WFTECH统计负责人\", \"统计负责人\");" +
                "addItemString(\"8600000002017111407280265WFTECHM8WFTECH1WFTECH0WFTECH填表人\", \"填表人\");" +
                "addItemString(\"8600000002017111407280265WFTECHM9WFTECH1WFTECH0WFTECH报出日期(年)\", \"报出日期(年)\");" +
                "addItemString(\"8600000002017111407280265WFTECHM10WFTECH1WFTECH0WFTECH报出日期(月)\", \"报出日期(月)\");" +
                "addItemString(\"8600000002017111407280265WFTECHM11WFTECH1WFTECH0WFTECH报出日期(日)\", \"报出日期(日)\");" +
                "addItemString(\"8600000002017111407280265WFTECHM12WFTECH1WFTECH0WFTECH填表人联系电话\", \"填表人联系电话\");" +
                "addItemString(\"8600000002017111407280265WFTECHM13WFTECH0WFTECH0WFTECH本月;工业总产值(当年价格);千元\", \"本月;工业总产值(当年价格);千元\");" +
                "addItemString(\"8600000002017111407280265WFTECHM14WFTECH0WFTECH0WFTECH1-本月;工业总产值(当年价格);千元\", \"1-本月;工业总产值(当年价格);千元\");" +
                "addItemString(\"8600000002017111407280265WFTECHM15WFTECH0WFTECH0WFTECH上年同期;本月;工业总产值(当年价格);千元\", \"上年同期;本月;工业总产值(当年价格);千元\");" +
                "addItemString(\"8600000002017111407280265WFTECHM16WFTECH0WFTECH0WFTECH上年同期;1-本月;工业总产值(当年价格);千元\", \"上年同期;1-本月;工业总产值(当年价格);千元\");" +
                "addItemString(\"8600000002017111407280265WFTECHM17WFTECH0WFTECH0WFTECH本月;工业销售产值(当年价格);千元\", \"本月;工业销售产值(当年价格);千元\");" +
                "addItemString(\"8600000002017111407280265WFTECHM18WFTECH0WFTECH0WFTECH1-本月;工业销售产值(当年价格);千元\", \"1-本月;工业销售产值(当年价格);千元\");" +
                "addItemString(\"8600000002017111407280265WFTECHM19WFTECH0WFTECH0WFTECH上年同期;本月;工业销售产值(当年价格);千元\", \"上年同期;本月;工业销售产值(当年价格);千元\");" +
                "addItemString(\"8600000002017111407280265WFTECHM20WFTECH0WFTECH0WFTECH上年同期;1-本月;工业销售产值(当年价格);千元\", \"上年同期;1-本月;工业销售产值(当年价格);千元\");" +
                "addItemString(\"8600000002017111407280265WFTECHM21WFTECH0WFTECH0WFTECH本月;工业销售产值(当年价格);出口交货值;千元\", \"本月;工业销售产值(当年价格);出口交货值;千元\");" +
                "addItemString(\"8600000002017111407280265WFTECHM22WFTECH0WFTECH0WFTECH1-本月;工业销售产值(当年价格);出口交货值;千元\", \"1-本月;工业销售产值(当年价格);出口交货值;千元\");" +
                "addItemString(\"8600000002017111407280265WFTECHM23WFTECH0WFTECH0WFTECH上年同期;本月;工业销售产值(当年价格);出口交货值;千元\", \"上年同期;本月;工业销售产值(当年价格);出口交货值;千元\");" +
                "addItemString(\"8600000002017111407280265WFTECHM24WFTECH0WFTECH0WFTECH上年同期;1-本月;工业销售产值(当年价格);出口交货值;千元\", \"上年同期;1-本月;工业销售产值(当年价格);出口交货值;千元\");" +
                "addItemString(\"8600000002017111407280265WFTECHCHECKERRINFOWFTECH1WFTECH0WFTECH调查对象审核错误说明\", \"调查对象审核错误说明\");" +
                "addItemString(\"8600000002017111407280265WFTECHPREVIOUSMARKINFOWFTECH1WFTECH0WFTECH上期反馈说明\", \"上期反馈说明\");" +
                "addItemString(\"8600000002017111407280265WFTECHreporttimeWFTECH1WFTECH0WFTECH报送时间\", \"报送时间\");";
        Map<String, String> map = StringToMap(s);
        System.out.println(map);
    }
}
