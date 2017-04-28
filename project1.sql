CREATE DATABASE project;
USE project;
DROP DATABASE project;
DROP TABLE user_review;

SELECT * FROM films;
SELECT * FROM actors_directors;
SELECT * FROM reviews;
SELECT * FROM films_act_dir;
SELECT * FROM users;
SELECT * FROM role;

CREATE TABLE films (id INT AUTO_INCREMENT,name VARCHAR(100), country VARCHAR(32), relese_day DATE, PRIMARY KEY (id));
CREATE TABLE actors_directors (id INT AUTO_INCREMENT,first_name VARCHAR(50), last_name VARCHAR(50), birthday DATE,PRIMARY KEY(id));
CREATE TABLE users (id INT AUTO_INCREMENT, first_name VARCHAR (50), last_name VARCHAR (50), nick_name VARCHAR(50), birthday DATE, 
			 password VARCHAR (15), mail VARCHAR (60) UNIQUE, PRIMARY KEY(id));
CREATE TABLE reviews (id INT AUTO_INCREMENT, text VARCHAR (1000), mark INT, PRIMARY KEY(id));
CREATE TABLE ganres (id INT AUTO_INCREMENT, ganres VARCHAR (20) UNIQUE, PRIMARY KEY (id));
CREATE TABLE role (id INT AUTO_INCREMENT, role VARCHAR (20) UNIQUE, PRIMARY KEY (id));
CREATE TABLE users_role (id INT AUTO_INCREMENT, role_user VARCHAR(20), PRIMARY KEY (id));


CREATE TABLE user_role_user (users_id INT, users_role_id INT, PRIMARY KEY (users_id, users_role_id),
			 FOREIGN KEY (users_id) REFERENCES users(id), 
             FOREIGN KEY (users_role_id) REFERENCES users_role(id));
CREATE TABLE films_act_dir (film_id INT, actor_director_id INT, role_id INT, PRIMARY KEY (film_id, actor_director_id, role_id),
			 FOREIGN KEY (film_id) REFERENCES films(id),
             FOREIGN KEY (actor_director_id) REFERENCES actors_directors(id),
             FOREIGN KEY (role_id) REFERENCES role(id));
CREATE TABLE ganre_film (ganre_id INT, film_id INT, PRIMARY KEY (ganre_id, film_id), 
			 FOREIGN KEY (ganre_id) REFERENCES ganres(id),
             FOREIGN KEY (film_id) REFERENCES films(id));
CREATE TABLE user_review (user_id INT, review_id INT,film_id INT, PRIMARY KEY (user_id, review_id, film_id),
			 FOREIGN KEY (user_id) REFERENCES users(id),
             FOREIGN KEY (review_id) REFERENCES reviews(id),
             FOREIGN KEY (film_id) REFERENCES films(id));

INSERT INTO films (name, country, relese_day) VALUES ('Alien', 'USA', '1979-02-10');
			INSERT INTO films_act_dir (film_id, actor_director_id, role_id) VALUES (1, 1, 1);
            INSERT INTO films_act_dir (film_id, actor_director_id, role_id) VALUES (1, 2, 2);
            INSERT INTO ganre_film (ganre_id, film_id) VALUES (1, 1);
INSERT INTO actors_directors (first_name, last_name, birthday) VALUES ('Sigurni', 'Uiver', '1959-07-10');
INSERT INTO actors_directors (first_name, last_name, birthday) VALUES ('Ridli', 'Skot', '1945-11-28');
INSERT INTO users (first_name, last_name, nick_name, birthday, password, mail) VALUES ('Gordon', 'Friman','G-Man', '1972-09-02', 'gman', 'balskmesa@crashworls.com');
			INSERT INTO user_review (user_id, review_id, film_id) VALUES (1, 1, 1);
INSERT INTO ganres (ganres) VALUES ('Horor');
INSERT INTO reviews (text, mark) VALUES ('Cool film', 5);
INSERT INTO users_role (role_user) VALUES ('Admin');
INSERT INTO user_role_user (users_id, users_role_id) VALUES (1,1);
INSERT INTO role (role) VALUES ('Actor');
INSERT INTO role (role) VALUES ('Director');


SELECT name, relese_day, country, actors_directors.first_name, actors_directors.last_name, role,
			actors_directors.birthday, ganres, nick_name, text AS review, mark FROM films
			JOIN films_act_dir ON films_act_dir.film_id = films.id
            JOIN actors_directors ON films_act_dir.actor_director_id = actors_directors.id
            JOIN ganres ON films_act_dir.film_id = ganres.id
            JOIN users ON films_act_dir.film_id = users.id
            JOIN reviews ON films_act_dir.film_id = reviews.id;
            
SELECT first_name, last_name, nick_name, birthday, password, mail, text, mark FROM users
			JOIN user_review ON user_review.user_id = reviews.id;
