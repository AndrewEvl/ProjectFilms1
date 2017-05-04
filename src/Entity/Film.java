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
                ", genre='" + genre + '\'' +
                ", reviews=" + reviews +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return id == film.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
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


}