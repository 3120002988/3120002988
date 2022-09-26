package com.hui.utils;

import com.hui.constant.Constant;

import java.io.File;

/**
 * @version 1.0
 * @Author wanghui
 * @Description
 * @Create 2022-09-26 22:22
 */
public class ValidateUtil {
    /**
     * 参数检查 只有两种合法输入
     * @param command
     * @return 返回定好顺序的命令数组
     */
    public static String[] checkParams(String command) {
        String[] s = command.split(" ");
        //其实只能输入长度为4的指令
        if (s.length == 5){
            String first = s[1];String third = s[3];String second = s[2];String fourth = s[4];
            if((first.equals("-n")&&third.equals("-r")) || (first.equals("-e")&&third.equals("-a"))){
                return s;
            }
            return null;
        }else {
            return null;
        }
    }

    /**
     * 对绝对路径和相对路径的支持
     * @param path
     * @return 正确路径
     */
    public static String improvePath(String path) {
        if (path.contains("/")){//替换分隔符
            path = path.replace("/", File.separator);
        }
        String p = "";
        if (path.indexOf(":") > 0) {//绝对路径
            p = path;
        } else {//相对路径
            p = Constant.PRINT_FILE_URL + File.separator + path;
        }
        return p;
    }
}
