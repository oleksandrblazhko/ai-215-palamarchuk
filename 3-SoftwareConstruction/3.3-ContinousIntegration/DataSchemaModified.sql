CREATE DOMAIN positive_integer AS INT
CHECK (value ~ '^[1-9][0-9]{0,2}$');

-- Создание таблицы пользователей
CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    login VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
) -- убрал точку с запятой

CREATE TABLE cleaning_parameters (
    parameters_id SERIAL PRIMARY KEY,
    user_id INT REFERENCES users (user_id),
    na POSITIVE_INTEGER,
    k POSITIVE_INTEGER,
    ca POSITIVE_INTEGER,
    sand POSITIVE_INTEGER,
    salt POSITIVE_INTEGER,
    rust POSITIVE_INTEGER,
    strictness NUMERIC CHECK (strictness BETWEEN 0 AND 1)
);

-- Текущие данные системы очистки
CREATE TABLE cleaning_system_current_data (
    current_data_id SERIAL PRIMARY KEY,
    user_id INT REFERENCES users (user_id),
    na INT,
    k INT,
    ca INT,
    sand INT,
    salt INT,
    rust INT
);

-- Параметры отчета
CREATE TABLE report_parameters (
    report_parameters_id SERIAL PRIMARY KEY,
    user_id INT REFERENCES users (user_id),
    frequency INT,
    details VARCHAR(255),
    excluded_options JSON
);

-- Отчеты
CREATE TABLE reports (
    report_id SERIAL PRIMARY KEY,
    user_id INT REFERENCES users (user_id),
    body TEXT,
    created_at TIMESTAMP,
    recommendation TEXT
);
