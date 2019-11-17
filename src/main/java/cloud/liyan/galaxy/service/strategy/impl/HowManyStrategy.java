package cloud.liyan.galaxy.service.strategy.impl;

import org.apache.commons.lang3.StringUtils;

import cloud.liyan.galaxy.service.strategy.Strategy;
import cloud.liyan.galaxy.util.constant.Constants;
import cloud.liyan.galaxy.util.enums.CommandEnum;

/**
 * @author liyan
 * @description 商品价值策略
 * @date 2019-10-12 11:15
 */
public class HowManyStrategy implements Strategy {
    @Override
    public CommandEnum getCommandEnum() {
        return CommandEnum.HOW_MANY_COMMAND;
    }

    @Override
    public boolean isMatchStrategy(String command) {
        if (StringUtils.isBlank(command)) {
            return false;
        }
        String[] values = command.trim().split(Constants.SEPARATOR_REGEX);
        return command.toLowerCase().startsWith(Constants.HOW_MANY_SYMBOLE_PRE) && values.length > 4;
    }
}
