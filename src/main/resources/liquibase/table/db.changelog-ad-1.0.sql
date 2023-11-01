--liquibase formatted sql

--changeset RomanKamko:1
CREATE TABLE IF NOT EXISTS ad
(
    id          SERIAL PRIMARY KEY,
    title       VARCHAR(32) NOT NULL,
    description VARCHAR(64) NOT NULL,
    price       INT       NOT NULL,
    image       VARCHAR(255),
    user_id     INT REFERENCES users(id)
);