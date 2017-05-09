package Dao;

import Entity.Review;

import java.sql.*;
import java.util.Optional;

import connection.ConnectionManager;

/**
 * Created by User on 08.04.2017.
 */
public class ReviewsDao {

    private static final Object LOCK = new Object();
    private static ReviewsDao INSTANCE = null;

    public static ReviewsDao getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new ReviewsDao();
                }
            }
        }
        return INSTANCE;
    }

    public Optional<Review> save(Review review) {
        try (Connection connection = ConnectionManager.getConnection()) {
            connection.setAutoCommit(false);
            try (PreparedStatement preparedStatement = connection.prepareStatement
                    ("INSERT INTO reviews (text) VALUES (?)"
                            , Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, review.getText());
                preparedStatement.executeUpdate();
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()){
                    review.setId(generatedKeys.getLong(1));
                }
            }
            try (PreparedStatement preparedStatement = connection.prepareStatement
                    ("INSERT INTO user_review (user_id, review_id, film_id) VALUE (?, ?, ?)")) {
                preparedStatement.setLong(1, review.getUser().getId());
                preparedStatement.setLong(2, review.getId());
                preparedStatement.setLong(3, review.getFilm().getId());
                preparedStatement.executeUpdate();
            }
            connection.commit();
            return Optional.of(review);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

//    public Optional<Review> addReview(Review review) {
//        try (Connection connection = ConnectionManager.getConnection()) {
//            PreparedStatement preparedStatement = connection.prepareStatement
//                    ("INSERT INTO reviews (text, mark) VALUES (?, ?)"
//                            , Statement.RETURN_GENERATED_KEYS);
//            {
//                preparedStatement.setString(1, review.getText());
//                preparedStatement.setDouble(2, review.getMark());
//                preparedStatement.executeUpdate();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
}
