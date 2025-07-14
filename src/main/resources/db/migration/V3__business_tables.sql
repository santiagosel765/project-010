CREATE TABLE IF NOT EXISTS bus_client (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    status INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS bus_provider (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    contact VARCHAR(255),
    status INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS bus_quote (
    id SERIAL PRIMARY KEY,
    client_id INTEGER NOT NULL REFERENCES bus_client(id),
    description VARCHAR(255),
    total NUMERIC(10,2),
    status INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS bus_purchase (
    id SERIAL PRIMARY KEY,
    provider_id INTEGER NOT NULL REFERENCES bus_provider(id),
    description VARCHAR(255),
    total NUMERIC(10,2),
    status INTEGER NOT NULL
);
