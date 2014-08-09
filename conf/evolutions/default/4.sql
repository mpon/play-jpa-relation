# Tag schema
 
# --- !Ups
 
CREATE TABLE tags (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE posts_tags (
	post_id bigint(20) NOT NULL,
	tag_id bigint(20) NOT NULL,
	PRIMARY KEY (post_id, tag_id)
);
 
# --- !Downs

DROP TABLE tags;
DROP TABLE posts_tags;