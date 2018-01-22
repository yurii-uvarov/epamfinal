package ua.nure.uvarov.constants;

public class MySQL {
    public static final String CREATE_USER = "insert into users (role,email,password,firstName,lastName,blocked) values (?,?,?,?,?,?);";
    public static final String USER_BY_EMAIL_AND_PASSWORD = "SELECT * FROM users WHERE email = ? AND password = ?";
    public static final String USERS_BLOCK_STATUS = "SELECT blocked FROM users WHERE email = ?";
    public static final String UPDATE_BLOCK_STATUS_BY_LOGIN = "UPDATE users SET blocked = ? WHERE email = ?";
    public static final String USER_BY_EMAIL = "SELECT * FROM users WHERE email = ?";

    public static final String BOOK_BY_NAME = "SELECT * FROM books WHERE name = ?";

}
