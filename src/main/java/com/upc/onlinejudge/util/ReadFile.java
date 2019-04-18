package com.upc.onlinejudge.util;

import java.io.*;

/**
 * @ClassName ReadFile
 * @Author Wang Chunfei
 * @Date 2018/7/7 上午9:18
 **/
public class ReadFile {
    public static String read(File file) {
        String encoding = "UTF-8";
        Long filelength = file.length();
        byte[] filecontent = new byte[filelength.intValue()];
        try {
            FileInputStream in = new FileInputStream(file);
            in.read(filecontent);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            return new String(filecontent, encoding);
        } catch (UnsupportedEncodingException e) {
            System.err.println("The OS does not support " + encoding);
            e.printStackTrace();
            return null;
        }
    }
}
