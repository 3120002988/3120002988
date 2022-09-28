package com.hui;

import com.hui.utils.ExpressionUtil;
import com.hui.utils.PrintFileUtil;
import com.hui.utils.CheckUtil;

import java.util.Map;
import java.util.Scanner;

/**
 * @version 1.0
 * @Author wanghui
 * @Description
 * @Create 2022-09-26 22:02
 */
public class MyApp {
    public static void main(String[] args) {

        System.out.println("==================  欢迎使用四则运算题目生成程序  ===================");
        System.out.println("===============使用Myapp.exe -n 题目数量 -r 数值范围 ===============");
        System.out.println("===============使用Myapp.exe -e 题目.txt -a 答案.txt===============");
        System.out.println("=================            输入bye结束         ==================");

        while (true) {

            Scanner scanner = new Scanner(System.in);
            /*
            * Myapp.exe -n 10000 -r 200
            * Myapp.exe -e Exercises.txt -a Answers.txt
            * */
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("bye")) {
                break;
            }
            //校验输入
            String[] split = CheckUtil.checkParams(command);

            if (split != null) {
                if (split[1].equals("-n")) {//Myapp.exe -n i -r j
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
                } else {// Myapp.exe -e x -a y
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
}
