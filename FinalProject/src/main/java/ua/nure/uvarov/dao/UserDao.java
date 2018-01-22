package ua.nure.uvarov.dao;

import ua.nure.uvarov.entity.User;

public interface UserDao extends GenericDao<User> {
    boolean isExist(String email);

    boolean getUserByEmailAndPassword(User user);

    User getUserByEmail(String email);

    boolean isBlocked(String email);

    boolean changeBlockStatus(String email,boolean blocked);
}
