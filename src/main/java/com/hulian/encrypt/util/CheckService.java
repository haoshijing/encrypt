package com.hulian.encrypt.util;

import org.springframework.stereotype.Repository;

import java.security.MessageDigest;

@Repository
public class CheckService {

    public static void main(String[] args) {
        System.out.println("args = [" + createEncryptStr("A8-86-DD-90-72-D0") + "]");
    }

    public static String createEncryptStr(String str){
        return md5(getEncryptStr(str),true);
    }

    public static  boolean checkIsOk(String encryptStr,String baseStr){
        return createEncryptStr(baseStr).equalsIgnoreCase(encryptStr);
    }

    private static String getEncryptStr(String str){

        StringBuilder stringBuilder = new StringBuilder("");
        for(int i = 0; i < str.length();i++){
            char ch = str.charAt(i);
            if(ch == '-'){
                stringBuilder.append(ch);
            }else{
                int v = (hexCharToInt(str.charAt(i)) << 2)  ^ 0xef;
                String hv = Integer.toHexString(v);
                stringBuilder.append(hv);
            }
        }
        return stringBuilder.toString().toUpperCase();
    }

    private static int hexCharToInt(char ch){
        switch (ch){
            case '0':
                return 0;
            case '1':
                return 1;
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            case 'A':
            case 'a':
                return 10;
            case 'B':
            case 'b':
                return 11;

            case 'C':
            case 'c':
                return 12;

            case 'D':
            case 'd':
                return 13;

            case 'E':
            case 'e':
                return 14;

            case 'F':
            case 'f':
                return 15;
        }
        return 0;
    }


    private static String md5(String message,Boolean upper) {
        String md5str = "";
        try {
            // 1 创建一个提供信息摘要算法的对象，初始化为md5算法对象
            MessageDigest md = MessageDigest.getInstance("MD5");

            // 2 将消息变成byte数组
            byte[] input = message.getBytes("utf-8");

            // 3 计算后获得字节数组,这就是那128位了
            byte[] buff = md.digest(input);

            // 4 把数组每一字节（一个字节占八位）换成16进制连成md5字符串
            md5str = bytesToHex(buff);
            if(upper){
                md5str = md5str.toUpperCase();
            }else{
                md5str = md5str.toLowerCase();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return md5str;
    }

    /**
     * 二进制转十六进制
     *
     * @param bytes
     * @return
     */
    private static String bytesToHex(byte[] bytes) {
        StringBuffer md5str = new StringBuffer();
        // 把数组每一字节换成16进制连成md5字符串
        int digital;
        for (int i = 0; i < bytes.length; i++) {
            digital = bytes[i];

            if (digital < 0) {
                digital += 256;
            }
            if (digital < 16) {
                md5str.append("0");
            }
            md5str.append(Integer.toHexString(digital));
        }
        return md5str.toString().toUpperCase();
    }

}
