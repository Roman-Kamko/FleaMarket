--liquibase formatted sql

--changeset RomanKamko:1
CREATE TABLE IF NOT EXISTS comment
(
    id         SERIAL PRIMARY KEY,
    text       VARCHAR(32) NOT NULL,
    created_at BIGINT,
    user_id    INT REFERENCES users (id),
    ad_id      INT REFERENCES ad (id)
);