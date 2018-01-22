package ua.nure.uvarov.Practice8.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import ua.nure.uvarov.Practice8.db.entity.Group;
import ua.nure.uvarov.Practice8.db.entity.User;

public class DBManager {

    private static final String URL = "jdbc:mysql://localhost/Mydb" + "?user=root&password=root" + "&useSSL=false";

    private static final String SQL_FIND_USER_BY_LOGIN = "SELECT * FROM users WHERE login=?";
    private static final String SQL_CREATE_NEW_USER = "INSERT INTO users VALUES (DEFAULT, ?)";
    private static final String SQL_UPDATE_USER = "UPDATE users SET login=?  WHERE id=?";
    private static final String SQL_DELETE_USER = "DELETE FROM users WHERE id=?";
    private static final String SQL_FIND_USER_GROUPS = "SELECT * FROM users_groups WHERE user_id=?";
    private static final String SQL_FIND_ALL_USERS = "SELECT * FROM users";

    private static final String SQL_CREATE_NEW_GROUP = "INSERT INTO groups VALUES (DEFAULT, ?)";
    private static final String SQL_FIND_GROUP_BY_NAME = "SELECT * FROM groups WHERE name=?";
    private static final String SQL_FIND_GROUP_BY_ID = "SELECT * FROM groups WHERE id=?";
    private static final String SQL_DELETE_GROUP = "DELETE FROM groups WHERE name =?";
    private static final String SQL_UPDATE_GROUP = "UPDATE groups SET name=? WHERE id=?";
    private static final String SQL_FIND_ALL_GROUPS = "SELECT * FROM groups";

    private static final String SQL_SET_GROUP_FOR_USER = "INSERT INTO users_groups VALUES (?, ?)";


    ///////////////////////////

    private static DBManager instance;

