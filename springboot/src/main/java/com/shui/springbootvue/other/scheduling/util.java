package com.shui.springbootvue.other.scheduling;


import org.apache.commons.lang.StringEscapeUtils;

public class util {


    public static String StringEscapeUtils(String str){

        return StringEscapeUtils.escapeHtml(str);

    }


    public static void main(String[] args){
//        System.out.println(StringEscapeUtils("<"));
//        System.out.println(StringEscapeUtils(">"));
//        System.out.println(StringEscapeUtils("?"));
//        System.out.println(StringEscapeUtils("/"));
//        System.out.println(StringEscapeUtils("\""));
//        System.out.println(StringEscapeUtils("\'"));
//        System.out.println(StringEscapeUtils("("));
//        System.out.println(StringEscapeUtils(")"));
//        System.out.println(StringEscapeUtils("<p>测试</p>"));
        System.out.println(StringEscapeUtils("测试"));
    }

}
