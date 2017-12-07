package com.soft.collection.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jinsh on 2017/12/6.
 */
public class StringHelper {
    /**
     * 返回单个字符串，若匹配到多个的话就返回第一个，方法与getSubUtil一样
     * @param soap
     * @param rgex
     * @return
     */
    public static String getSubUtilSimple(String soap,String rgex){
        Pattern pattern = Pattern.compile(rgex);// 匹配的模式
        Matcher m = pattern.matcher(soap);
        while(m.find()){
            return m.group(1);
        }
        return "";
    }
}
