package com.jiyiren.mvnspdemo.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class StringHelper {
	
	/**
	 * 简单判断字符串是否为空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
        return str == null || str.equals("null") || str.trim().equals("");
    }
	
	/**
     * 严格判断字符串的是否为空
     *
     * @param input
     * @return 0不为空且没有空字符串，1为空，2不为空但是包含空字符
     */
    public static int isStrictEmpty(String input) {
        if ( input == null || "".equals( input ) ||input.length()==0)
            return 1;
        for ( int i = 0; i < input.length(); i++ ) {
            char c = input.charAt( i );
            if ( c == ' ' || c == '\t' || c == '\r' || c == '\n' ) {
                return 2;

            }
        }
        return 0;
    }
	
	/**
     * 去除大部分的空格，制表符，回车等空格
     */
    public static String getDeleteSpaceStr(String str){
        return str.replaceAll("\\s*", "");
    }

    /**
     * 校验密码
     * 6-16位
     * @param password
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isPasswordValid(String password) {
        return Pattern.matches("^[a-zA-Z0-9]{6,16}$", password);
    }
    
    /** 
     * 大陆号码或香港号码均可 
     */  
    public static boolean isPhoneLegal(String str)throws PatternSyntaxException {  
        return isChinaPhoneLegal(str) || isHKPhoneLegal(str);  
    }  
    /** 
     * 大陆手机号码11位数，匹配格式：前三位固定格式+后8位任意数 
     * 此方法中前三位格式有： 
     * 13+任意数 
     * 15+除4的任意数 
     * 18+除1和4的任意数 
     * 17+除9的任意数 
     * 147 
     */  
    public static boolean isChinaPhoneLegal(String str) throws PatternSyntaxException {  
        String regExp = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";  
        Pattern p = Pattern.compile(regExp);  
        Matcher m = p.matcher(str);  
        return m.matches();  
    }  
    
    /** 
     * 香港手机号码8位数，5|6|8|9开头+7位任意数 
     */  
    public static boolean isHKPhoneLegal(String str)throws PatternSyntaxException {  
        String regExp = "^(5|6|8|9)\\d{7}$";  
        Pattern p = Pattern.compile(regExp);  
        Matcher m = p.matcher(str);  
        return m.matches();  
    }  

    /**
     * 验证email格式
     */
    public static boolean isEmail(String email) {
        String regex = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
        return email.matches(regex);
    }
    
    /**
     * 获取sha1值
     *
     * @param str 需要sha1的字符串
     * @return sha1之后的字符串
     */
    public static String getSha1(String str) {
        if (null == str || 0 == str.length()) {
            return null;
        }
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
            mdTemp.update(str.getBytes("UTF-8"));

            byte[] md = mdTemp.digest();
            int j = md.length;
            char[] buf = new char[j * 2];
            int k = 0;
            for (byte byte0 : md) {
                buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
                buf[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(buf);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    /**
     * 生成随机字符串
     *
     * @param length 生成字符串的长度
     * @return 随机字符串
     */
    public static String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
    
    /**
     * md5加密
     * @param buffer 字符串
     * @return
     */
    public static String MD5(String buffer) {
        return MD5(buffer.getBytes());
    }

    /**
     * md5加密
     * @param buffer 字节数组
     * @return
     */
    public static String MD5(byte[] buffer) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(buffer);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (byte byte0 : md) {
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }
}
