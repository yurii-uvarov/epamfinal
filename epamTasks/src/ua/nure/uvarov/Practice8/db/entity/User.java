package ua.nure.uvarov.Practice8.db.entity;

public class User {
    private int id;
    private String login;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String name) {
        this.login = name;
    }

    @Override
    public String toString() {
        return  login ;
    }
    public static User createUser(String login){
        User user = new User();
        user.setLogin(login);
        return user;
    }
}

