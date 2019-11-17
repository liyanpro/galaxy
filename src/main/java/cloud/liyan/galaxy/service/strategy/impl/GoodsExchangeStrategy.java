package cloud.liyan.galaxy.service.strategy.impl;

import org.apache.commons.lang3.StringUtils;

import cloud.liyan.galaxy.service.strategy.Strategy;
import cloud.liyan.galaxy.util.constant.Constants;
import cloud.liyan.galaxy.util.enums.CommandEnum;

/**
 * @author liyan
 * @description 商品兑换策略
 * @date 2019-10-12 11:13
 */
public class GoodsExchangeStrategy implements Strategy {

    @Override
    public CommandEnum getCommandEnum() {
        return CommandEnum.CURRENCY_EXCHANGE_COMMAND;
    }

    @Override
    public boolean isMatchStrategy(String command) {
        if (StringUtils.isBlank(command)) {
            return false;
        }

        String[] values = command.trim().split(Constants.SEPARATOR_REGEX);
        return Constants.SYMBOL_IS.equalsIgnoreCase(values[values.length - 3])
            && Constants.SYMBOL_CREDITS.equalsIgnoreCase(values[values.length - 1]);
    }
}
