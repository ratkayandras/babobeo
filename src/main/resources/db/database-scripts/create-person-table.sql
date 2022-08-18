--liquibase formatted sql

--changeset ratkaya:create-person-table.sql runInTransaction:false
--preconditions onFail:MARK_RAN
--precondition-sql-check expectedResult:0 SELECT count(*) FROM information_schema.tables where table_schema = 'public' and table_name = 'person';

CREATE TABLE public.person
(
    id         bigint NOT NULL,
    first_name VARCHAR,
    last_name  VARCHAR,
    dob        DATE,
    CONSTRAINT person_pkey PRIMARY KEY (id)
);

--rollback drop table public.person;