FROM postgres
LABEL descriptoin="Test Docker for PostgreSQL"
LABEL maintainer="Ivan Palamarchuk, vanavana978@gmail.com"
LABEL version="1.0"

ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD 1234
ENV POSTGRES_DB palamarchuk-db

COPY scripts/db_script.sql /docker-entrypoint-initdb.d