# Status schema
 
# --- !Ups
 
CREATE TABLE addresses (
    user_id bigint(20) NOT NULL,
    city varchar(255) NOT NULL,
    zip_code varchar(7) NOT NULL,
    PRIMARY KEY (user_id)
);
 
# --- !Downs
 
DROP TABLE addresses;