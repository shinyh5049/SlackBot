package ac.knu.service;

import org.junit.Test;

import static org.junit.Assert.*;

public class CommandParsingServiceTest {
    @Test
    public void bot_should_understand_list_command () {
        CommandParsingService commandParsingService = new CommandParsingService();
        String command = commandParsingService.parseCommand("add");
        assertTrue(command.equalsIgnoreCase("add"));
    }
}