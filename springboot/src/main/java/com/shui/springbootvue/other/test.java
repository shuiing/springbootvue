package com.shui.springbootvue.other;

import java.math.BigDecimal;

import static java.math.BigDecimal.ROUND_HALF_UP;

public class test {
    public static void main(String[] args){
        BigDecimal a = new BigDecimal(88.8);
        BigDecimal b = new BigDecimal(44.4);
        System.out.println(b.divide(a,3,ROUND_HALF_UP));
    }
}
