CREATE DOMAIN positive_integer AS INT CHECK (positive_integer ~ '^[1-9][0-9]{0,2}$');

-- Создание таблицы пользователей
CREATE TABLE users (
    user_id serial PRIMARY KEY,
    login VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE cleaning_parameters (
    parameters_id serial PRIMARY KEY,
    user_id INT REFERENCES users(user_id),
    Na positive_integer,
    K positive_integer,
    Ca positive_integer,
    sand positive_integer,
    salt positive_integer,
    rust positive_integer,
    strictness NUMERIC CHECK (strictenss ~ '^(0(\.\d+)?|1(\.0+)?)$')
);

-- Создание таблицы текущих данных системы очистки
CREATE TABLE cleaning_system_current_data (
    current_data_id serial PRIMARY KEY,
    user_id INT REFERENCES users(user_id),
    Na INT,
    K INT,
    Ca INT,
    sand INT,
    salt INT,
    rust INT
);

-- Создание таблицы параметров отчета
CREATE TABLE report_parameters (
    report_parameters_id serial PRIMARY KEY,
    user_id INT REFERENCES users(user_id),
    frequency INT,
    details VARCHAR(255),
    excluded_options JSON
);

-- Создание таблицы отчетов
CREATE TABLE reports (
    report_id serial PRIMARY KEY,
    user_id INT REFERENCES users(user_id),
    body TEXT,
    date TIMESTAMP,
    recommendation TEXT
);
