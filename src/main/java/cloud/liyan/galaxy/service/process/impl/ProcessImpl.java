package cloud.liyan.galaxy.service.process.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import cloud.liyan.galaxy.exception.HandleException;
import cloud.liyan.galaxy.model.Goods;
import cloud.liyan.galaxy.model.GoodsExchange;
import cloud.liyan.galaxy.model.RomanAlias;
import cloud.liyan.galaxy.model.command.AliasCommand;
import cloud.liyan.galaxy.model.command.ExchangeCommand;
import cloud.liyan.galaxy.model.command.HowManyCommand;
import cloud.liyan.galaxy.model.command.HowMuchCommand;
import cloud.liyan.galaxy.service.calculate.CalculateFactory;
import cloud.liyan.galaxy.service.calculate.CurrencyCalculator;
import cloud.liyan.galaxy.service.calculate.GoodsCalculator;
import cloud.liyan.galaxy.service.process.Process;
import cloud.liyan.galaxy.util.constant.Constants;
import cloud.liyan.galaxy.util.enums.ExceptionEnum;

/**
 * @author liyan
 * @description
 * @date 2019-10-11 11:40
 */
public class ProcessImpl implements Process {

    private CurrencyCalculator currencyCalculator;
    private GoodsCalculator goodsCalculator;

    public ProcessImpl() {
        currencyCalculator = CalculateFactory.getInstance().buildCalcultor(CurrencyCalculator.class);
        goodsCalculator = CalculateFactory.getInstance().buildCalcultor(GoodsCalculator.class);
    }

    @Override
    public void processCurrencyAlias(String command) {
        RomanAlias romanAlias = new AliasCommand(command).execute();
        this.currencyCalculator.storeSymbol(romanAlias);
    }

    @Override
    public void processCurrencyExchange(String command) {
        GoodsExchange goodsExchange = new ExchangeCommand(command).execute();
        goodsCalculator.storeGoodsExchanges(goodsExchange);
    }

    @Override
    public void processHowMuch(String command) {
        List<String> aliasList = new HowMuchCommand(command).execute();
        List<String> symbols = currencyCalculator.exchangeAlias(aliasList);
        int number = currencyCalculator.convertToNumber(symbols);
        writeHowMuchOutput(aliasList, number);
    }

    @Override
    public void processHowMany(String command) {
        GoodsExchange goodsExchange = new HowManyCommand(command).execute();
        Goods goods = goodsCalculator.getGoodsCredits(goodsExchange.getGoodsName());
        int exchange = currencyCalculator.exchangeCurrency(goodsExchange);
        double credits = exchange * goods.getCredits() % goods.getExchange();
        if (credits != 0) {
            throw new HandleException(ExceptionEnum.CREDITS_NOT_INTEGER_EXCEPTION, String.valueOf(credits));
        }
        writeHowManyOutput(goodsExchange, exchange * goods.getCredits() / goods.getExchange());
    }

    @Override
    public void processInvalidCommand(String command) {
        System.out.println(Constants.INVALID_OUTPUT_DATA);
    }

    @Override
    public void writeHowMuchOutput(List<String> aliasList, Integer number) {
        String pattern = StringUtils.join(aliasList, " ");
        String output = String.format(Constants.HOW_MUCH_OUTPUT_FORMATTER, pattern, number);
        System.out.println(output);
    }

    @Override
    public void writeHowManyOutput(GoodsExchange goodsExchange, Integer credits) {
        String pattern = goodsExchange.buildOutputPattern();
        String output = String.format(Constants.HOW_MANY_OUTPUT_FORMATTER, pattern, credits);
        System.out.println(output);
    }

}
