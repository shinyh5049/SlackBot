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

    @Test
    public void remove_Friends () {
        CommandParsingService commandParsingService = new CommandParsingService();
        String result = (commandParsingService).parseCommand("<dsdss> remove mm");
        assertEquals(result, "친구목록이 비어있습니다.");
        commandParsingService.parseCommand("<dAD> add mm MAN 18");
        result = (commandParsingService).parseCommand("<dsdss> remove aa");
        assertEquals(result, "친구목록에 aa이 없습니다.");
        result = (commandParsingService).parseCommand("<dsdss> remove mm");
        assertEquals(result, "친구목록에서 mm이 삭제되었습니다.");
    }
    @Test
    public void find_Friends () {
        CommandParsingService commandParsingService = new CommandParsingService();
        commandParsingService.parseCommand("<DDSDS> add mm MAN 18");
        String result = (commandParsingService).parseCommand("<DSD> find aa");
        assertEquals(result, "There is no Data");
        result = (commandParsingService).parseCommand("<DSD> find mm");
        assertEquals(result, "mm MAN 18\n");
    }

    @Test
    public void add_Friends () {
        CommandParsingService commandParsingService = new CommandParsingService();
        commandParsingService.parseCommand("<ADAD> add mm MAN 18");
        String result = commandParsingService.parseCommand("<DSDS> list");
        assertEquals(result, "mm MAN 18\n");
        result = (commandParsingService).parseCommand("<DSD> add aa abcde 33");
        assertEquals(result, "잘못된 입력값입니다.");
        for (int i = 0; i < 10; i++) {
            (commandParsingService).parseCommand("<DSD> add aa WOMEN 33");
        }
        result = (commandParsingService).parseCommand("<DSD> add aa WOMEN 33");
        assertEquals(result, "리스트가 꽉 찼습니다.");
    }

}