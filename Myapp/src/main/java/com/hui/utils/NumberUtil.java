package com.hui.utils;

import java.util.Random;

/**
 * @version 1.0
 * @Author wanghui
 * @Description
 * @Create 2022-09-26 22:30
 */
public class NumberUtil {
    /**
     * 随机获取num个操作数的数组
     * @param num
     * @param round
     * @return
     */
    static String[] getNumbers(int num, int round) {

        Random random = new Random();
        String[] numbers = new String[num];

        for (int i = 0; i < num; i++) {
            //用于判断生成整数还是分数
            int flag = (int)(Math.random()*10) % 2;

            if(flag==0){//生成整数
                int n = random.nextInt(round);
                numbers[i] = (n==0?1:n)+"";
            }else{//生成分数
                //随机生成分子和分母，为了避免分子分母生成0进行了+1/+2的改进
                int numerator = (random.nextInt(round))+1;
                int denominator = (random.nextInt(round))+1;;

                while(numerator>=denominator||numerator==0||denominator==0){//判断是否为真分数，且不能生成带0的分数
                    numerator = (random.nextInt(round))+1;
                    denominator = (random.nextInt(round))+1;
                }
                //拼装成分数形式
                numbers[i] = numerator+"/"+denominator;
            }
        }
        return numbers;
    }
}
