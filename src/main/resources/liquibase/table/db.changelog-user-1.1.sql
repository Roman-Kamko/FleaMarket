--liquibase formatted sql

--changeset RomanKamko:1
ALTER TABLE users
    DROP COLUMN image;

--changeset RomanKamko:2
ALTER TABLE users
    ADD COLUMN image_id INT REFERENCES image(id)