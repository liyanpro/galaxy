package cloud.liyan.galaxy.start;

import cloud.liyan.galaxy.controller.GalaxyController;

/**
 * @author liyan
 * @description
 * @date 2019-10-12 12:37
 */
public class Application {
    public static void main(String[] args) {
        // 从文本读取指令，开始分析
        new GalaxyController().readCommand();
    }
}
