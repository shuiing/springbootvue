package com.shui.springbootvue.service;


import com.shui.springbootvue.util.HttpUtil;
import com.shui.springbootvue.util.SeqUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 短信
 */

public class sms {

    //泰普森联通短信
    public static  void sendSms(Map<String,Object> complete){
        String url="http://ums.zj165.com:8888/sms/Api/Send.do";
        Map<String,String> postData = new HashMap<>();
        postData.put("SpCode","235083");
        postData.put("LoginName","zj_tpsxxyp");
        postData.put("Password","");
        postData.put("MessageContent","发送内容");
        postData.put("UserNumber","13074007780");
        postData.put("SerialNumber", SeqUtil.getUUID().substring(0,20));
        postData.put("ScheduleTime","");
        postData.put("ExtendAccessNum","");
        postData.put("f","1");
        try{
            String result = HttpUtil.doPostData(url, postData);
            System.out.println(result);
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    public  static  void main (String[] args) {
    }
}
