package cloud.liyan.galaxy.model.command;

import cloud.liyan.galaxy.model.RomanAlias;
import cloud.liyan.galaxy.util.constant.Constants;
import cloud.liyan.galaxy.util.enums.SymbolEnum;

/**
 * @author liyan
 * @description
 * @date 2019-10-11 12:04
 */
public class AliasCommand extends Command {

    public AliasCommand(String command) {
        super(command);
    }

    @Override
    public RomanAlias execute() {
        RomanAlias romanAlias = new RomanAlias();
        String[] values = this.getCommand().trim().split(Constants.SEPARATOR_REGEX);
        romanAlias.setAlias(values[0]);
        romanAlias.setSymbol(values[2]);
        romanAlias.setSymbolEnum(SymbolEnum.strConvertToEnum(values[2]));
        return romanAlias;
    }
}