    public static synchronized DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
        }
        return instance;
    }

    private DBManager() {
        // nothing to do
    }

    /////////////////////////

    public Connection getConnection() throws SQLException {
        Connection con = DriverManager.getConnection(URL);
        return con;
    }

    ////////////////////////////

    public boolean updateUser(User user) throws DBException {
        boolean res = false;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(SQL_UPDATE_USER);

            int k = 1;
            pstmt.setString(k++, user.getLogin());
            pstmt.setInt(k++, user.getId());

            res = pstmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            // (1) write to log
            ex.printStackTrace();

            // (2)
            throw new DBException("Cannot update a user:" + user, ex);
        } finally {
            close(con);
        }
        return res;

    }


    public boolean deleteUser(int userId) throws DBException {
        boolean res = false;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(SQL_DELETE_USER);

            int k = 1;
            pstmt.setInt(k++, userId);

            res = pstmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            // (1) write to log
            ex.printStackTrace();

            // (2)
            throw new DBException("Cannot delete a user with id:" + userId, ex);
        } finally {
            close(con);
        }
        return res;

    }

    public boolean insertUser(User user) throws DBException {
        boolean res = false;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(SQL_CREATE_NEW_USER,
                    Statement.RETURN_GENERATED_KEYS);

            int k = 1;
            pstmt.setString(k++, user.getLogin());

            if (pstmt.executeUpdate() > 0) {
                rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    user.setId(rs.getInt(1));
                    res = true;
                }
            }
        } catch (SQLException ex) {
            // (1) write to log
            ex.printStackTrace();

            // (2)
            throw new DBException("Cannot create a user:" + user, ex);
        } finally {
            close(con);
        }
        return res;
    }

    public boolean createGroup(Group group) throws DBException {
        boolean res = false;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(SQL_CREATE_NEW_GROUP,
                    Statement.RETURN_GENERATED_KEYS);

            int k = 1;
            pstmt.setString(k++, group.getName());

            if (pstmt.executeUpdate() > 0) {
                rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    group.setId(rs.getInt(1));
                    res = true;
                }
            }
        } catch (SQLException ex) {
            // (1) write to log
            ex.printStackTrace();

            // (2)
            throw new DBException("Cannot create a group:" + group, ex);
        } finally {
            close(con);
        }
        return res;
    }

    public User getUser(String login) throws DBException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(SQL_FIND_USER_BY_LOGIN);
            int k = 1;
            pstmt.setString(k++, login);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return extractUser(rs);
            }
        } catch (SQLException ex) {
            // (1) write to log
            ex.printStackTrace();
            // log.error("Cannot obtain a user by login", ex);

            // (2)
            throw new DBException("Cannot obtain a user by login", ex);
        } finally {
            close(rs);
            close(pstmt);
            close(con);
        }
        return null;
    }

    public Group getGroup(String name) throws DBException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(SQL_FIND_GROUP_BY_NAME);

            int k = 1;
            pstmt.setString(k++, name);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                return extractGroup(rs);
            }
        } catch (SQLException ex) {
            // (1) write to log
            ex.printStackTrace();
            // log.error("Cannot obtain a user by login", ex);

            // (2)
            throw new DBException("Cannot obtain a group by name", ex);
        } finally {
            close(rs);
            close(pstmt);
            close(con);
        }
        return null;
    }

    public List<User> findAllUsers() throws DBException {
        List<User> users = new ArrayList<>();

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            stmt = con.createStatement();

            rs = stmt.executeQuery(SQL_FIND_ALL_USERS);

            while (rs.next()) {
                users.add(extractUser(rs));
            }
        } catch (SQLException ex) {
            // (1) write to log
            ex.printStackTrace();
            // log.error("Cannot obtain a user by login", ex);

            // (2)
            throw new DBException("Cannot obtain a user by login", ex);
        } finally {
            close(con);
        }
        return users;
    }

    public List<Group> findAllGroups() throws DBException {
        List<Group> groups = new ArrayList<>();

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            stmt = con.createStatement();

            rs = stmt.executeQuery(SQL_FIND_ALL_GROUPS);

            while (rs.next()) {
                groups.add(extractGroup(rs));
            }
        } catch (SQLException ex) {
            // (1) write to log
            ex.printStackTrace();
            // log.error("Cannot obtain a user by login", ex);

            // (2)
            throw new DBException("Cannot obtain a user by login", ex);
        } finally {
            close(con);
        }
        return groups;
    }

    //////////////////////
    // utils

    private User extractUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setLogin(rs.getString("login"));
        return user;
    }

    private Group extractGroup(ResultSet rs) throws SQLException {
        Group group = new Group();
        group.setId(rs.getInt("id"));
        group.setName(rs.getString("name"));
        return group;
    }

    private void close(AutoCloseable ac) {
        if (ac != null) {
            try {
                ac.close();
            } catch (Exception ex) {
                throw new IllegalStateException("Cannot close " + ac);
            }
        }
    }


    public boolean setGroupsForUser(User user, Group... groups) {

        boolean res = false;

        Connection con = null;
        PreparedStatement pstmt = null;


        try {
            con = getConnection();
            con.setAutoCommit(false);
            pstmt = con.prepareStatement(SQL_SET_GROUP_FOR_USER);
            for (int i = 0; i < groups.length; i++) {
                pstmt.setInt(1, user.getId());
                pstmt.setInt(2, groups[i].getId());
                con.commit();
            }
            pstmt.executeUpdate();
            res = true;

        } catch (SQLException e) {
            if (con != null) {
                try {
                    System.err.print("Transaction is being rolled back");
                    con.rollback();
                } catch (SQLException excep) {
                    excep.printStackTrace();
                }
            }
        } finally {
            if (con != null) {


                try {
                    con.setAutoCommit(true);
                    con.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

            }

        }
        return res;
    }


    public List<Group> getUserGroups(User user) throws DBException {
        List<Group> list = new ArrayList<>();
        List<Integer> groups = new ArrayList<>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(SQL_FIND_USER_GROUPS);

            pstmt.setInt(1, user.getId());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                groups.add(rs.getInt(2));
            }
            pstmt = con.prepareStatement(SQL_FIND_GROUP_BY_ID);
            for (int i = 0; i < groups.size(); i++) {
                pstmt.setInt(1, groups.get(i));
                rs = pstmt.executeQuery();
                if (rs.next()) {
                    list.add(extractGroup(rs));
                }
            }

        } catch (SQLException ex) {
            // (1) write to log
            ex.printStackTrace();
            // log.error("Cannot obtain a user by login", ex);

            // (2)
            throw new DBException("Cannot find a user groups", ex);
        } finally {
            close(rs);
            close(pstmt);
            close(con);
        }
        return list;
    }

    public boolean deleteGroup(Group group) throws DBException {
        boolean res = false;

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(SQL_DELETE_GROUP);

            pstmt.setString(1, group.getName());
            res = pstmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            // (1) write to log
            ex.printStackTrace();

            // (2)
            throw new DBException("Cannot delete a group " + group.getName(), ex);
        } finally {

            close(pstmt);
            close(con);
        }
        return res;

    }

    public boolean updateGroup(Group group) throws DBException {
        boolean res = false;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(SQL_UPDATE_GROUP);

            int k = 1;
            pstmt.setString(k++, group.getName());
            pstmt.setInt(k++, group.getId());

            res = pstmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            // (1) write to log
            ex.printStackTrace();

            // (2)
            throw new DBException("Cannot update a group:" + group, ex);
        } finally {
            close(con);
        }
        return res;

    }
}
