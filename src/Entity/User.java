package Entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by entity.User on 28.03.2017.
 */
public class User {
    private long id;
    private String firstName;
    private String lastName;
    private String nickName;
    private LocalDate birthdayDay;
    private String password;
    private String mail;
    private Set<Review> reviews = new HashSet<>();
    private String role;

    public User(String nickName, String password, String role) {
        this.nickName = nickName;
        this.password = password;
        this.role = role;
    }

    public User(long id, String firstName, String lastName, String nickName, LocalDate birthdayDay, String password, String mail, Set<Review> reviews, String role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.birthdayDay = birthdayDay;
        this.password = password;
        this.mail = mail;
        this.reviews = reviews;
        this.role = role;
    }

    public User(String nickName, String password) {
        this.nickName = nickName;
        this.password = password;
    }

    public User(String nickName, Set<Review> reviews) {
        this.nickName = nickName;
        this.reviews = reviews;
    }

    public User(String nickName) {
        this.nickName = nickName;
    }

    public User() {
    }



    public User(String firstName, String lastName, String nickName, String password, String mail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.password = password;
        this.mail = mail;
    }

    public User(long id) {
        this.id = id;
    }

    public User(String firstName, String lastName, String nickName, LocalDate birthdayDay, String password, String mail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.birthdayDay = birthdayDay;
        this.password = password;
        this.mail = mail;
    }

    public User(String firstName, String lastName, String nickName, LocalDate birthdayDay, String password, String mail, Set<Review> reviews) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.birthdayDay = birthdayDay;
        this.password = password;
        this.mail = mail;
        this.reviews = reviews;
    }

    public User(long id, String firstName, String lastName, String nickName, LocalDate birthdayDay, String password, String mail, Set<Review> reviews) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.birthdayDay = birthdayDay;
        this.password = password;
        this.mail = mail;
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", birthdayDay=" + birthdayDay +
                ", password='" + password + '\'' +
                ", mail='" + mail + '\'' +
                ", reviews=" + reviews +
                ", role='" + role + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (nickName != null ? !nickName.equals(user.nickName) : user.nickName != null) return false;
        if (birthdayDay != null ? !birthdayDay.equals(user.birthdayDay) : user.birthdayDay != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (mail != null ? !mail.equals(user.mail) : user.mail != null) return false;
        if (reviews != null ? !reviews.equals(user.reviews) : user.reviews != null) return false;
        return role != null ? role.equals(user.role) : user.role == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (nickName != null ? nickName.hashCode() : 0);
        result = 31 * result + (birthdayDay != null ? birthdayDay.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        result = 31 * result + (reviews != null ? reviews.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public LocalDate getBirthdayDay() {
        return birthdayDay;
    }

    public void setBirthdayDay(LocalDate birthdayDay) {
        this.birthdayDay = birthdayDay;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
