--liquibase formatted sql

--changeset RomanKamko:1
CREATE TABLE IF NOT EXISTS users
(
    id         SERIAL PRIMARY KEY,
    email      VARCHAR(32) NOT NULL,
    password   VARCHAR(255) NOT NULL,
    first_name VARCHAR(16) NOT NULL,
    last_name  VARCHAR(16) NOT NULL,
    phone      VARCHAR(32) NOT NULL,
    role       VARCHAR(16),
    image      VARCHAR(255)
);