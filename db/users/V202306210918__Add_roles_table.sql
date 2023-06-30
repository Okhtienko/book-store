CREATE TABLE roles
(
    id      BIGSERIAL   NOT NULL PRIMARY KEY,
    name    TEXT        NOT NULL,

    UNIQUE (name)
);

INSERT INTO roles (name) VALUES ('ADMIN');
INSERT INTO roles (name) VALUES ('USER');
