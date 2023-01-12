DROP TABLE IF EXISTS users CASCADE ;
DROP TABLE IF EXISTS boardRoles CASCADE ;
DROP TABLE IF EXISTS board CASCADE ;
DROP TABLE IF EXISTS note CASCADE ;

CREATE TABLE users (
    user_name VARCHAR (25) PRIMARY KEY,
    email VARCHAR(60),
    password VARCHAR(30)
);

INSERT INTO users VALUES ('adam4','adam1@vp.pl','adam1234');

CREATE TABLE board (
    board_id INTEGER GENERATED ALWAYS AS IDENTITY  PRIMARY KEY  ,
    board_name VARCHAR(30) ,
    owner_login VARCHAR(25),
    collaborators_list VARCHAR ARRAY,
    tag_name VARCHAR(6),
    owner_names VARCHAR[]

);

INSERT INTO board (board_name,owner_login,tag_name) VALUES   ('tablica1','adam1','RED');
INSERT INTO board (board_name,owner_login,tag_name) VALUES   ('tablica2','adam1','YELLOW');
INSERT INTO board (board_name,owner_login,tag_name) VALUES   ('tablica3','adam1','GREY');
INSERT INTO board (board_name,owner_login,tag_name) VALUES   ('tablica4','adam1','GREEN');
INSERT INTO board (board_name,owner_login,tag_name) VALUES   ('tablica5','adam1','NONE');



CREATE TABLE note (
                       note_id INTEGER PRIMARY KEY,
                       title VARCHAR(25),
                       description VARCHAR(300),
                       board_name VARCHAR(30),
                       CONSTRAINT board_name FOREIGN KEY(board_name) REFERENCES board (board_name)
);



