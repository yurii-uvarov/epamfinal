package ua.nure.uvarov.Practice8;

import ua.nure.uvarov.Practice8.db.DBException;
import ua.nure.uvarov.Practice8.db.DBManager;
import ua.nure.uvarov.Practice8.db.entity.Group;
import ua.nure.uvarov.Practice8.db.entity.User;

import java.util.List;

public class Demo {
    private static <T> void printList(List<T> list) {
        for (T element : list) {
            System.out.println(element);
        }
    }

    public static void main(String[] args) throws DBException {
        DBManager dbManager = DBManager.getInstance();

        dbManager.insertUser(User.createUser("NumberOne"));
       // dbManager.insertUser(User.createUser("petrov"));
       // dbManager.insertUser(User.createUser("obama"));
        //dbManager.insertUser(User.createUser("ivanov"));

        printList(dbManager.findAllUsers());

        dbManager.createGroup(Group.createGroup("NumberTwo"));
       // dbManager.createGroup(Group.createGroup("teamA"));
       // dbManager.createGroup(Group.createGroup("teamB"));
       // dbManager.createGroup(Group.createGroup("teamC"));
        System.out.println("------------------------------------------");
        printList(dbManager.findAllGroups());

       // User userPetrov = dbManager.getUser("petrov");
       // User userIvanov = dbManager.getUser("ivanov");
       // User userObama = dbManager.getUser("obama");
        User userNumberOne = dbManager.getUser("NumberOne");

      //  Group teamA = dbManager.getGroup("teamA");
       // Group teamB = dbManager.getGroup("teamB");
       // Group teamC = dbManager.getGroup("teamC");
        Group numberTwo = dbManager.getGroup("NumberTwo");
        Group numberFour = dbManager.getGroup("NumberFour");
        //dbManager.setGroupsForUser(userIvanov, teamA);
        //dbManager.setGroupsForUser(userPetrov, teamA, teamB);
       // dbManager.setGroupsForUser(userObama, teamA, teamB, teamC);
        dbManager.setGroupsForUser(userNumberOne, numberTwo, numberFour);

        for (User user : dbManager.findAllUsers()) {
            printList(dbManager.getUserGroups(user));
            System.out.println("~~~~~");
        }

        dbManager.deleteGroup(numberFour);
        numberTwo.setName("OLOLO");
        dbManager.updateGroup(numberTwo);


    }
}
