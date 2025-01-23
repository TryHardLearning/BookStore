DROP SEQUENCE IF EXISTS author_id_seq
DROP SEQUENCE IF EXISTS book_id_seq

DROP INSTANCE IF EXISTS authors
DROP INSTANCE IF EXISTS books


CREATE SEQUENCE author_id_seq INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE book_id_seq INCREMENT BY 1 START WITH 1;



CREATE TABLE authors
(
    id          BIGINT PRIMARY KEY DEFAULT NEXTVAL('author_id_seq'),
    name        VARCHAR(128) NOT NULL,
    email       VARCHAR(128) NOT NULL,
    age         INT          NOT NULL,
    description TEXT,
    imageURL    VARCHAR(128)
);

CREATE SEQUENCE book_id_seq;

CREATE TABLE books
(
    id          BIGINT PRIMARY KEY DEFAULT NEXTVAL('book_id_seq'),
    title       VARCHAR(128) NOT NULL,
    description TEXT,
    imageURL    VARCHAR(128),
    author_id   BIGINT,
    FOREIGN KEY (author_id) REFERENCES authors (id)
);