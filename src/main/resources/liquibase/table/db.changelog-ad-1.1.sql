--liquibase formatted sql

--changeset RomanKamko:1
ALTER TABLE ad
DROP COLUMN image;

--changeset RomanKamko:2
ALTER TABLE ad
ADD COLUMN image_id INT REFERENCES image(id)