package ac.knu.service;

import org.junit.Test;

import static org.junit.Assert.*;

public class CommandParsingServiceTest {

    @Test
    public void friends_List () {
        CommandParsingService commandParsingService = new CommandParsingService();
        String result = commandParsingService.parseCommand("<dkdlel> list");
        assertTrue(result.equals("친구가 없습니다."));
        result = commandParsingService.parseCommand("<DADA> add mm MAN 18");
        assertEquals(result, "addFriends");
        result = commandParsingService.parseCommand("<DSDS> list");
        assertEquals(result, "mm MAN 18\n");
    }

}