--liquibase formatted sql

--changeset moratorium:movie_create
CREATE TABLE IF NOT EXISTS movie (
    id           BIGINT PRIMARY KEY,
    title        VARCHAR(255) NOT NULL,
    description  TEXT,
    director     VARCHAR(255),
    release_year INTEGER,
    genre        VARCHAR(100),
    duration     INTEGER
);