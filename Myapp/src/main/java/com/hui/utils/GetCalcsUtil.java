package com.hui.utils;

import com.hui.common.Constant;

/**
 * @version 1.0
 * @Author wanghui
 * @Description
 * @Create 2022-09-26 22:29
 */
public class GetCalcsUtil {
    private final static Character[] calcTypes = new Character[]{Constant.PLUS, Constant.MINUS, Constant.MULTIPLY, Constant.DIVIDE};

    /**
     * 随机获取n个运算符的数组
     *
     * @param n
     * @return
     */
    static Character[] getCalcs(int n) {

        Character[] calcs = new Character[n];

        for (int i = 0; i < n; i++) {
            //随机获取运算符的类型
            int index = (int) (Math.random() * 4);
            Character calcType = calcTypes[index];
            calcs[i] = calcType;
        }

        return calcs;
    }
}
