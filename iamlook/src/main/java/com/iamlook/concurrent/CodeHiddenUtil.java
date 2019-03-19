package com.iamlook.concurrent;

/**
 * @Project_name: OnlineEvaluation
 * @Class: CodeHiddenUtil
 * @Auther: shenjianan
 * @Date: 2018/8/31 10:19
 * @Version: 1.0v
 * @Description: 普通加密工具
 */
public class CodeHiddenUtil {
    /**
     * 身份证加密
     * @param idCardNum
     * @param front
     * @param end
     * @return
     */
    public static String idMask(String idCardNum, int front, int end) {
        //身份证不能为空
        if (idCardNum.isEmpty()) { return null; }
        //需要截取的长度不能大于身份证号长度
        if ((front + end) > idCardNum.length()) { return null; }
        //需要截取的不能小于0
        if (front < 0 || end < 0) { return null; }
        //计算*的数量
        int asteriskCount = idCardNum.length() - (front + end);
        StringBuffer asteriskStr = new StringBuffer();
        for (int i = 0; i < asteriskCount; i++)
        {
            asteriskStr.append("*");
        }
        String regex = "(\\w{" + String.valueOf(front) + "})(\\w+)(\\w{" + String.valueOf(end) + "})";
        return idCardNum.replaceAll(regex, "$1" + asteriskStr + "$3");
    }


    public static void main(String[] args) {
        System.out.println(idMask("522426198706010151", 6, 4));
        System.out.println(subStringCN("我是一个小小鸟", 9));
    }
    /**
     * 字符串显示长度
     * @param str
     * @param maxLength
     * @return
     */
    public static String subStringCN(final String str, final int maxLength) {
        if (str == null) {
            return str;
        }
        String suffix = "...";
        int suffixLen = suffix.length();
        final StringBuffer sbuffer = new StringBuffer();
        final char[] chr = str.trim().toCharArray();
        int len = 0;
        for (int i = 0; i < chr.length; i++) {
            if (chr[i] >= 0xa1) {
                len += 2;
            } else {
                len++;
            }
        }
        if(len<=maxLength){
            return str;
        }
        len = 0;
        for (int i = 0; i < chr.length; i++) {
            if (chr[i] >= 0xa1) {
                len += 2;
                if (len + suffixLen > maxLength) {
                    break;
                }else {
                    sbuffer.append(chr[i]);
                }
            } else {
                len++;
                if (len + suffixLen > maxLength) {
                    break;
                }else {
                    sbuffer.append(chr[i]);
                }
            }
        }
        sbuffer.append(suffix);
        return sbuffer.toString();
    }
}
