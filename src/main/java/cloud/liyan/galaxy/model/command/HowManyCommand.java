package cloud.liyan.galaxy.model.command;

import cloud.liyan.galaxy.model.GoodsExchange;
import cloud.liyan.galaxy.util.StringUtil;
import cloud.liyan.galaxy.util.constant.Constants;

/**
 * @author liyan
 * @description
 * @date 2019-10-11 12:11
 */
public class HowManyCommand extends Command {

    public HowManyCommand(String command) {
        super(command);
    }

    @Override
    public GoodsExchange execute() {

        GoodsExchange goodsExchange = new GoodsExchange();
        String[] values = this.getCommand().trim().split(Constants.SEPARATOR_REGEX);
        if (values.length > 4) {
            goodsExchange.setAliasName(StringUtil.subStringFromIndex(4, values.length - 3, values));
            goodsExchange.setGoodsName(values[values.length - 2]);
        }
        return goodsExchange;
    }

}
