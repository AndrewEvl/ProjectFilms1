CREATE TABLE user_role_user (users_id INT, users_role_id INT, PRIMARY KEY (users_id, users_role_id),FOREIGN KEY (users_id) REFERENCES users(id), FOREIGN KEY (users_role_id) REFERENCES users_role(id));
INSERT INTO user_role_user (users_id, users_role_id) VALUES (1,1);

CREATE DATABASE project;
USE project;
DROP DATABASE project;
DROP TABLE user_review;
DROP TABLE users;
DROP TABLE films;
DROP TABLE actors_directors;

SELECT * FROM films WHERE name;
SELECT * FROM films;
SELECT * FROM genres;
SELECT * FROM actors_directors;
SELECT * FROM reviews;
SELECT * FROM films_act_dir;
SELECT * FROM users;
SELECT * FROM role;
SELECT YEAR(relese_day) FROM films;


CREATE TABLE films (id INT AUTO_INCREMENT, name VARCHAR(100), country VARCHAR(32), relese_day DATE,
                    genre_id INT, PRIMARY KEY (id), FOREIGN KEY (genre_id) REFERENCES genres (id));
CREATE TABLE actors_directors (id INT AUTO_INCREMENT,first_name VARCHAR(50), last_name VARCHAR(50), birthday DATE,role_id INT,PRIMARY KEY(id), FOREIGN KEY (role_id) REFERENCES role(id));
CREATE TABLE users (id INT AUTO_INCREMENT, first_name VARCHAR (50), last_name VARCHAR (50), nick_name VARCHAR(50), birthday DATE,
                    password VARCHAR (15), mail VARCHAR (60) UNIQUE, PRIMARY KEY(id));
CREATE TABLE reviews (id INT AUTO_INCREMENT, text VARCHAR (1000), mark INT, PRIMARY KEY(id));
CREATE TABLE genres (id INT AUTO_INCREMENT, genres VARCHAR (20) UNIQUE, PRIMARY KEY (id));
CREATE TABLE role (id INT AUTO_INCREMENT, role VARCHAR (20) UNIQUE, PRIMARY KEY (id));
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


INSERT INTO films (name, country, relese_day, genre_id) VALUES ('Alien', 'USA', '1979-02-10', 2);
INSERT INTO films_act_dir (film_id, actor_director_id, role_id) VALUES (1, 1, 1);
INSERT INTO films_act_dir (film_id, actor_director_id, role_id) VALUES (1, 2, 2);
INSERT INTO genre_film (genre_id, film_id) VALUES (1, 1);
INSERT INTO actors_directors (first_name, last_name, birthday,role_id) VALUES ('Sigurni', 'Uiver', '1959-07-10',1);
INSERT INTO actors_directors (first_name, last_name, birthday, role_id) VALUES ('Ridli', 'Skot', '1945-11-28',2);
INSERT INTO users (first_name, last_name, nick_name, birthday, password, mail) VALUES ('Gordon', 'Friman','G-Man', '1972-09-02', 'gman', 'balskmesa@crashworls.com');
INSERT INTO user_review (user_id, review_id, film_id) VALUES (1, 1, 1);
INSERT INTO genres (genres) VALUES ('Animation');
INSERT INTO genres (genres) VALUES ('Horror');
INSERT INTO genres (genres) VALUES ('Action');
INSERT INTO genres (genres) VALUES ('Dram');
INSERT INTO genres (genres) VALUES ('Comedy');
INSERT INTO reviews (text, mark) VALUES ('Cool film', 5);
INSERT INTO users_role (role_user) VALUES ('Admin');
INSERT INTO user_role_user (users_id, users_role_id) VALUES (1,1);
INSERT INTO role (role) VALUES ('Actor');
INSERT INTO role (role) VALUES ('Director');


SELECT name, relese_day, country, actors_directors.first_name, actors_directors.last_name,
  actors_directors.birthday, genres, nick_name, text AS review, mark FROM films
  JOIN films_act_dir ON films_act_dir.film_id = films.id
  JOIN actors_directors ON films_act_dir.actor_director_id = actors_directors.id
  JOIN genres ON films_act_dir.film_id = genres.id
  JOIN users ON films_act_dir.film_id = users.id
  JOIN reviews ON films_act_dir.film_id = reviews.id
  JOIN role ON films_act_dir.role_id = role.id;

SELECT nick_name, first_name, last_name, birthday FROM users;