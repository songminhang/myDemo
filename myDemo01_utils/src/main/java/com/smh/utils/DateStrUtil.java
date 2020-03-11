package com.smh.utils;
import sun.security.krb5.internal.PAData;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 日期字符串转换工具类
 * @author ：smh
 * @description：TODO
 * @date ：2020/2/19 10:23
 */
public class DateStrUtil {

    public static String date2string(Date date,String pattern){
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String format = sdf.format(date);
        return format;
    }

    public static Date string2date(String str,String pattern) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date date = sdf.parse(str);
        return date;
    }

}
