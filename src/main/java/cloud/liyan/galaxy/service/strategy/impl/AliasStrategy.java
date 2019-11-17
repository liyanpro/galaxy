package cloud.liyan.galaxy.service.strategy.impl;

import org.apache.commons.lang3.StringUtils;

import cloud.liyan.galaxy.service.strategy.Strategy;
import cloud.liyan.galaxy.util.constant.Constants;
import cloud.liyan.galaxy.util.enums.CommandEnum;
import cloud.liyan.galaxy.util.enums.SymbolEnum;

/**
 * @author liyan
 * @description 罗马数字别名策略
 * @date 2019-10-12 11:12
 */
public class AliasStrategy implements Strategy {

    @Override
    public CommandEnum getCommandEnum() {
        return CommandEnum.ALIAS_COMMAND;
    }

    @Override
    public boolean isMatchStrategy(String command) {
        if (StringUtils.isBlank(command)) {
            return false;
        }
        String[] values = command.trim().split(Constants.SEPARATOR_REGEX);
        return Constants.SYMBOL_IS.equalsIgnoreCase(values[values.length - 2])
            && SymbolEnum.strConvertToEnum(values[values.length - 1]) != null;
    }

}
