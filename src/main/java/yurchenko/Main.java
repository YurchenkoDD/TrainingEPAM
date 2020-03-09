package yurchenko;

import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args){
        Tasks task = new Tasks();
        List<Human> humansList = task.fillList();
        List<User> users = task.fillUsers();
        HashMap<Integer, String> footballers = task.fillMap();
        task.printCollection(humansList);
        task.findDoubles(humansList);
        task.removeDoubles(humansList);
        task.sortByFio(humansList);
        task.sortByAge(humansList);
        task.sortByAddress(humansList);
        task.greetUsers(users);
        task.sortByKey(footballers);
        task.sortByValue(footballers);
        task.randLinkList();
    }
}
