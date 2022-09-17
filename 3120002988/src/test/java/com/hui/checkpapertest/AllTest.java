package com.hui.checkpapertest;


import com.hui.checkpaper.util.File;
import com.hui.checkpaper.service.impl.SimHashImpl;
import org.junit.Test;

/**
 * @version 1.0
 * @Author wanghui
 * @Description
 * @Create 2022-09-17 14:19
 */
public class AllTest {
    String origin = "C:\\Users\\24173\\Desktop\\grade_3\\软件工程\\测试文本\\orig.txt";
    String[] s = {
            "C:\\Users\\24173\\Desktop\\grade_3\\软件工程\\测试文本\\orig_0.8_add.txt",
            "C:\\Users\\24173\\Desktop\\grade_3\\软件工程\\测试文本\\orig_0.8_del.txt",
            "C:\\Users\\24173\\Desktop\\grade_3\\软件工程\\测试文本\\orig_0.8_dis_1.txt",
            "C:\\Users\\24173\\Desktop\\grade_3\\软件工程\\测试文本\\orig_0.8_dis_10.txt",
            "C:\\Users\\24173\\Desktop\\grade_3\\软件工程\\测试文本\\orig_0.8_dis_15.txt"};

    @Test
    public void addTest(){
            SimHashImpl hash1 = new SimHashImpl(File.readString(origin), 64);
            hash1.subByDistance(hash1, 3);
            SimHashImpl hash2 = new SimHashImpl(s[0], 64);
            hash2.subByDistance(hash2, 3);
            double distance = hash1.getDistance(hash1.getStrSimHash(),hash2.getStrSimHash());
            System.out.println("该文章与原文相似度为："+(100 - distance * 100 / 128)+"%");

    }

}
