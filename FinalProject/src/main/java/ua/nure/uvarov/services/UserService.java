package ua.nure.uvarov.services;


import ua.nure.uvarov.entity.User;

public interface UserService {

    boolean isExist(String login);

    long create(User user);

    boolean isAuthorize(User user);

    User read(String login);

    User read(int id);

    boolean isBlocked(String login);

    boolean unblock(String login);

    boolean block(String login);

    User tryToLogIn(User userBean);

}
