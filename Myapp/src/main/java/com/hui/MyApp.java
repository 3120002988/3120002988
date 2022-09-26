package com.hui;

import com.hui.utils.ExpressionUtil;
import com.hui.utils.PrintFileUtil;
import com.hui.utils.ValidateUtil;

import java.util.Map;
import java.util.Scanner;

/**
 * @version 1.0
 * @Author wanghui
 * @Description
 * @Create 2022-09-26 22:16
 */
public class MyApp {
    public static void main(String[] args) {

        System.out.println("***************欢迎使用四则运算题目生成程序****************");
        System.out.println("***************使用Myapp.exe -n 参数控制题目生成数目 -r 参数控制题目中数值（自然数、真分数和真分数分母）的范围****************");
        System.out.println("***************使用Myapp.exe -e <exercisefile>.txt -a <answerfile>.txt 检查答案的正确率***************");
        System.out.println("***************输入bye结束***************");

        while(true){

            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            if(command.equalsIgnoreCase("bye")){
                break;
            }
            //校验输入
            String[] split = ValidateUtil.checkParams(command);

            if (split!=null){
                if (split[1].equals("-n")) {//myapp.exe -n i -r j
                    int num = Integer.valueOf(split[2]);
                    if (num <= 0) {
                        System.out.println("-n参数输入错误，请重新输入");
                    }else {
                        int round = Integer.valueOf(split[4]);
                        if (round <= 0) {
                            System.out.println("-r参数输入错误，请重新输入");
                        } else {
                            //获取运算式数组
                            System.out.println("正在生成题目...");
                            Map<String, String> questionAndResultMap = ExpressionUtil.generate(num, round);
                            System.out.println("生成完成，请等待...");
                            PrintFileUtil.printExerciseFileAndAnswerFile(questionAndResultMap);
                        }
                    }
                }else {// -e x -a y
                    String exerciseFileUrl = split[2];
                    String answerFileUrl = split[4];
                    //验证答案
                    PrintFileUtil.validateAnswerFile(exerciseFileUrl, answerFileUrl);
                }
            }else {
                System.out.println("参数输入有误，请重新输入");
            }
        }
    }
}
