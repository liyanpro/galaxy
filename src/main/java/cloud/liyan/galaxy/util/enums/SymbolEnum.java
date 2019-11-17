package cloud.liyan.galaxy.util.enums;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * @author liyan
 * @description
 * @date 2019-10-11 12:06
 */
public enum SymbolEnum {

    I("I", 1),

    IV("IV", 4),

    V("V", 5),

    IX("IX", 9),

    X("X", 10),

    XL("XL", 40),

    L("L", 50),

    XC("XC", 90),

    C("C", 100),

    CD("CD", 400),

    D("D", 500),

    CM("CM", 900),

    M("M", 1000);

    /**
     * 罗马符号
     */
    private String symbol;

    /**
     * 10进制数
     */
    private Integer number;

    /***
     * 构造方法
     * 
     * @param symbol
     * @param number
     */
    SymbolEnum(String symbol, Integer number) {
        this.symbol = symbol;
        this.number = number;
    }

    /**
     * 货币字符串 转化为 货币枚举
     * 
     * @param symbol
     * @return
     */
    public static SymbolEnum strConvertToEnum(String symbol) {
        if (StringUtils.isBlank(symbol)) {
            return null;
        }
        for (SymbolEnum symbolEnum : SymbolEnum.values()) {
            if (symbolEnum.symbol.equals(symbol)) {
                return symbolEnum;
            }
        }
        return null;
    }

    public static List<SymbolEnum> symbolSort() {
        List<SymbolEnum> symbols = Arrays.asList(SymbolEnum.values());
        Collections.sort(symbols, new Comparator<SymbolEnum>() {
            @Override
            public int compare(SymbolEnum o1, SymbolEnum o2) {
                return Integer.compare(o2.getNumber().intValue(), o1.getNumber().intValue());
            }
        });
        return symbols;
    }

    public String getSymbol() {
        return symbol;
    }

    public Integer getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return String.format("[symbol=%s, number=%s]", symbol, number);
    }

}
