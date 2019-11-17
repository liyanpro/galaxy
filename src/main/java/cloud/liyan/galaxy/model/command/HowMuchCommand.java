package cloud.liyan.galaxy.model.command;

import java.util.ArrayList;
import java.util.List;

import cloud.liyan.galaxy.util.StringUtil;
import cloud.liyan.galaxy.util.constant.Constants;

/**
 * @author liyan
 * @description
 * @date 2019-10-11 12:15
 */
public class HowMuchCommand extends Command {

    public HowMuchCommand(String command) {
        super(command);
    }

    @Override
    public List<String> execute() {
        List<String> alias = new ArrayList<String>();
        String[] values = this.getCommand().trim().split(Constants.SEPARATOR_REGEX);
        if (values.length > 3) {
            alias = StringUtil.subStrArrayToList(3, values.length - 2, values);
        }
        return alias;
    }
}
