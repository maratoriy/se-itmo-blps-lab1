--liquibase formatted sql

--changeset moratorium:review_create
CREATE TABLE IF NOT EXISTS review (
    id               BIGINT PRIMARY KEY,
    user_id          BIGINT      NOT NULL,
    movie_id         BIGINT      NOT NULL,
    content          TEXT        NOT NULL,
    status           VARCHAR(50) NOT NULL,
    creation_date    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    publication_date TIMESTAMP,

    CONSTRAINT fk_review_user FOREIGN KEY (user_id) REFERENCES "user" (id),
    CONSTRAINT fk_review_movie FOREIGN KEY (movie_id) REFERENCES movie (id)
);