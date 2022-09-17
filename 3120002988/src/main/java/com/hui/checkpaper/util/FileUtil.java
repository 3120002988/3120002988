package com.hui.checkpaper.util;

import java.io.*;

/**
 * @version 1.0
 * @Author wanghui
 * @Description
 * @Create 2022-09-17 13:54
 */
@SuppressWarnings({"all"})
public class FileUtil {
    public static String readString(String filepath)  {
        if(filepath == null || "".equals ( filepath )){
            return "";
        }
        int len=0;
        StringBuffer str=new StringBuffer("");
        java.io.File file = new java.io.File(filepath);
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line=null;
            while((line=bufferedReader.readLine())!=null){
                if (len!=0){
                    str.append("\r\n"+line);
                }else {
                    str.append(line);
                }
                len++;
            }
            bufferedReader.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str.toString();
    }

    public static void writeString(String filePath,String context) throws IOException {
        FileOutputStream fileOutputStream = null;
        File file = new File(filePath);
        if(!file.exists()){
            file.createNewFile();
        }
        fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(context.getBytes("gbk"));
        fileOutputStream.flush();
        fileOutputStream.close();
    }
}
