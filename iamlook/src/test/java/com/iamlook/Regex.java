package com.iamlook;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/***************************************
 * @Project notes
 * @Description
 * @Author yx
 * @Date 19-6-24
 * @Version 1.0
 ***************************************/
public class Regex {

    public final static String REGEX_POSITIVE_INTEGER = "^[0-9]{7,14}$"; //$NON-NLS-1$

    public static void main(String[] args) {

        System.out.println(test("1222225555550"));
    }

    public static boolean test(String value){
        return isMatch(REGEX_POSITIVE_INTEGER, value);
    }

    private static boolean isMatch(String regex, String orginal) {
        if (orginal == null || orginal.trim().equals("")) { //$NON-NLS-1$
            return false;
        }
        Pattern pattern = Pattern.compile(regex);
        Matcher isNum = pattern.matcher(orginal);
        return isNum.matches();
    }




}
