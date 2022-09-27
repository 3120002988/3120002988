package com.hui.utils;

import java.util.Random;

/**
 * @version 1.0
 * @Author wanghui
 * @Description
 * @Create 2022-09-26 22:30
 */
public class GetOpsUtil {
    /**
     * 随机获取n个操作数(分数)的数组
     *
     * @param n
     * @param round
     * @return
     */
    static String[] getOps(int n, int round) {

        Random random = new Random();
        String[] ops = new String[n];

        for (int i = 0; i < n; i++) {
            //用于判断生成整数还是分数
            int flag = (int) (Math.random() * 10) % 2;

            //生成整数
            if (flag == 0) {
                int inter = random.nextInt(round);
                ops[i] = (inter == 0 ? 1 : inter) + "";
            } else {//生成分数
                int num = (random.nextInt(round)) + 1;
                int denom = (random.nextInt(round)) + 1;
                ;

                while (num >= denom || num == 0 || denom == 0) {//确保为真分数
                    num = (random.nextInt(round)) + 1;
                    denom = (random.nextInt(round)) + 1;
                }

                ops[i] = num + "/" + denom;
            }
        }
        return ops;
    }
}
