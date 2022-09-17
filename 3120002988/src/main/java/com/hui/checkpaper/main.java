package com.hui.checkpaper;

import com.hui.checkpaper.service.impl.SimHashImpl;
import com.hui.checkpaper.util.FileUtil;

import java.io.IOException;
import java.util.Scanner;

/**
 * @version 1.0
 * @Author wanghui
 * @Description
 * @Create 2022-09-17 16:34
 */
public class main {
    public static void main(String[] args) {
        String s1 = "";
        String s2 = "";
        String s3 = "";

        //src/main/resources/paper/orig.txt
        //这可以给出相对路径src/main/resources/paper/orig.txt
        //也可以给出绝对路径C:\Users\24173\Desktop\grade_3\软件工程\测试文本\orig.txt
        //结果都是一样的
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入原文地址：");
        s1 = scanner.next();
        System.out.print("请输入袭文地址：");
        s2 = scanner.next();
        System.out.print("请输入保存结果地址：");
        s3 = scanner.next();


        String f1 = FileUtil.readString(s1);
        String f2 = FileUtil.readString(s2);
        String f3 = FileUtil.readString(s3);

        if (!f1.isEmpty() && !f2.isEmpty()){
            SimHashImpl hash1 = new SimHashImpl(f1, 64);
            hash1.subByDistance(hash1, 3);
            SimHashImpl hash2 = new SimHashImpl(f2, 64);
            hash2.subByDistance(hash2, 3);
            String distance = hash1.getSimilarity(hash1.getStrSimHash(),hash2.getStrSimHash());
            System.out.println("该文章与原文相似度为："+distance+"%");
            try {
                FileUtil.writeString(s3,distance+"%");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("文件路径不能为空");
        }
    }
}
