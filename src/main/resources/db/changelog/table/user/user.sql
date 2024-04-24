--liquibase formatted sql

--changeset moratorium:user_create
CREATE TABLE IF NOT EXISTS user (
    id       BIGINT PRIMARY KEY,
    name     VARCHAR(255) NOT NULL,
    email    VARCHAR(255) NOT NULL UNIQUE,
    role     VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL
);