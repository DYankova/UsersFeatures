CREATE DATABASE USER_SETTINGS;
USE  USER_SETTINGS;

CREATE TABLE users (
  id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(45) NOT NULL,
  email varchar(45) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE features(
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(45) NOT NULL,
  enabled boolean DEFAULT true,
  PRIMARY KEY (id)
);

CREATE TABLE users_features (
  user_id int(11) NOT NULL,
  feature_id  int(11) NOT NULL,
  enabled boolean DEFAULT true,
  PRIMARY KEY (user_id,feature_id),
  KEY fk_user (user_id),
  KEY fk_feature (feature_id),
  CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users (id),
  CONSTRAINT fk_feature FOREIGN KEY (feature_id) REFERENCES features (id)
);

 INSERT INTO features(name, enabled) VALUES('change-email', true);

 INSERT INTO features(name, enabled) VALUES('ad-free', false);

 INSERT INTO features(name, enabled) VALUES('app-rate', false);

 INSERT INTO features(name, enabled) VALUES('app-feedback', true);

 insert into users(id, username, email) values( 1, 'Venus Williams', 'vm@gmail.com');

 insert into users(id, username, email) values( 2, 'Serena Williams', 'sw@gmail.com');

 insert into users(id, username, email) values( 3, 'Maria Sharapova', 'ms@gmail.com');

 insert into users(id, username, email) values( 4, 'Steffi Grafs', 'sg@gmail.com');

 insert into users(id, username, email) values( 5, 'Simona Halep', 'sh@gmail.com');

 INSERT INTO users_features(user_id, feature_id, enabled) values (1, 1, true);

 INSERT INTO users_features(user_id, feature_id, enabled) values (1, 2, false);

 INSERT INTO users_features(user_id, feature_id, enabled) values (5, 1, false);

 INSERT INTO users_features(user_id, feature_id, enabled) values (4, 2, true);

 INSERT INTO users_features(user_id, feature_id, enabled) values (4, 3, false);

 INSERT INTO users_features(user_id, feature_id, enabled) values (4, 4, false);
