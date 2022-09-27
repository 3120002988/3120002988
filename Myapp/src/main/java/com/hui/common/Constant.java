package com.hui.common;

import java.io.File;

/**
 * @version 1.0
 * @Author wanghui
 * @Description 符号常量
 * @Create 2022-09-26 22:10
 */
public class Constant {
    public static final Character PLUS = '+';
    public static final Character MINUS = '-';
    public static final Character MULTIPLY = '*';
    public static final Character DIVIDE = '÷';
    //"D:\github_space\dashen_project\MyApp\question_bank";10.3修改生成文件地址
    public static final String PRINT_FILE_URL = System.getProperty("user.dir") + File.separator + "src" +
            File.separator + "main" + File.separator + "resources";

}
