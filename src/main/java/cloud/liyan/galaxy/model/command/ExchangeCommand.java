package cloud.liyan.galaxy.model.command;

import cloud.liyan.galaxy.model.GoodsExchange;
import cloud.liyan.galaxy.util.StringUtil;
import cloud.liyan.galaxy.util.constant.Constants;

/**
 * @author liyan
 * @description
 * @date 2019-10-11 12:06
 */
public class ExchangeCommand extends Command {

    public ExchangeCommand(String command) {
        super(command);
    }

    @Override
    public GoodsExchange execute() {
        GoodsExchange goodExchange = new GoodsExchange();
        String[] values = this.getCommand().trim().split(Constants.SEPARATOR_REGEX);
        if (values.length > 4) {
            goodExchange.setAliasName(StringUtil.subStringFromIndex(0, values.length - 5, values));
            goodExchange.setGoodsName(values[goodExchange.getAliasName().length]);
            goodExchange.setCredits(StringUtil.parseInt(values[values.length - 2]));
        }
        return goodExchange;
    }
}
