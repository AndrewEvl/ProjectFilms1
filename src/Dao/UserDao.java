package Dao;

import Entity.Role;
import Entity.User;
import connection.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by User on 08.04.2017.
 */
public class UserDao {

    private static final Object LOCK = new Object();
    private static UserDao INSTANCE = null;

    public static UserDao getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new UserDao();
                }
            }
        }
        return INSTANCE;
    }

    public Optional<User> save(User user) {
        try (Connection connection = ConnectionManager.getConnection()) {
            //connection.setAutoCommit(false);
            try (PreparedStatement preparedStatement = connection.prepareStatement
                    ("INSERT INTO users (first_name, last_name, nick_name, birthday, password, mail) " +
                            " VALUES (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, user.getFirstName());
                preparedStatement.setString(2, user.getLastName());
                preparedStatement.setString(3, user.getNickName());
                preparedStatement.setObject(4, user.getBirthdayDay());
                preparedStatement.setString(5, user.getPassword());
                preparedStatement.setString(6, user.getMail());
                preparedStatement.executeUpdate();
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    user.setId(generatedKeys.getLong(1));
                }
            }
            return Optional.of(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<User> info(User user) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement
                    ("SELECT nick_name, first_name, last_name, birthday FROM users")) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    resultSet.getString(user.getNickName());
                    resultSet.getString(user.getFirstName());
                    resultSet.getString(user.getLastName());
                    resultSet.getObject(String.valueOf(user.getBirthdayDay()));
                }
            }
            return Optional.of(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public List<Role> findAllRole() {
        List<Role> role = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement
                    ("SELECT * FROM role")) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        role.add(new Role(resultSet.getLong("role.id"),
                                resultSet.getString("role.role")));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }

    public List<User> findAllUsers(User user) {
        List<User> users = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement
                    ("SELECT mail, users.password, users_role.role_user FROM users " +
                            "JOIN user_role_user ON users.id = user_role_user.users_id " +
                            "JOIN users_role ON user_role_user.users_role_id = users_role.id WHERE users.password = ?")) {
                preparedStatement.setString(1, "users.mail");
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()){
                        users.add(new User(resultSet.getString("users.mail"),
                                resultSet.getString("users.password"),
                                resultSet.getString("users_role.role_user")));
                    }
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
