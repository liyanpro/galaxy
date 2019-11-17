package cloud.liyan.galaxy.service.process;

import java.util.List;

import cloud.liyan.galaxy.model.GoodsExchange;

/**
 * @author liyan
 * @description
 * @date 2019-10-11 11:39
 */
public interface Process {

    /**
     * 处理货币别名指令
     * 
     * @param command
     */
    void processCurrencyAlias(String command);

    /**
     * 处理货币兑换指令
     * 
     * @param command
     */
    void processCurrencyExchange(String command);

    /**
     * 处理how much指令
     * 
     * @param command
     */
    void processHowMuch(String command);

    /**
     * 处理 how many 指令
     * 
     * @param command
     */
    void processHowMany(String command);

    /**
     * 处理 无效指令
     * 
     * @param command
     */
    void processInvalidCommand(String command);

    /**
     * 输出 how much 货币兑换结果
     * 
     * @param aliasList
     *            原始货币别名列表
     * @param number
     *            兑换过来的阿拉伯数字
     */
    void writeHowMuchOutput(List<String> aliasList, Integer number);

    /**
     * 输出 how many 货币兑换结果
     * 
     * @param goodsExchange
     *            货币与星际商品 兑换描述关系
     * @param credits
     *            兑换过来的总价
     */
    void writeHowManyOutput(GoodsExchange goodsExchange, Integer credits);
}
