package com.hui.utils;

import java.util.*;

/**
 * @version 1.0
 * @Author wanghui
 * @Description 运算式工具类
 * @Create 2022-09-26 22:27
 */
public class ExpressionUtil {
    /**
     * 生成n道题目
     *
     * @param n     字符串个数
     * @param range 字符串范围
     * @return
     */
    public static Map<String, String> quesProduct(int n, int range) {

        //运算式和结果的集合
        Map<String, String> quesResMap = new HashMap<String, String>();
        //结果集合，用于判断是否重复
        Set<String> res = new HashSet<String>();
        //获取n道题目
        for (int i = 0; i < n; i++) {
            //随机获取运算符数量(1~3个)
            int nums = (int) (Math.random() * 3) + 1;
            //随机获取nums个运算符
            Character[] calcs = GetCalcsUtil.getCalcs(nums);
            //随机获取nums+1个操作数
            String[] ops = GetOpsUtil.getOps(nums + 1, range);
            //获取运算式表达式
            String[] expression = getExpression(calcs, ops);

            if (expression == null || expression[1].contains("-")) {//判断是否为负数
                i--;
            } else if (res.contains(expression[1])) {//判断是否重复
                i--;
            } else {
                res.add(expression[1]);
                //expression[0]：运算式；expression[1]：结果的值
                quesResMap.put(expression[0], expression[1]);
            }
        }
        return quesResMap;
    }

    /**
     * 得到一个运算式表达式
     *
     * @param calcs 运算符数组
     * @param ops   操作数数组
     * @return 运算式字符串以及其结果
     */
    private static String[] getExpression(Character[] calcs, String[] ops) {
        //操作数的数量
        int nums = ops.length;
        //是否生成带括号的运算式
        int isBracket = (int) (Math.random() * 10) % 2;
        //随机生成器
        Random rand = new Random();

        if (isBracket == 1) {//生成带括号的运算式
            //当标记为1时代表该操作数已经添加了括号
            int[] lStamp = new int[nums];
            int[] rStamp = new int[nums];
            //遍历操作数数组，随机添加括号
            for (int index = 0; index < nums - 1; index++) {
                int n = (int) (Math.random() * 10) % 2;
                if (n == 0 && rStamp[index] != 1) {//判断当前操作数是否标记了左括号
                    lStamp[index] = 1;//标记左括号
                    ops[index] = "(" + ops[index];  //操作数之前加上左括号
                    int k = nums - 1;
                    //生成右括号的位置
                    int rbracketlocation = rand.nextInt(k) % (k - index) + (index + 1);
                    //如果当前操作数有左括号，则重新生成优括号位置
                    while (lStamp[rbracketlocation] == 1) {
                        rbracketlocation = rand.nextInt(k) % (k - index) + (index + 1);
                    }
                    rStamp[rbracketlocation] = 1;
                    ops[rbracketlocation] = ops[rbracketlocation] + ")";

                }
            }
        }

        //将运算符和操作数拼成字符串
        StringBuilder str = new StringBuilder(ops[0]);
        for (int k = 0; k < calcs.length; k++) {
            str.append(calcs[k]).append(ops[k + 1]);
        }
        //运算式
        String expression = str.toString();
        //获取运算式结果
        String value = CalcUtil.getExpressValue(expression);

        if (value.equals("#")) {//运算过程出现负数
            return null;
        }

        return new String[]{expression, value};

    }
}
