package Entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by entity.User on 28.03.2017.
 */
public class ActorDirector {
    private long id;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private Set<Film> film = new HashSet<>();
    private Role role;

    public ActorDirector(String lastName, Role role) {
        this.lastName = lastName;
        this.role = role;
    }

    public ActorDirector(String lastName) {
        this.lastName = lastName;
    }

    public ActorDirector(String firstName, String lastName, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public ActorDirector() {
    }

    public ActorDirector (String firstName, String lastName, Set<Film> film, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.film = film;
        this.role = role;
    }

    public ActorDirector(String firstName, String lastName, LocalDate birthday, Set<Film> film, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.film = film;
        this.role = role;
    }

    public ActorDirector(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public ActorDirector(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public ActorDirector(long id, String firstName, String lastName, LocalDate birthday) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    public ActorDirector(String firstName, String lastName, LocalDate birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    public ActorDirector(String firstName, String lastName, LocalDate birthday, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.role = role;
    }

    public ActorDirector(String firstName, String lastName, LocalDate birthday, Set<Film> film) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.film = film;
    }

    public ActorDirector(long id) {
        this.id = id;
    }

    public ActorDirector(long id, String firstName, String lastName, LocalDate birthday, Set<Film> film) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.film = film;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActorDirector that = (ActorDirector) o;

        if (id != that.id) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;
        if (film != null ? !film.equals(that.film) : that.film != null) return false;
        return role != null ? role.equals(that.role) : that.role == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (film != null ? film.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ActorDirector{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", film=" + film +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Set<Film> getFilm() {
        return film;
    }

    public void setFilm(Set<Film> film) {
        this.film = film;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


}
