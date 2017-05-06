CREATE DATABASE project;
USE project;

CREATE TABLE genres (id INT AUTO_INCREMENT, genres VARCHAR (20) UNIQUE, PRIMARY KEY (id));
CREATE TABLE role (id INT AUTO_INCREMENT, role VARCHAR (20) UNIQUE, PRIMARY KEY (id));
CREATE TABLE films (id INT AUTO_INCREMENT, name VARCHAR(100), country VARCHAR(32), relese_day DATE,
                    genre_id INT, PRIMARY KEY (id), FOREIGN KEY (genre_id) REFERENCES genres (id));
CREATE TABLE actors_directors (id INT AUTO_INCREMENT,first_name VARCHAR(50), last_name VARCHAR(50), birthday DATE);
CREATE TABLE users (id INT AUTO_INCREMENT, first_name VARCHAR (50), last_name VARCHAR (50), nick_name VARCHAR(50), birthday DATE,
                    password VARCHAR (15), mail VARCHAR (60) UNIQUE, PRIMARY KEY(id));
CREATE TABLE reviews (id INT AUTO_INCREMENT, text VARCHAR (1000), mark INT, PRIMARY KEY(id));
CREATE TABLE users_role (id INT AUTO_INCREMENT, role_user VARCHAR(20), PRIMARY KEY (id));


CREATE TABLE user_role_user (users_id INT, users_role_id INT, PRIMARY KEY (users_id, users_role_id),
  FOREIGN KEY (users_id) REFERENCES users(id),
  FOREIGN KEY (users_role_id) REFERENCES users_role(id));
CREATE TABLE films_act_dir (film_id INT, actor_director_id INT, role_id INT, PRIMARY KEY (film_id, actor_director_id, role_id),
  FOREIGN KEY (film_id) REFERENCES films(id),
  FOREIGN KEY (actor_director_id) REFERENCES actors_directors(id),
  FOREIGN KEY (role_id) REFERENCES role(id));
CREATE TABLE genre_film (
  genre_id INT, film_id INT, PRIMARY KEY (genre_id, film_id),
  FOREIGN KEY (genre_id) REFERENCES genres(id),
  FOREIGN KEY (film_id) REFERENCES films(id));
CREATE TABLE user_review (user_id INT, review_id INT,film_id INT, PRIMARY KEY (user_id, review_id, film_id),
  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (review_id) REFERENCES reviews(id),
  FOREIGN KEY (film_id) REFERENCES films(id));


INSERT INTO genres (genres) VALUES ('Мультфильм');
INSERT INTO genres (genres) VALUES ('Ужасы');
INSERT INTO genres (genres) VALUES ('Боевик');
INSERT INTO genres (genres) VALUES ('Драмма');
INSERT INTO genres (genres) VALUES ('Комедия');
INSERT INTO users_role (role_user) VALUES ('Admin');
INSERT INTO users_role (role_user) VALUES ('User');
INSERT INTO role (role) VALUES ('Актёр');
INSERT INTO role (role) VALUES ('Режиссёр');
