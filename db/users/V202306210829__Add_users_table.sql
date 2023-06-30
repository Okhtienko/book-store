CREATE TABLE users
(
    id              BIGSERIAL   NOT NULL PRIMARY KEY,
    username        TEXT        NOT NULL,
    email           TEXT        NOT NULL,
    password        TEXT        NOT NULL,

    UNIQUE (username, email)
);
