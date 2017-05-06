package Entity;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by entity.User on 28.03.2017.
 */
public class Film {
    private long id;
    private String name;
    private Set<ActorDirector> actors = new HashSet<>();
    private Set<ActorDirector> director = new HashSet<>();
    private LocalDate releaseDay;
    private String county;
    private Genre genre;
    private Set<Review> reviews = new HashSet<>();
    private Role role;

    public Film(long id, String name, String county) {
        this.id = id;
        this.name = name;
        this.county = county;
    }

    public Film(long id, String name, Set<ActorDirector> actors, Set<ActorDirector> director, LocalDate releaseDay, String county, Genre genre, Set<Review> reviews, Role role) {
        this.id = id;
        this.name = name;
        this.actors = actors;
        this.director = director;
        this.releaseDay = releaseDay;
        this.county = county;
        this.genre = genre;
        this.reviews = reviews;
        this.role = role;
    }

    public Film(String name, Genre genre, Role role) {
        this.name = name;
        this.genre = genre;
        this.role = role;
    }

    public Film(String name, Genre genre) {
        this.name = name;
        this.genre = genre;
    }

    public Film(String name, Set<ActorDirector> actors, Genre genre, Set<Review> reviews) {
        this.name = name;
        this.actors = actors;
        this.genre = genre;
        this.reviews = reviews;
    }

    public Film(String name, Set<ActorDirector> actors, Set<ActorDirector> director, Genre genre, Set<Review> reviews) {
        this.name = name;
        this.actors = actors;
        this.director = director;
        this.genre = genre;
        this.reviews = reviews;
    }

    public Film(String name, String county) {
        this.name = name;
        this.county = county;
    }

    public Film() {}

    public Film(String name, LocalDate releaseDay, String county) {
        this.name = name;
        this.releaseDay = releaseDay;
        this.county = county;
    }

    public Film(long id) {
        this.id = id;
    }

    public Film (Genre genre, long id) {
        this.id = id;
        this.genre = genre;
    }

    public Film(String name) {
        this.name = name;
    }

    public Film(LocalDate releaseDay) {
        this.releaseDay = releaseDay;
    }

    public Film(String name, LocalDate releaseDay, String county, Genre genre) {
        this.name = name;
        this.releaseDay = releaseDay;
        this.county = county;
        this.genre = genre;
    }

    public Film(LocalDate releaseDay, String name) {
        this.name = name;
        this.releaseDay = releaseDay;
    }


    public Film(long id, String name) {
        this.id = id;
    }

    public Film(String name, Date date, String string, String resultSetString) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", actors=" + actors +
                ", director=" + director +
                ", releaseDay=" + releaseDay +
                ", county='" + county + '\'' +
                ", genre=" + genre +
                ", reviews=" + reviews +
                ", role=" + role +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ActorDirector> getActors() {
        return actors;
    }

    public void setActors(Set<ActorDirector> actors) {
        this.actors = actors;
    }

    public Set<ActorDirector> getDirector() {
        return director;
    }

    public void setDirector(Set<ActorDirector> director) {
        this.director = director;
    }

    public LocalDate getReleaseDay() {
        return releaseDay;
    }

    public void setReleaseDay(LocalDate releaseDay) {
        this.releaseDay = releaseDay;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Film film = (Film) o;

        if (id != film.id) return false;
        if (name != null ? !name.equals(film.name) : film.name != null) return false;
        if (actors != null ? !actors.equals(film.actors) : film.actors != null) return false;
        if (director != null ? !director.equals(film.director) : film.director != null) return false;
        if (releaseDay != null ? !releaseDay.equals(film.releaseDay) : film.releaseDay != null) return false;
        if (county != null ? !county.equals(film.county) : film.county != null) return false;
        if (genre != null ? !genre.equals(film.genre) : film.genre != null) return false;
        if (reviews != null ? !reviews.equals(film.reviews) : film.reviews != null) return false;
        if (role != null ? !role.equals(film.role) : film.role != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (actors != null ? actors.hashCode() : 0);
        result = 31 * result + (director != null ? director.hashCode() : 0);
        result = 31 * result + (releaseDay != null ? releaseDay.hashCode() : 0);
        result = 31 * result + (county != null ? county.hashCode() : 0);
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        result = 31 * result + (reviews != null ? reviews.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }
}