package cloud.liyan.galaxy.model;

import cloud.liyan.galaxy.util.enums.SymbolEnum;

/**
 * @author liyan
 * @description
 * @date 2019-10-11 11:08
 */
public class RomanAlias {
    /**
     * 罗马货币的别名
     */
    private String alias;

    /**
     * 罗马货币
     */
    private String symbol;

    /**
     * 货币枚举
     */
    private SymbolEnum symbolEnum;

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public SymbolEnum getSymbolEnum() {
        return symbolEnum;
    }

    public void setSymbolEnum(SymbolEnum symbolEnum) {
        this.symbolEnum = symbolEnum;
    }
}
