package com.hundsun.common.util;

import cn.hutool.core.util.StrUtil;
import org.apache.commons.codec.binary.Base64;

import java.io.*;

/**
 * Created by jiayq24996 on 2019-06-05
 */
public class Base64Util {

    public static String str2Base64(String str) {
        if (StrUtil.isBlank(str)){
            return null;
        }
        try {
            return Base64.encodeBase64String(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 将文件转换成base64编码格式
     *
     * @param filePath
     * @return
     */

    public static String encodeBase64String(String filePath) {
        return Base64.encodeBase64String(getFileByte(filePath));
    }

    /**
     * 将base64编码的字符串解码成文件
     *
     * @param base64Str
     * @param targetPath
     * @return
     * @since Ver 3.0
     */
    public static boolean decodeBase64(String base64Str, String targetPath) {
        if (base64Str == null) {
            return false;
        }
        OutputStream out = null;
        InputStream in = null;
        //一次取出的字节数大小,缓冲区大小
        byte[] buffer = new byte[10240];
        try {
            byte[] bytes = Base64.decodeBase64(base64Str);
            in = new ByteArrayInputStream(bytes);
            out = new FileOutputStream(targetPath);
            int n = 0;
            //numberRead的目的在于防止最后一次读取的字节小于buffer长度，否则会自动被填充0
            while ((n = in.read(buffer)) != -1) {
                out.write(buffer, 0, n);
            }
            out.flush();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (Exception e) {

            }
        }
    }

    /**
     * 获取文件字节
     *
     * @param filePath
     * @return
     */
    public static byte[] getFileByte(String filePath) {
        byte[] data = null;
        try {
            InputStream in = new FileInputStream(filePath);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    /**
     * 获取文件字符内容
     *
     * @param filePath
     * @return
     */
    public static String getFileStr(String filePath) {
        try {
            return new String(getFileByte(filePath), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Base64Util.encodeBase64String("D:\\gg.jpg"));
    }

}
