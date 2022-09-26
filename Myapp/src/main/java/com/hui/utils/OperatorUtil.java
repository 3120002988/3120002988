package com.hui.utils;

import com.hui.constant.Constant;

/**
 * @version 1.0
 * @Author wanghui
 * @Description
 * @Create 2022-09-26 22:29
 */
public class OperatorUtil {
    private final static Character[] operatorTypes = new Character[]{Constant.PLUS,Constant.MINUS,Constant.MULTIPLY,Constant.DIVIDE};

    /**
     * 随机获取num个运算符的数组
     * @param num
     * @return
     */
    static Character[] getOperators(int num) {

        Character[] operators = new Character[num];

        for (int i = 0; i < num; i++) {
            //随机获取运算符的类型(0~3 代表4个运算符的类型)
            int operatorTypeIndex = (int)(Math.random()*4);
            Character operatorType = operatorTypes[operatorTypeIndex];
            operators[i] = operatorType;
        }

        return operators;
    }
}
