package ac.knu.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommandParsingService {
    private List<String> commandlist = new ArrayList<>();
    private List<Friends> friendslist = new ArrayList<>();

    public CommandParsingService() {
        commandlist.add("add");
        commandlist.add("list");
        commandlist.add("remove");
        commandlist.add("find");

    }
    public String parseCommand(String list) {
        String[] result;
        result = list.split(" ");

        if (result[1].equals(commandlist.get(0))) {
            return "addFriends";
        } else if (result[1].equals(commandlist.get(1))) {
            return "friendsList";
        } else if (result[1].equals(commandlist.get(2))) {
            return "removeFriends";
        } else if (result[1].equals(commandlist.get(3))) {
            return "findFriends";
        }
        return "failed";
    }
}
