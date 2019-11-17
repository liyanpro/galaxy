package cloud.liyan.galaxy.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import cloud.liyan.galaxy.exception.GalaxyException;
import cloud.liyan.galaxy.exception.HandleException;
import cloud.liyan.galaxy.exception.InputException;
import cloud.liyan.galaxy.service.process.impl.ProcessImpl;
import cloud.liyan.galaxy.service.strategy.Strategy;
import cloud.liyan.galaxy.service.strategy.impl.*;
import cloud.liyan.galaxy.util.constant.Constants;
import cloud.liyan.galaxy.util.enums.CommandEnum;

/**
 * @author liyan
 * @description
 * @date 2019-10-12 10:58
 */
public class GalaxyController {

    private static ProcessImpl process = new ProcessImpl();
    private static List<Strategy> strategies = new ArrayList<>();

    static {
        strategies.add(new AliasStrategy());
        strategies.add(new GoodsExchangeStrategy());
        strategies.add(new HowManyStrategy());
        strategies.add(new HowMuchStrategy());
        strategies.add(new HowManyGoodsExchangeStrategy());
    }

    public void readCommand() throws HandleException {
        List<String> commands = readLines(Constants.INPUT_COMMAND_NAME);
        commands.stream().filter(command -> StringUtils.isNotBlank(command))
            .forEach(command -> analyzeCommand(command.trim()));
    }

    public void analyzeCommand(String command) throws HandleException {
        CommandEnum commandEnum = matchCommand(command);
        switch (commandEnum) {
            case ALIAS_COMMAND:
                process.processCurrencyAlias(command);
                break;
            case CURRENCY_EXCHANGE_COMMAND:
                process.processCurrencyExchange(command);
                break;
            case HOW_MUCH_COMMAND:
                process.processHowMuch(command);
                break;
            case HOW_MANY_COMMAND:
                process.processHowMany(command);
                break;
            case INVALID_COMMAND:
                process.processInvalidCommand(command);
                break;
            default:
                break;
        }
    }

    /**
     * 指令匹配
     * 
     * @param command
     * @return
     */
    public static CommandEnum matchCommand(String command) {
        for (Strategy strategy : strategies) {
            if (strategy.isMatchStrategy(command)) {
                return strategy.getCommandEnum();
            }
        }
        return CommandEnum.INVALID_COMMAND;
    }

    public static List<String> readLines(String fileName) throws InputException {
        // BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            // String command = reader.readLine();
            InputStream inputStream = FileUtils.class.getClassLoader().getResourceAsStream(fileName);
            if (inputStream == null) {
                throw new InputException("the file " + fileName + " is not exist!");
            }
            List<String> commands = IOUtils.readLines(inputStream, Charset.forName(Constants.UTF8));
            return commands == null ? new ArrayList<>() : commands;
        } catch (InputException e) {
            throw e;
        } catch (IOException e) {
            throw new GalaxyException("read data error,fileName=" + fileName, e);
        }
    }

}
