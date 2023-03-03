create table ONLINESTORE_PRIVATE_PERSON (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    CITY varchar(255),
    STREET varchar(255),
    BUILDING varchar(255),
    --
    FULL_NAME_Private varchar(255),
    FIRST_NAME varchar(255),
    SECOND_NAME varchar(255),
    PATRONYMIC varchar(255),
    EMAIL varchar(255),
    USER_ID uuid,
    --
    primary key (ID)
);