package cloud.liyan.galaxy.service.calculate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import cloud.liyan.galaxy.exception.HandleException;
import cloud.liyan.galaxy.model.GoodsExchange;
import cloud.liyan.galaxy.model.RomanAlias;
import cloud.liyan.galaxy.util.ArithmeticUtil;
import cloud.liyan.galaxy.util.StringUtil;
import cloud.liyan.galaxy.util.enums.ExceptionEnum;
import cloud.liyan.galaxy.util.enums.SymbolEnum;

/**
 * @author liyan
 * @description 货币兑换计算器
 * @date 2019-10-11 13:39
 */
public class CurrencyCalculator {
    private static Map<String, String> cuurencyMap = new HashMap<>();

    /**
     * 存储罗马数字符号
     * 
     * @param romanAlias
     */
    public void storeSymbol(RomanAlias romanAlias) {
        cuurencyMap.put(romanAlias.getAlias(), romanAlias.getSymbol());
    }

    /**
     * 商品所占罗马货币份额
     * 
     * @param goodsExchange
     * @return
     */
    public int exchangeCurrency(GoodsExchange goodsExchange) {
        String[] alias = goodsExchange.getAliasName();
        StringBuffer buffer = new StringBuffer();
        if (alias != null && alias.length > 0) {
            for (int i = 0; i < alias.length; i++) {
                buffer.append(this.exchangeSymbol(alias[i]).getSymbol());
            }
        }
        if (!StringUtil.validateRoman(buffer.toString())) {
            throw new HandleException(ExceptionEnum.ROMAN_SYMBOL_ILLEGAL, buffer.toString());
        }
        return ArithmeticUtil.convertRomanToNumber(buffer.toString());
    }

    /**
     * 提取罗马数字符号
     * 
     * @param alias
     * @return
     */
    public SymbolEnum exchangeSymbol(String alias) {
        String symbol = cuurencyMap.get(alias);
        SymbolEnum symbolEnum = SymbolEnum.strConvertToEnum(symbol);
        if (symbol == null || symbolEnum == null) {
            throw new HandleException(ExceptionEnum.ALIAS_NOT_EXIST_EXCEPTION, alias);
        }
        return symbolEnum;
    }

    /**
     * 将别名对应到罗马数字
     * 
     * @param aliasList
     * @return
     */
    public List<String> exchangeAlias(List<String> aliasList) {
        List<String> symbols =
            aliasList.stream().map(alias -> exchangeSymbol(alias).getSymbol()).collect(Collectors.toList());
        if (aliasList == null) {
            return symbols;
        }
        return symbols;
    }

    public int convertToNumber(List<String> symbols) {
        String romanSymbol = StringUtils.join(symbols, "");
        if (!StringUtil.validateRoman(romanSymbol)) {
            throw new HandleException(ExceptionEnum.ROMAN_SYMBOL_ILLEGAL, romanSymbol);
        }
        return ArithmeticUtil.convertRomanToNumber(romanSymbol);
    }
}
