--liquibase formatted sql

--changeset RomanKamko:1
CREATE TABLE IF NOT EXISTS image
(
    id         SERIAL PRIMARY KEY,
    size       BIGINT,
    media_type VARCHAR(64) NOT NULL,
    content    BYTEA
);