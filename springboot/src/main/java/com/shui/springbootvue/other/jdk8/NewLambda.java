package com.shui.springbootvue.other.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Lambda表达式(也称为闭包)
 */
public class NewLambda {
    public static void main(String[] args) {


//        List<String> proNames = Arrays.asList(new String[]{"Ni","Hao","Lambda"});
//        List<String> lowercaseNames1 = proNames.stream().map(name -> {return name.toLowerCase();}).collect(Collectors.toList());
//        System.out.println(lowercaseNames1);
//
//        one c = (int a, int b) -> a + b;

        List<String> as = new ArrayList<>();
        as.add("aa");
        as.add("bb");
        as.add("cc");
        as.add("dd");
        List<String> b = new ArrayList<>();
        b.add("aa");
        b.add("bb");
        b.add("cc");
        for(String a:as){
            if(!b.contains(a)){
                System.out.println("错误");
            }else {
                System.out.println(a);
            }
        }
    }

    interface one{
        int o(int a,int b);
    }




}
