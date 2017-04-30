package Dao;

import Entity.ActorDirector;
import Entity.Ganre;
import Entity.Review;
import Entity.Role;
import connection.ConnectionManager;

import javax.xml.transform.Result;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * Created by entity.User on 08.04.2017.
 */
public class ActorDirectorDao {

    private static final Object LOCK = new Object();
    private static ActorDirectorDao INSTANCE = null;

    public static ActorDirectorDao getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new ActorDirectorDao();
                }
            }
        }
        return INSTANCE;
    }

    public Optional<ActorDirector> save(ActorDirector actorDirector) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    ("INSERT INTO actors_directors (first_name, last_name, birthday) VALUES (?, ?, ?)"),
                    Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, actorDirector.getFirstName());
                preparedStatement.setString(2, actorDirector.getLastName());
                preparedStatement.setObject(3, actorDirector.getBirthdayDay());
                preparedStatement.executeUpdate();
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    actorDirector.setId(generatedKeys.getLong(1));
                }
                return Optional.of(actorDirector);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<Role> getId(String role) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement
                    ("SELECT * FROM role WHERE role = ?")) {
                preparedStatement.setString(1, role);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return Optional.of(new Role(resultSet.getLong("id"), role));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public List<ActorDirector> getActDir() {
        List<ActorDirector> actorDirectors = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement
                    ("SELECT *FROM actors_directors")) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        actorDirectors.add(new ActorDirector(resultSet.getLong("actors_directors.id"),
                                resultSet.getString("actors_directors.first_name"),
                                resultSet.getString("actors_directors.last_name")));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actorDirectors;
    }

    public Optional<ActorDirector> findById (long id) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement
                    ("SELECT * FROM actors_directors WHERE id = ?")) {
                preparedStatement.setLong(1, id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return Optional.of(new ActorDirector(resultSet.getString("actors_directors.first_name"),
                                resultSet.getString("actors_directors.last_name")));
                                //resultSet.getObject("actors_directors.birthday")));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}