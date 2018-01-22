package ua.nure.uvarov.services;


import org.apache.log4j.Logger;
import ua.nure.uvarov.dao.UserDao;
import ua.nure.uvarov.entity.User;
import ua.nure.uvarov.transaction.DBManager;


public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private DBManager dbManager;
    private static final Logger LOG = Logger.getLogger(UserServiceImpl.class);

    public UserServiceImpl(UserDao userDao, DBManager dbManager) {
        this.userDao = userDao;
        this.dbManager = dbManager;
    }

    @Override
    public boolean isExist(String email) {
        return dbManager.execute(() -> userDao.isExist(email));
    }

    @Override
    public long create(User user) {
        return dbManager.execute(() -> {
            user.setPassword(user.getPassword());
            return userDao.create(user);
        });
    }

    @Override
    public boolean isAuthorize(User user) {
        return dbManager.execute(() -> {

            user.setPassword(user.getPassword());
            return userDao.getUserByEmailAndPassword(user);
        });
    }

    @Override
    public User read(String email) {
        return dbManager.execute(() -> userDao.getUserByEmail(email));
    }

    @Override
    public User read(int id) {
        return dbManager.execute(() -> userDao.getById(id));
    }

    @Override
    public boolean isBlocked(String email) {
        return dbManager.execute(() -> userDao.isBlocked(email));
    }


    @Override
    public boolean unblock(String email) {
        return dbManager.execute(() -> userDao.changeBlockStatus(email, false));
    }


    @Override
    public boolean block(String login) {
        return dbManager.execute(() ->
                userDao.changeBlockStatus(login, true));
    }

    @Override
    public User tryToLogIn(User userBean) {
        return dbManager.execute(() -> {
            if (userDao.isExist(userBean.getEmail())) {
                User user = userDao.getUserByEmail(userBean.getEmail());
                LOG.debug(user);
                if (user != null) {
                    if (!user.isBlocked()) {
                        userBean.setPassword(userBean.getPassword());
                        if (userDao.getUserByEmailAndPassword(userBean)) {
                            return user;
                        }
                    }
                    }
                }
            return null;
        });
    }
}
