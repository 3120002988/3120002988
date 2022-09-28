package com.hui;

import com.hui.common.Constant;
import com.hui.utils.CheckUtil;
import com.hui.utils.ExpressionUtil;
import com.hui.utils.PrintFileUtil;
import org.junit.Test;

import java.util.Map;

/**
 * @version 1.0
 * @Author wanghui
 * @Description
 * @Create 2022-09-26 22:37
 */
public class AppTest {
    @Test
    public void test1(){
        /*
        * Myapp.exe -n 10000 -r 200
        * Myapp.exe -e Exercises.txt -a Answers.txt
        * */
        String command = "Myapp.exe -n 10000 -r 200";
        //校验输入
        String[] split = CheckUtil.checkParams(command);
        if (split != null) {
            if (split[1].equals("-n")) {//myapp.exe -n i -r j
                int num = Integer.valueOf(split[2]);
                if (num <= 0) {
                    System.out.println("-n参数输入错误，请重新输入");
                } else {
                    int round = Integer.valueOf(split[4]);
                    if (round <= 0) {
                        System.out.println("-r参数输入错误，请重新输入");
                    } else {
                        //获取运算式数组
                        System.out.println("正在生成"+num+"道题目...");
                        Map<String, String> quesResMap = ExpressionUtil.quesProduct(num, round);
                        PrintFileUtil.printFile(quesResMap);
                        System.out.println(num+"道题目全部生成完成！");
                    }
                }
            } else {// -e x -a y
                String exerFileUrl = split[2];
                String ansFileUrl = split[4];
                //验证答案正确率
                PrintFileUtil.checkAccuracy(exerFileUrl, ansFileUrl);
            }
        } else {
            System.out.println("参数输入有误，请重新输入");
        }
    }
    @Test
    public void test2(){
        /*
        * Myapp.exe -n 10000 -r 200
        * Myapp.exe -e Exercises.txt -a Answers.txt
        * */
        String command = "Myapp.exe -e Exercises.txt -a Answers.txt";
        //校验输入
        String[] split = CheckUtil.checkParams(command);
        if (split != null) {
            if (split[1].equals("-n")) {//myapp.exe -n i -r j
                int num = Integer.valueOf(split[2]);
                if (num <= 0) {
                    System.out.println("-n参数输入错误，请重新输入");
                } else {
                    int round = Integer.valueOf(split[4]);
                    if (round <= 0) {
                        System.out.println("-r参数输入错误，请重新输入");
                    } else {
                        //获取运算式数组
                        System.out.println("正在生成"+num+"道题目...");
                        Map<String, String> quesResMap = ExpressionUtil.quesProduct(num, round);
                        PrintFileUtil.printFile(quesResMap);
                        System.out.println(num+"道题目全部生成完成！");
                    }
                }
            } else {// -e x -a y
                String exerFileUrl = split[2];
                String ansFileUrl = split[4];
                //验证答案正确率
                PrintFileUtil.checkAccuracy(exerFileUrl, ansFileUrl);
            }
        } else {
            System.out.println("参数输入有误，请重新输入");
        }
    }
    @Test
    public void test3(){
        /*
        * Myapp.exe -n 10000 -r 200
        * Myapp.exe -e Exercises.txt -a Answers.txt
        * */
        String command = "Myapp.exe -n -2 -r 200";
        //校验输入
        String[] split = CheckUtil.checkParams(command);
        if (split != null) {
            if (split[1].equals("-n")) {//myapp.exe -n i -r j
                int num = Integer.valueOf(split[2]);
                if (num <= 0) {
                    System.out.println("-n参数输入错误，请重新输入");
                } else {
                    int round = Integer.valueOf(split[4]);
                    if (round <= 0) {
                        System.out.println("-r参数输入错误，请重新输入");
                    } else {
                        //获取运算式数组
                        System.out.println("正在生成"+num+"道题目...");
                        Map<String, String> quesResMap = ExpressionUtil.quesProduct(num, round);
                        PrintFileUtil.printFile(quesResMap);
                        System.out.println(num+"道题目全部生成完成！");
                    }
                }
            } else {// -e x -a y
                String exerFileUrl = split[2];
                String ansFileUrl = split[4];
                //验证答案正确率
                PrintFileUtil.checkAccuracy(exerFileUrl, ansFileUrl);
            }
        } else {
            System.out.println("参数输入有误，请重新输入");
        }
    }
    @Test
    public void test4(){
        /*
        * Myapp.exe -n 10000 -r 200
        * Myapp.exe -e Exercises.txt -a Answers.txt
        * */
        String command = "Myapp.exe -n 10000 -r -200";
        //校验输入
        String[] split = CheckUtil.checkParams(command);
        if (split != null) {
            if (split[1].equals("-n")) {//myapp.exe -n i -r j
                int num = Integer.valueOf(split[2]);
                if (num <= 0) {
                    System.out.println("-n参数输入错误，请重新输入");
                } else {
                    int round = Integer.valueOf(split[4]);
                    if (round <= 0) {
                        System.out.println("-r参数输入错误，请重新输入");
                    } else {
                        //获取运算式数组
                        System.out.println("正在生成"+num+"道题目...");
                        Map<String, String> quesResMap = ExpressionUtil.quesProduct(num, round);
                        PrintFileUtil.printFile(quesResMap);
                        System.out.println(num+"道题目全部生成完成！");
                    }
                }
            } else {// -e x -a y
                String exerFileUrl = split[2];
                String ansFileUrl = split[4];
                //验证答案正确率
                PrintFileUtil.checkAccuracy(exerFileUrl, ansFileUrl);
            }
        } else {
            System.out.println("参数输入有误，请重新输入");
        }
    }
    @Test
    public void test5(){
        /*
        * Myapp.exe -n 10000 -r 200
        * Myapp.exe -e Exercises.txt -a Answers.txt
        * */
        String command = "Myapp.exe-n10000-r200";
        //校验输入
        String[] split = CheckUtil.checkParams(command);
        if (split != null) {
            if (split[1].equals("-n")) {//myapp.exe -n i -r j
                int num = Integer.valueOf(split[2]);
                if (num <= 0) {
                    System.out.println("-n参数输入错误，请重新输入");
                } else {
                    int round = Integer.valueOf(split[4]);
                    if (round <= 0) {
                        System.out.println("-r参数输入错误，请重新输入");
                    } else {
                        //获取运算式数组
                        System.out.println("正在生成"+num+"道题目...");
                        Map<String, String> quesResMap = ExpressionUtil.quesProduct(num, round);
                        PrintFileUtil.printFile(quesResMap);
                        System.out.println(num+"道题目全部生成完成！");
                    }
                }
            } else {// -e x -a y
                String exerFileUrl = split[2];
                String ansFileUrl = split[4];
                //验证答案正确率
                PrintFileUtil.checkAccuracy(exerFileUrl, ansFileUrl);
            }
        } else {
            System.out.println("参数输入有误，请重新输入");
        }
    }
    @Test
    public void test6(){
        /*
        * Myapp.exe -n 10000 -r 200
        * Myapp.exe -e Exercises.txt -a Answers.txt
        * */
        String command = "Myapp.exe -e NotExists.txt -a Answers.txt";
        //校验输入
        String[] split = CheckUtil.checkParams(command);
        if (split != null) {
            if (split[1].equals("-n")) {//myapp.exe -n i -r j
                int num = Integer.valueOf(split[2]);
                if (num <= 0) {
                    System.out.println("-n参数输入错误，请重新输入");
                } else {
                    int round = Integer.valueOf(split[4]);
                    if (round <= 0) {
                        System.out.println("-r参数输入错误，请重新输入");
                    } else {
                        //获取运算式数组
                        System.out.println("正在生成"+num+"道题目...");
                        Map<String, String> quesResMap = ExpressionUtil.quesProduct(num, round);
                        PrintFileUtil.printFile(quesResMap);
                        System.out.println(num+"道题目全部生成完成！");
                    }
                }
            } else {// -e x -a y
                String exerFileUrl = split[2];
                String ansFileUrl = split[4];
                //验证答案正确率
                PrintFileUtil.checkAccuracy(exerFileUrl, ansFileUrl);
            }
        } else {
            System.out.println("参数输入有误，请重新输入");
        }
    }
}
