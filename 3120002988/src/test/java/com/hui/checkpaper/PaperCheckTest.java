package com.hui.checkpaper;


import com.hui.checkpaper.util.FileUtil;
import com.hui.checkpaper.service.impl.SimHashImpl;
import org.junit.Test;

import java.io.IOException;

/**
 * @version 1.0
 * @Author wanghui
 * @Description
 * @Create 2022-09-17 14:19
 */
@SuppressWarnings({"all"})
public class PaperCheckTest {
    String origin = "src/main/resources/paper/orig.txt";
    String result = "src/main/resources/paper/result.txt";
    String[] s = {
            "src/main/resources/paper/orig_0.8_add.txt",
            "src/main/resources/paper/orig_0.8_del.txt",
            "src/main/resources/paper/orig_0.8_dis_1.txt",
            "src/main/resources/paper/orig_0.8_dis_10.txt",
            "src/main/resources/paper/orig_0.8_dis_15.txt"};

    @Test
    public void testAdd(){
        String f1 = FileUtil.readString(origin);
        String f2 = FileUtil.readString(s[0]);
        if (!"".equals(f1) && !"".equals(f2)){
            SimHashImpl hash1 = new SimHashImpl(f1, 64);
            hash1.subByDistance(hash1, 3);
            SimHashImpl hash2 = new SimHashImpl(f2, 64);
            hash2.subByDistance(hash2, 3);
            String distance = hash1.getSimilarity(hash1.getStrSimHash(),hash2.getStrSimHash());
            System.out.println("该文章与原文相似度为："+distance+"%");
            try {
                FileUtil.writeString(result,distance+"%");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("文件路径不能为空");
        }

    }
    @Test
    public void testDel(){
        String f1 = FileUtil.readString(origin);
        String f2 = FileUtil.readString(s[1]);
        if (!"".equals(f1) && !"".equals(f2)){
            SimHashImpl hash1 = new SimHashImpl(f1, 64);
            hash1.subByDistance(hash1, 3);
            SimHashImpl hash2 = new SimHashImpl(f2, 64);
            hash2.subByDistance(hash2, 3);
            String distance = hash1.getSimilarity(hash1.getStrSimHash(),hash2.getStrSimHash());
            System.out.println("该文章与原文相似度为："+distance+"%");
            try {
                FileUtil.writeString(result,distance+"%");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("文件路径不能为空");
        }
    }

    @Test
    public void testDis_1(){
        String f1 = FileUtil.readString(origin);
        String f2 = FileUtil.readString(s[2]);
        if (!"".equals(f1) && !"".equals(f2)){
            SimHashImpl hash1 = new SimHashImpl(f1, 64);
            hash1.subByDistance(hash1, 3);
            SimHashImpl hash2 = new SimHashImpl(f2, 64);
            hash2.subByDistance(hash2, 3);
            String distance = hash1.getSimilarity(hash1.getStrSimHash(),hash2.getStrSimHash());
            System.out.println("该文章与原文相似度为："+distance+"%");
            try {
                FileUtil.writeString(result,distance+"%");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("文件路径不能为空");
        }
    }

    @Test
    public void testDis_10(){
        String f1 = FileUtil.readString(origin);
        String f2 = FileUtil.readString(s[3]);
        if (!"".equals(f1) && !"".equals(f2)){
            SimHashImpl hash1 = new SimHashImpl(f1, 64);
            hash1.subByDistance(hash1, 3);
            SimHashImpl hash2 = new SimHashImpl(f2, 64);
            hash2.subByDistance(hash2, 3);
            String distance = hash1.getSimilarity(hash1.getStrSimHash(),hash2.getStrSimHash());
            System.out.println("该文章与原文相似度为："+distance+"%");
            try {
                FileUtil.writeString(result,distance+"%");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("文件路径不能为空");
        }
    }

    @Test
    public void testDis_15(){
        String f1 = FileUtil.readString(origin);
        String f2 = FileUtil.readString(s[4]);
        if (!"".equals(f1) && !"".equals(f2)){
            SimHashImpl hash1 = new SimHashImpl(f1, 64);
            hash1.subByDistance(hash1, 3);
            SimHashImpl hash2 = new SimHashImpl(f2, 64);
            hash2.subByDistance(hash2, 3);
            String distance = hash1.getSimilarity(hash1.getStrSimHash(),hash2.getStrSimHash());
            System.out.println("该文章与原文相似度为："+distance+"%");
            try {
                FileUtil.writeString(result,distance+"%");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("文件路径不能为空");
        }
    }

    @Test
    public void testNull1(){
        String f1 = FileUtil.readString("");
        String f2 = FileUtil.readString("");
        if (!"".equals(f1) && !"".equals(f2)){
            SimHashImpl hash1 = new SimHashImpl(f1, 64);
            hash1.subByDistance(hash1, 3);
            SimHashImpl hash2 = new SimHashImpl(f2, 64);
            hash2.subByDistance(hash2, 3);
            String distance = hash1.getSimilarity(hash1.getStrSimHash(),hash2.getStrSimHash());
            System.out.println("该文章与原文相似度为："+distance+"%");
            try {
                FileUtil.writeString(result,distance+"%");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("文件路径不能为空");
        }
    }
    @Test
    public void testNull2(){
        String f1 = FileUtil.readString(origin);
        String f2 = FileUtil.readString("");
        if (!"".equals(f1) && !"".equals(f2)){
            SimHashImpl hash1 = new SimHashImpl(f1, 64);
            hash1.subByDistance(hash1, 3);
            SimHashImpl hash2 = new SimHashImpl(f2, 64);
            hash2.subByDistance(hash2, 3);
            String distance = hash1.getSimilarity(hash1.getStrSimHash(),hash2.getStrSimHash());
            System.out.println("该文章与原文相似度为："+distance+"%");
            try {
                FileUtil.writeString(result,distance+"%");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("文件路径不能为空");
        }
    }
    @Test
    public void testNull3(){
        String f1 = FileUtil.readString(origin);
        String f2 = FileUtil.readString(null);
        if (!"".equals(f1) && !"".equals(f2)){
            SimHashImpl hash1 = new SimHashImpl(f1, 64);
            hash1.subByDistance(hash1, 3);
            SimHashImpl hash2 = new SimHashImpl(f2, 64);
            hash2.subByDistance(hash2, 3);
            String distance = hash1.getSimilarity(hash1.getStrSimHash(),hash2.getStrSimHash());
            System.out.println("该文章与原文相似度为："+distance+"%");
            try {
                FileUtil.writeString(result,distance+"%");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("文件路径不能为空");
        }
    }
    @Test
    public void testNull4(){
        String f1 = FileUtil.readString(null);
        String f2 = FileUtil.readString(null);
        if (!"".equals(f1) && !"".equals(f2)){
            SimHashImpl hash1 = new SimHashImpl(f1, 64);
            hash1.subByDistance(hash1, 3);
            SimHashImpl hash2 = new SimHashImpl(f2, 64);
            hash2.subByDistance(hash2, 3);
            String distance = hash1.getSimilarity(hash1.getStrSimHash(),hash2.getStrSimHash());
            System.out.println("该文章与原文相似度为："+distance+"%");
            try {
                FileUtil.writeString(result,distance+"%");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("文件路径不能为空");
        }
    }

    @Test
    public void testOrigSame(){
        String f1 = FileUtil.readString(origin);
        String f2 = FileUtil.readString(origin);
        if (!"".equals(f1) && !"".equals(f2)){
            SimHashImpl hash1 = new SimHashImpl(f1, 64);
            hash1.subByDistance(hash1, 3);
            SimHashImpl hash2 = new SimHashImpl(f2, 64);
            hash2.subByDistance(hash2, 3);
            String distance = hash1.getSimilarity(hash1.getStrSimHash(),hash2.getStrSimHash());
            System.out.println("该文章与原文相似度为："+distance+"%");
            try {
                FileUtil.writeString(result,distance+"%");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("文件路径不能为空");
        }
    }
}
