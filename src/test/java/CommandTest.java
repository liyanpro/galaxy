import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cloud.liyan.galaxy.controller.GalaxyController;

/**
 * @author liyan
 * @description
 * @date 2019-10-12 17:56
 */
public class CommandTest {

    private static String fileName = "input-test.txt";

    private List<String> commands;

    @Before
    public void readCommand() {
        commands = GalaxyController.readLines(fileName);
    }

    @Test
    public void splitCommand() {
        commands.stream().filter(command -> StringUtils.isNotBlank(command))
            .forEach(command -> System.out.println(GalaxyController.matchCommand(command) + "\t" + command));
    }

    @After
    public void executeCommand() {
        GalaxyController galaxyController = new GalaxyController();
        commands.stream().forEach(command -> galaxyController.analyzeCommand(command));
    }

}
