package cloud.liyan.galaxy.util;

import java.util.List;
import java.util.Optional;

import cloud.liyan.galaxy.util.enums.SymbolEnum;

/**
 * @author liyan
 * @description
 * @date 2019-10-10 19:53
 */
public class ArithmeticUtil {

    /**
     * 按罗马计数规则计算数值
     * 
     * @param roman
     * @return
     */
    public static int convertRomanToNumber(String roman) {
        int sum = 0;
        int i = 0;
        while (i < roman.length()) {
            // 将首字母对应的单个字符转化为阿拉伯数字
            int number = SymbolEnum.strConvertToEnum(Character.valueOf(roman.charAt(i)).toString()).getNumber();
            i++;
            if (i == roman.length()) {
                // 匹配一次，恰好结束
                sum += number;
            } else {
                // 匹配当前字符的下一个字符
                // (1)如果下一个字符比当前字符大，说明这是减操作， 下一个字符 - 当前字符
                // (2)没有匹配到下一个货币符号，直接相加
                SymbolEnum nextEnum = SymbolEnum.strConvertToEnum(Character.valueOf(roman.charAt(i)).toString());
                Optional.ofNullable(nextEnum);
                if (nextEnum == null) {
                    sum = 0;
                    break;
                }
                Integer nextNumber = nextEnum.getNumber();
                if (nextNumber > number) {
                    sum += (nextNumber - number);
                    i++;
                } else {
                    sum += number;
                }
            }
        }
        return sum;
    }

    /**
     * 将数字转化为货币
     * 
     * @param number
     * @return
     */
    public static String convertNumberToRoman(int number) {
        StringBuilder symbol = new StringBuilder();
        List<SymbolEnum> symbolEnums = SymbolEnum.symbolSort();
        for (SymbolEnum symbolEnum : symbolEnums) {
            Integer value = symbolEnum.getNumber();
            while (number >= value.intValue()) {
                symbol.append(symbolEnum.getSymbol());
                number -= value;
            }
        }
        return symbol.toString();
    }
}
