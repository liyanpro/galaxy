package cloud.liyan.galaxy.service.strategy;

import cloud.liyan.galaxy.util.enums.CommandEnum;

/**
 * @author liyan
 * @description
 * @date 2019-10-10 20:05
 */
public interface Strategy {

    /**
     * 返回指令枚举
     * @return
     */
    CommandEnum getCommandEnum();

    /**
     * 指令是否匹配当前策略
     * @param command
     * @return
     */
    boolean isMatchStrategy(String command);
}
