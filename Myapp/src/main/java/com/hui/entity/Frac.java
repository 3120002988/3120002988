package com.hui.entity;

import lombok.Data;

/**
 * @version 1.0
 * @Author wanghui
 * @Description 分数类
 * @Create 2022-09-26 22:14
 */
@Data
public class Frac {
    private int inter;//整数部分
    private int num;//分子
    private int denom;//分母

    public Frac(int num, int denom) {
        this.num = num;
        this.denom = denom;
    }
}
