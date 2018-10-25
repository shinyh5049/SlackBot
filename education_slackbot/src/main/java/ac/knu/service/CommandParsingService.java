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
        /*
        리스트 예시
        Friends f1 = new Friends("6조", Gender.MAN, 15);
        Friends f2 = new Friends("경호", Gender.MAN, 24);
        friendslist.add(f1);
        friendslist.add(f2);
        */

    }

    public String parseCommand(String list) {
        String[] result;
        result = list.split(" ");
        String str = "";

        if (result[1].equals(commandlist.get(0))) {
            if (friendslist.size() <= 10) {
                String name = result[2];
                Gender g;
                if (result[3] == "MAN") {
                    g = Gender.MAN;
                } else {
                    g = Gender.WOMEN;
                }
                int age = Integer.parseInt(result[4]);
                Friends friend = new Friends(name, g, age);
                friendslist.add(friend);
            } else
                return "리스트가 꽉 찼습니다.";
            return "addFriends";
        } else if (result[1].equals(commandlist.get(1))) {
            if (friendslist.isEmpty()) {
                return "친구가 없습니다.";
            } else {
                for (int i = 0; i < friendslist.size(); i++) {
                    str += friendslist.get(i).getName() + " " + friendslist.get(i).getGender() + " " + friendslist.get(i).getAge() + "\n";
                }
                return str;
            }
        } else if (result[1].equals(commandlist.get(2))) {
            String name = result[2];
            if (friendslist.size() <= 0) {
                return "친구목록이 비어있습니다.";
            } else if (friendslist.contains(name)) {
                for (int i = 0; i < friendslist.size(); i++) {
                    if (name.equalsIgnoreCase(friendslist.get(i).getName())) {
                        friendslist.remove(i);
                        return "친구목록에서 " + name + "이 삭제되었습니다.";
                    }
                }
            } else {
                return "친구목록에 " + name + "이 없습니다.";
            }
        } else if (result[1].equals(commandlist.get(3))) {
            //find sonmeone
            for (int i = 0; i < friendslist.size(); i++) {
                if (result[2].equals(friendslist.get(i).name))
                    return friendslist.get(i).getName() + " " + friendslist.get(i).getGender() + " " + friendslist.get(i).getAge() + "\n";
            }

            return "There is no Data";
        }
        return "failed";
    }


}
