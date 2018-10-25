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
        Friends f1 = new Friends("6조", Gender.MAN, 15);
        Friends f2 = new Friends("경호", Gender.MAN, 24);
        friendslist.add(f1);
        friendslist.add(f2);

    }

    public String parseCommand(String list) {
        String[] result;
        result = list.split(" ");
        String str = "";

        if (result[1].equals(commandlist.get(0))) {
            return "addFriends";
        } else if (result[1].equals(commandlist.get(1))) {
            if (friendslist.isEmpty()) {
                return "친구가 없습니다.";
            }
            else {
                for (int i = 0; i < friendslist.size(); i++) {
                    str += friendslist.get(i).getName() + " " + friendslist.get(i).getGender() + " " + friendslist.get(i).getAge() + "\n";
                }
                return str;
            }
        } else if (result[1].equals(commandlist.get(2))) {
            return "friendsRemove";
        } else if (result[1].equals(commandlist.get(3))) {
            return "findFriends";
        }
        return "failed";
    }


}
