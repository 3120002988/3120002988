package com.hui.entity;

import lombok.Data;

/**
 * @version 1.0
 * @Author wanghui
 * @Description
 * @Create 2022-09-26 22:19
 */
@Data
public class Fraction {
    private int inter;//整数部分
    private int numerator;//分子
    private int denominator;//分母
    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }
}
