--liquibase formatted sql

--changeset moratorium:review_create
CREATE TABLE IF NOT EXISTS review (
    id               BIGSERIAL PRIMARY KEY,
    user_id          BIGINT      NOT NULL,
    movie_id         BIGINT      NOT NULL,
    content          TEXT        NOT NULL,
    status           VARCHAR(50) NOT NULL,
    creation_date    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    publication_date TIMESTAMP,

    CONSTRAINT fk_review_user FOREIGN KEY (user_id) REFERENCES users (id),
    CONSTRAINT fk_review_movie FOREIGN KEY (movie_id) REFERENCES movie (id)
);

--changeset moratorium:review_add_reviewer_id
ALTER TABLE review
    ADD COLUMN reviewer_id BIGINT;
ALTER TABLE review
    ADD CONSTRAINT fk_review_assigned_reviewer FOREIGN KEY (reviewer_id) REFERENCES users (id);