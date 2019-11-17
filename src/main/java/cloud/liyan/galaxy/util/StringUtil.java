package cloud.liyan.galaxy.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import cloud.liyan.galaxy.util.constant.Constants;

/**
 * @author liyan
 * @description
 * @date 2019-10-11 13:08
 */
public class StringUtil {

    private static Pattern PATTERN_NUM = Pattern.compile("^(\\-|\\+)?\\d+(\\.\\d+)?$");

    /**
     * 根据索引截取数组
     * 
     * @param beginIndex
     * @param endIndex
     * @param values
     * @return
     */
    public static String[] subStringFromIndex(int beginIndex, int endIndex, String[] values) {
        if (values == null || beginIndex < 0 || endIndex > values.length) {
            return new String[1];
        }
        StringBuffer buffer = new StringBuffer();
        for (int i = beginIndex; i <= endIndex; i++) {
            buffer.append(values[i]).append(",");
        }
        String str = buffer.toString();
        return str.substring(0, str.length() - 1).split(",");
    }

    /**
     * 根据索引截取数组
     * 
     * @param beginIndex
     * @param endIndex
     * @param values
     * @return
     */
    public static List<String> subStrArrayToList(int beginIndex, int endIndex, String[] values) {
        List<String> array = new ArrayList<String>();
        if (beginIndex < 0 || endIndex < 0 || endIndex > values.length) {
            return array;
        }
        for (int i = beginIndex; i <= endIndex; i++) {
            array.add(values[i]);
        }
        return array;
    }

    /**
     * 字符串转整型
     * 
     * @param str
     * @return
     */
    public static int parseInt(String str) {
        int rtn = 0;
        try {
            if (StringUtils.isNotBlank(str)) {
                Matcher isNum = PATTERN_NUM.matcher(str);
                if (isNum.matches()) {
                    rtn = Integer.valueOf(str);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rtn;
    }

    /**
     * 校验罗马数字匹配规则
     * 
     * @param roman
     * @return
     */
    public static boolean validateRoman(String roman) {
        Pattern pattern = Pattern.compile(Constants.ROMAN_SYMBOL_REGEX);
        Matcher matcher = pattern.matcher(roman);
        return matcher.matches();
    }
}
