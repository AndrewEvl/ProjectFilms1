package Dao;

import Entity.*;
import connection.ConnectionManager;

import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;


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
                               // resultSet.getObject("actors_directors.birthday",LocalDate.class()
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actorDirectors;
    }

//    "SELECT actors_directors.first_name, actors_directors.last_name, films.name, role.role ,genres.genres FROM actors_directors " +
//            "LEFT JOIN films_act_dir ON actors_directors.id = films_act_dir.actor_director_id " +
//            "LEFT JOIN films ON films_act_dir.film_id = films.id " +
//            "LEFT JOIN  role ON actors_directors.role_id = role.id " +
//            "LEFT JOIN genres ON films.genre_id = genres.id WHERE actors_directors.id = ?;"
    public Optional<ActorDirector> listActorDirector(long id) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement
                    ("SELECT actors_directors.first_name, actors_directors.last_name, films.name, role.role ,genres.genres FROM actors_directors " +
                            "LEFT JOIN films_act_dir ON actors_directors.id = films_act_dir.actor_director_id " +
                            "LEFT JOIN films ON films_act_dir.film_id = films.id " +
                            "LEFT JOIN role ON films_act_dir.role_id = role.id " +
                            "LEFT JOIN genres ON films.genre_id = genres.id WHERE actors_directors.id = ?;")) {
                preparedStatement.setLong(1, id);
                Set<Film> filmHashSet = new HashSet<>();
                ActorDirector actorDirector = new ActorDirector();
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        actorDirector.setFirstName(resultSet.getString("actors_directors.first_name"));
                        actorDirector.setLastName(resultSet.getString("actors_directors.last_name"));
                        filmHashSet.add(new Film(resultSet.getString("films.name"),
                                new Genre(resultSet.getString("genres.genres")),
                                new Role(resultSet.getString("role.role"))));
                    }
                    actorDirector.setFilm(filmHashSet);
                }
                return Optional.of(actorDirector);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }


    public Optional<ActorDirector> findById(long id) {
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