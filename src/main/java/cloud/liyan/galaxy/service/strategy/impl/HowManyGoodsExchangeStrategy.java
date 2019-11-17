package cloud.liyan.galaxy.service.strategy.impl;

import org.apache.commons.lang3.StringUtils;

import cloud.liyan.galaxy.service.strategy.Strategy;
import cloud.liyan.galaxy.util.constant.Constants;
import cloud.liyan.galaxy.util.enums.CommandEnum;

/**
 * @author liyan
 * @description
 * @date 2019-11-08 15:05
 */
public class HowManyGoodsExchangeStrategy implements Strategy {
    @Override
    public CommandEnum getCommandEnum() {
        return CommandEnum.HOW_MANY_GOODS_EXCHANGE_COMMAND;
    }

    @Override
    public boolean isMatchStrategy(String command) {
        if (StringUtils.isBlank(command)) {
            return false;
        }
        String[] values = command.trim().split(Constants.SEPARATOR_REGEX);
        return command.toLowerCase().startsWith(Constants.HOW_MANY_GOODS_EXCHANGE_SYMBOLE_PRE)
            && (!command.toLowerCase().startsWith(Constants.HOW_MANY_SYMBOLE_PRE)) && values.length > 4;
    }
}
