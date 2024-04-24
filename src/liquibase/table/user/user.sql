--liquibase formatted sql

--changeset moratorium:user_create
CREATE TABLE IF NOT EXISTS users (
    id    BIGSERIAL PRIMARY KEY,
    name  VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    role  VARCHAR(100) NOT NULL
);