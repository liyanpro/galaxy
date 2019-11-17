package cloud.liyan.galaxy.model.command;

/**
 * @author liyan
 * @description
 * @date 2019-10-11 12:00
 */
public abstract class Command {

    private String command;

    /**
     * 指令解析
     * 
     * @param command
     */
    public Command(String command) {
        this.command = command;
    }

    /**
     * 每种输入字符串，自身的解析逻辑
     * 
     * @return
     */
    public abstract Object execute();

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
}
