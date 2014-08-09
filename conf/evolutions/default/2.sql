# Add Post and update User
 
# --- !Ups
ALTER TABLE User ADD age INT;
 
CREATE TABLE Post (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    title varchar(255) NOT NULL,
    content text NOT NULL,
    postedAt date NOT NULL,
    author_id bigint(20) NOT NULL,
    FOREIGN KEY (author_id) REFERENCES User(id),
    PRIMARY KEY (id)
);
 
# --- !Downs
ALTER TABLE User DROP age;
 
DROP TABLE Post;