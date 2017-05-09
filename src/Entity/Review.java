package Entity;

/**
 * Created by entity.User on 28.03.2017.
 */
public class Review {
    private long id;
    private Film film;
    private long filmId;
    private User user;
    private String text;
    private double mark;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Review review = (Review) o;

        if (id != review.id) return false;
        if (filmId != review.filmId) return false;
        if (Double.compare(review.mark, mark) != 0) return false;
        if (film != null ? !film.equals(review.film) : review.film != null) return false;
        if (user != null ? !user.equals(review.user) : review.user != null) return false;
        return text != null ? text.equals(review.text) : review.text == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        result = 31 * result + (film != null ? film.hashCode() : 0);
        result = 31 * result + (int) (filmId ^ (filmId >>> 32));
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        temp = Double.doubleToLongBits(mark);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public Review(long filmId, User user, String text) {
        this.filmId = filmId;
        this.user = user;
        this.text = text;
    }

    public Review(Film film, User user, String text) {
        this.film = film;
        this.user = user;
        this.text = text;
    }

    public Review(User user, String text) {
        this.user = user;
        this.text = text;
    }

    public Review(String text) {
        this.text = text;
    }

    public Review(String text, double mark) {
        this.text = text;
        this.mark = mark;
    }

    public Review(Film film, User user, String text, double mark) {
        this.film = film;
        this.user = user;
        this.text = text;
        this.mark = mark;
    }

    public Review(long id, Film film, User user, String text, double mark) {
        this.id = id;
        this.film = film;
        this.user = user;
        this.text = text;
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", film=" + film +
                ", filmId=" + filmId +
                ", user=" + user +
                ", text='" + text + '\'' +
                ", mark=" + mark +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public double getMark() {
        return mark;
    }

    public long getFilmId() {
        return filmId;
    }

    public void setFilmId(long filmId) {
        this.filmId = filmId;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }
}
