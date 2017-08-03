package com.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil extends BaseUtil {

    /**
     * YYYY-MM-DD日期格式的校验正则表达式
     */
    public static final Pattern DATE_PATTERN_YYYY_MM_DD = Pattern.compile("^((((1[6-9]|[2-9]\\d)\\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\\d|3[01]))|(((1[6-9]|[2-9]\\d)\\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\\d|30))|(((1[6-9]|[2-9]\\d)\\d{2})-0?2-(0?[1-9]|1\\d|2[0-8]))|(((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-))$");


    private RegexUtil() {
        //工具类无需对象实例化
    }

    /**
     * 是否匹配指定正则表达式
     *
     * @param source
     * @param pattern
     * @return
     */
    public static boolean isMatch(String source, String pattern) {
        return isMatch(source, Pattern.compile(pattern));
    }

    public static boolean isMatch(String source, Pattern pattern) {
        return pattern.matcher(source).find();
    }

    /**
     * 返回正式表达式匹配的第1组内容
     *
     * @param source
     * @param regexPattern
     * @return
     */
    public static String getMatchFirstGroupValue(String source,
                                                 String regexPattern) {
        Pattern r = Pattern.compile(regexPattern);
        Matcher m = r.matcher(source);
        if (m.find()) {
            return m.group();
        }
        return null;
    }

    /**
     * 格式化回车换行符（注：windows中换行\r\n，linux下为\n，本方法统一替换成\n）
     *
     * @param src
     * @return
     */
    public static String formatReturn(String src) {
        return src.replaceAll("[\n|\r|\r\n|\n\r]+", "\n");
    }

}
