package com.hui.utils;

import com.hui.common.Constant;

import java.io.File;

/**
 * @version 1.0
 * @Author wanghui
 * @Description
 * @Create 2022-09-26 22:22
 */
public class CheckUtil {
    /**
     * 参数检查 只有两种合法输入
     *
     * @param command
     * @return 返回定好顺序的命令数组
     */
    public static String[] checkParams(String command) {
        String[] s = command.split(" ");

        if (s.length == 5) {
            String first = s[1];
            String third = s[3];
            String second = s[2];
            String fourth = s[4];
            if ((first.equals("-n") && third.equals("-r")) || (first.equals("-e") && third.equals("-a"))) {
                return s;
            }
            return null;
        } else {
            return null;
        }
    }

    /**
     * 得到支持的路径
     *
     * @param path
     * @return 正确路径
     */
    public static String getSupportPath(String path) {
        if (path.contains("/")) {//替换分隔符
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
