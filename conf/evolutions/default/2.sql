# Add Post and update User
 
# --- !Ups
ALTER TABLE users ADD age INT;
 
CREATE TABLE posts (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    title varchar(255) NOT NULL,
    content text NOT NULL,
    posted_at date NOT NULL,
    author_id bigint(20) NOT NULL,
    FOREIGN KEY (author_id) REFERENCES users(id),
    PRIMARY KEY (id)
);
 
# --- !Downs
ALTER TABLE users DROP age;
 
DROP TABLE posts;