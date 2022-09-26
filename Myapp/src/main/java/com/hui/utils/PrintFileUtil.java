package com.hui.utils;

import com.hui.constant.Constant;

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
     * 根据运算式子打印练习文件和答案文件
     *
     * @param questionAndResultMap
     */
    public static void printExerciseFileAndAnswerFile(Map<String, String> questionAndResultMap) {
        File dir = new File(Constant.PRINT_FILE_URL);
        //处理输出文件格式
        int i = 0;
        int j = 0;
        //解决FileNotFound
        if (!dir.exists()) {
            dir.mkdir();
        }
        File exerciseFile = new File(Constant.PRINT_FILE_URL, "Exercises.txt");
        File answerFile = new File(Constant.PRINT_FILE_URL, "Answers.txt");
        try {
            OutputStream exerciseFileOutputStream = new FileOutputStream(exerciseFile);
            OutputStream answerFileOutputStream = new FileOutputStream(answerFile);

            StringBuilder exerciseBuffer = new StringBuilder();
            StringBuilder answerFileBuffer = new StringBuilder();
            System.out.println("正在写出到文件...");

            for (Map.Entry<String, String> entry : questionAndResultMap.entrySet()) {
                exerciseBuffer.append(++i +"、");
                exerciseBuffer.append(entry.getKey()).append("\r\n");
                answerFileBuffer.append(++j +"、");
                answerFileBuffer.append(entry.getValue()).append("\r\n");
            }
            exerciseFileOutputStream.write(exerciseBuffer.toString().getBytes());
            answerFileOutputStream.write(answerFileBuffer.toString().getBytes());
            exerciseFileOutputStream.close();
            answerFileOutputStream.close();
            System.out.println("操作成功！！！");
        } catch (IOException e) {
            System.out.println("文件操作异常，请重试");
        }


    }

    /**
     * 验证答案的正确率
     *
     * @param exerciseFileUrl
     * @param answerFileUrl
     */
    public static void validateAnswerFile(String exerciseFileUrl, String answerFileUrl) {
        File exerciseFile = new File(ValidateUtil.improvePath(exerciseFileUrl));//Constant.PRINT_FILE_URL, exerciseFileUrl);
        File answerFile = new File(ValidateUtil.improvePath(answerFileUrl));
        File gradeFile = new File(Constant.PRINT_FILE_URL, "Grade.txt");
        if (exerciseFile.isFile() && answerFile.isFile()) {
            BufferedReader exerciseReader = null;
            BufferedReader answerReader = null;
            OutputStream gradeFileOutputStream = null;

            List<Integer> Correct = new ArrayList<Integer>();
            List<Integer> Wrong = new ArrayList<Integer>();
            try {
                exerciseReader = new BufferedReader(new InputStreamReader(new FileInputStream(exerciseFile)));
                answerReader = new BufferedReader(new InputStreamReader(new FileInputStream(answerFile)));
                String exerciseStr = "";
                String answerStr = "";
                String[] exerciseStrs = null;
                String[] answerStrs = null;
                int line = 0;//记录行数
                System.out.println("开始验证...");
                while ((exerciseStr = exerciseReader.readLine()) != null && (answerStr = answerReader.readLine()) != null) {
                    exerciseStrs = exerciseStr.split("、");
                    answerStrs = answerStr.split("、");
                    //获取运算式的正确答案
                    String realAnswer = CalculateUtil.getExpressValue(exerciseStrs[1]);
                    if (realAnswer.equals(answerStrs[1])) {
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
                System.out.print(result);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (exerciseReader != null) {
                    try {
                        exerciseReader.close();
                    } catch (IOException ignored) {
                    }
                }
                if (answerReader != null) {
                    try {
                        answerReader.close();
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
            System.out.println("文件不存在！！！");
        }
    }
}
