package Dao;

import Entity.*;
import connection.ConnectionManager;

import java.sql.*;
import java.time.LocalDate;
import java.time.Year;
import java.util.*;
import java.util.Date;

/**
 * Created by User on 08.04.2017.
 */
public class FilmDao {

    private static final Object LOCK = new Object();
    private static FilmDao INSTANCE = null;

    public static FilmDao getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new FilmDao();
                }
            }
        }
        return INSTANCE;
    }

    public Optional<Film> save(Film film, long genreId, long actDirId, long roleId) {
        try (Connection connection = ConnectionManager.getConnection()) {
            connection.setAutoCommit(false);
            try (PreparedStatement preparedStatement = connection.prepareStatement
                    ("INSERT INTO films (name, country, relese_day,genre_id) VALUES (?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, film.getName());
                preparedStatement.setString(2, film.getCounty());
                preparedStatement.setObject(3, film.getReleaseDay());
                preparedStatement.setLong(4, genreId);
                preparedStatement.executeUpdate();
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    film.setId(generatedKeys.getLong(1));
                }
            }
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO genre_film (genre_id, film_id) VALUES (?, ?);")) {
                preparedStatement.setLong(1, genreId);
                preparedStatement.setLong(2, film.getId());
                preparedStatement.executeUpdate();
            }
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO films_act_dir (film_id, actor_director_id, role_id) VALUES (?, ?, ?);")) {
                preparedStatement.setLong(1, film.getId());
                preparedStatement.setLong(2, actDirId);
                preparedStatement.setLong(3, roleId);
                preparedStatement.executeUpdate();
            }
            connection.commit();
            return Optional.of(film);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

//    public Optional<Film> getById(long id) {
//        try (Connection connection = ConnectionManager.getConnection()) {
//            try (PreparedStatement preparedStatement = connection.prepareStatement(
//                    "SELECT * FROM films WHERE id = ?")) {
//                preparedStatement.setLong(1, id);
//                ResultSet resultSet = preparedStatement.executeQuery();
//                if (resultSet.next()) {
//                    return Optional.of(new Film(id, resultSet.getString("name")));
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return Optional.empty();
//    }

    public List<Film> getByYear(LocalDate releaseDay) {
        List<Film> yearFilms = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement
                    ("SELECT  * FROM  films WHERE YEAR(relese_day) = ?")) {
                preparedStatement.setObject(1, releaseDay.getYear());
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    yearFilms.add(new Film(resultSet.getLong("films.id"),
                            resultSet.getString("name"),
                            resultSet.getString("country")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return yearFilms;
    }

    public List<Genre> findAllGenre() {
        List<Genre> genre = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement
                    ("SELECT * FROM genres")) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        genre.add(new Genre(resultSet.getLong("genres.id"),
                                resultSet.getString("genres.genres")));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return genre;
    }

    public List<Film> downlonFileFilm () {
        List<Film> downlodFilmList = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement
                    ("SELECT name, country, relese_day, genres.genres FROM films " +
                            "JOIN genres ON films.genre_id = genres.id")) {
                try (ResultSet resultSet = preparedStatement.executeQuery()){
                    while (resultSet.next()){
                        downlodFilmList.add(new Film(resultSet.getString("name"),
                                resultSet.getString("country")));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return downlodFilmList;
    }

    public List<Film> allFilms() {
        List<Film> filmArrayList = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement
                    ("SELECT * FROM films")) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        filmArrayList.add(new Film(resultSet.getLong("films.id"),
                                resultSet.getString("films.name"),
                                resultSet.getString("films.country")));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return filmArrayList;
    }

    public Optional<Film> listFilms(long id) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement
                            ("SELECT films.name,genres.genres,films.relese_day, actors_directors.birthday, actors_directors.last_name, actors_directors.first_name, role.role, reviews.text, users.nick_name FROM films " +
                                    "JOIN films_act_dir ON films.id = films_act_dir.film_id " +
                                    "JOIN actors_directors ON films_act_dir.actor_director_id = actors_directors.id " +
                                    "JOIN genres ON films.genre_id = genres.id " +
                                    "LEFT JOIN user_review ON films.id = user_review.film_id " +
                                    "LEFT JOIN reviews ON user_review.review_id = reviews.id " +
                                    "LEFT JOIN users ON user_review.user_id = users.id " +
                                    "JOIN role ON actors_directors.role_id = role.id WHERE films.id = ?;")) {
                preparedStatement.setLong(1, id);

                Set<ActorDirector> actorDirectorHashSet = new HashSet<>();
                Set<Review> reviewHashSet = new HashSet<>();
                Film film = new Film();

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        film.setName(resultSet.getString("films.name"));
                        actorDirectorHashSet.add(new ActorDirector(resultSet.getString("actors_directors.first_name"),
                                resultSet.getString("actors_directors.last_name"),
                                resultSet.getObject("actors_directors.birthday", LocalDate.class),
                                new Role(resultSet.getString("role.role"))));
                        film.setActors(actorDirectorHashSet);
                        film.setReleaseDay(resultSet.getObject("films.relese_day", LocalDate.class));
                        reviewHashSet.add(new Review(new User(resultSet.getString("users.nick_name")), resultSet.getString("reviews.text")));
                        film.setReviews(reviewHashSet);
                        Genre genre = new Genre(resultSet.getString("genres.genres"));
                        film.setGenre(genre);
                    }
                    film.setActors(actorDirectorHashSet);
                }
                return Optional.of(film);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}

