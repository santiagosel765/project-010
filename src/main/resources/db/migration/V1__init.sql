CREATE TABLE IF NOT EXISTS user_status (
                                           status_id INTEGER PRIMARY KEY,
                                           name VARCHAR(255) NOT NULL,
    description VARCHAR(255)
    );

CREATE TABLE IF NOT EXISTS auth_role (
                                         id SERIAL PRIMARY KEY,
                                         name VARCHAR(255) NOT NULL UNIQUE,
    description VARCHAR(255) NOT NULL,
    status INTEGER NOT NULL
    );

CREATE TABLE IF NOT EXISTS auth_user (
                                         id SERIAL PRIMARY KEY,
                                         username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    full_name VARCHAR(255),
    status_id INTEGER NOT NULL REFERENCES user_status(status_id)
    );

CREATE TABLE IF NOT EXISTS auth_user_role (
                                              id SERIAL PRIMARY KEY,
                                              auth_user_id INTEGER NOT NULL REFERENCES auth_user(id),
    auth_role_id INTEGER NOT NULL REFERENCES auth_role(id),
    status INTEGER DEFAULT 1
    );
