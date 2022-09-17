package com.hui.checkpaper.service;

import com.hui.checkpaper.service.impl.SimHashImpl;

import java.math.BigInteger;
import java.util.List;

/**
 * @version 1.0
 * @Author wanghui
 * @Description
 * @Create 2022-09-17 13:58
 */
@SuppressWarnings({"all"})
public interface SimHash {
    /**
     * SimHash模块
     * @return
     */
    BigInteger simHash();
    /**
     * 计算哈希值
     * @param source
     * @return
     */
    BigInteger hash(String source);

    /**
     * 计算汉明距离
     * @param str1
     * @param str2
     * @return
     */
    double getDistance(String str1, String str2);


    /**
     * 获取相似度
     * @param str1
     * @param str2
     * @return
     */
    public String getSimilarity(String str1, String str2);
    /**
     * 获取特征值
     * @param simHashImpl
     * @param distance
     * @return
     */
    List subByDistance(SimHashImpl simHashImpl, int distance);

}
