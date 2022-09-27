package com.hui.utils;

import com.hui.common.Constant;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @Author wanghui
 * @Description
 * @Create 2022-09-26 22:21
 */
public class PrintFileUtil {
    /**
     * 打印练习文件和答案文件
     *
     * @param quesResMap
     */
    public static void printFile(Map<String, String> quesResMap) {
        File dir = new File(Constant.PRINT_FILE_URL);
        //处理输出文件格式
        int i = 0;
        int j = 0;

        if (!dir.exists()) {
            dir.mkdir();
        }
        File exerFile = new File(Constant.PRINT_FILE_URL, "Exercises.txt");
        File ansFile = new File(Constant.PRINT_FILE_URL, "Answers.txt");
        try {
            OutputStream exerFileOutputStream = new FileOutputStream(exerFile);
            OutputStream ansFileOutputStream = new FileOutputStream(ansFile);

            StringBuilder exerBuffer = new StringBuilder();
            StringBuilder ansFileBuffer = new StringBuilder();
            System.out.println("正在打印文件...");

            for (Map.Entry<String, String> entry : quesResMap.entrySet()) {
                exerBuffer.append(++i + "、");
                exerBuffer.append(entry.getKey()).append("\r\n");
                ansFileBuffer.append(++j + "、");
                ansFileBuffer.append(entry.getValue()).append("\r\n");
            }
            exerFileOutputStream.write(exerBuffer.toString().getBytes());
            ansFileOutputStream.write(ansFileBuffer.toString().getBytes());
            exerFileOutputStream.close();
            ansFileOutputStream.close();
            System.out.println("打印成功！！！");
        } catch (IOException e) {
            System.out.println("文件打印异常，请重试");
        }


    }

    /**
     * 验证答案的正确率
     *
     * @param exerFileUrl
     * @param ansFileUrl
     */
    public static void checkAccuracy(String exerFileUrl, String ansFileUrl) {
        File exerciseFile = new File(CheckUtil.getSupportPath(exerFileUrl));
        File answerFile = new File(CheckUtil.getSupportPath(ansFileUrl));
        File gradeFile = new File(Constant.PRINT_FILE_URL, "Grade.txt");
        if (exerciseFile.isFile() && answerFile.isFile()) {
            BufferedReader exerReader = null;
            BufferedReader ansReader = null;
            OutputStream gradeFileOutputStream = null;

            List<Integer> Correct = new ArrayList<Integer>();
            List<Integer> Wrong = new ArrayList<Integer>();
            try {
                exerReader = new BufferedReader(new InputStreamReader(new FileInputStream(exerciseFile)));
                ansReader = new BufferedReader(new InputStreamReader(new FileInputStream(answerFile)));
                String exerStr = "";
                String ansStr = "";
                String[] exerStrs = null;
                String[] ansStrs = null;
                int line = 0;//记录行数
                System.out.println("开始验证答案正确率，请稍等...");
                while ((exerStr = exerReader.readLine()) != null && (ansStr = ansReader.readLine()) != null) {
                    exerStrs = exerStr.split("、");
                    ansStrs = ansStr.split("、");
                    //获取运算式的正确答案
                    String correctAnswer = CalcUtil.getExpressValue(exerStrs[1]);
                    if (correctAnswer.equals(ansStrs[1])) {
                        line++;
                        Correct.add(line);
                    } else {
                        line++;
                        Wrong.add(line);
                    }
                }
                String result = "Correct:" + Correct.size() + Correct + "\r\n" + "Wrong:" + Wrong.size() + Wrong;
                //保存成绩文件
                gradeFileOutputStream = new FileOutputStream(gradeFile);
                gradeFileOutputStream.write(result.getBytes());
                //打印结果
                System.out.println("验证完毕，验证结果如下：");
                System.out.print(result);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (exerReader != null) {
                    try {
                        exerReader.close();
                    } catch (IOException ignored) {
                    }
                }
                if (ansReader != null) {
                    try {
                        ansReader.close();
                    } catch (IOException ignored) {
                    }
                }
                if (gradeFileOutputStream != null) {
                    try {
                        gradeFileOutputStream.close();
                    } catch (IOException ignored) {
                    }
                }
            }

        } else {
            System.out.println("该文件不存在！！！");
        }
    }
}
