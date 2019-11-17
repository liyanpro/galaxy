package cloud.liyan.galaxy.service.calculate;

import java.util.HashMap;
import java.util.Map;

import cloud.liyan.galaxy.exception.HandleException;
import cloud.liyan.galaxy.model.Goods;
import cloud.liyan.galaxy.model.GoodsExchange;
import cloud.liyan.galaxy.util.enums.ExceptionEnum;

/**
 * @author liyan
 * @description 商品计算器
 * @date 2019-10-11 13:40
 */
public class GoodsCalculator {

    private Map<String, Goods> goodsCreditsMap = new HashMap<>();

    private CurrencyCalculator currencyCalculator =
        CalculateFactory.getInstance().buildCalcultor(CurrencyCalculator.class);

    public void storeGoodsExchanges(GoodsExchange goodsExchange) {
        String goodsName = goodsExchange.getGoodsName();
        int exchange = currencyCalculator.exchangeCurrency(goodsExchange);
        int credits = goodsExchange.getCredits();
        Goods goodsCredits = new Goods(goodsName, exchange, credits);
        goodsCreditsMap.put(goodsName, goodsCredits);
    }

    public Goods getGoodsCredits(String goodsName) {
        Goods goodsCredits = goodsCreditsMap.get(goodsName);
        if (goodsCredits == null) {
            throw new HandleException(ExceptionEnum.GOODS_NAME_NOT_EXIST_EXCEPTION, goodsName);
        }
        return goodsCredits;
    }
}
