package com.shui.springbootvue.util;

import java.util.Random;
import java.util.UUID;

/**
 * 用于生产序列号
 */
public final class SeqUtil {
    public static final String RANDOM_KEY = String.valueOf((System.currentTimeMillis())%16416 + 100000);

    private static int COUNT = 10;

    private SeqUtil() {

    }
    static{
        System.out.println("【本机随机码】：" + RANDOM_KEY);
    }

    /**
     * 返回4位随机数
     */
    public static String getRadomNum() {
        int[] array = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        Random rand = new Random();
        for (int i = 10; i > 1; i--) {
            int index = rand.nextInt(i);
            int tmp = array[index];
            array[index] = array[i - 1];
            array[i - 1] = tmp;
        }
        String result = "";
        for (int i = 0; i < 4; i++) {
            result += String.valueOf(array[i]);
        }
        return result;

    }


    /**
     * 返回内部序列号 UUID 32位
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static void main(String[] args){
        for(int i=0; i<2000 ;i++){

            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
