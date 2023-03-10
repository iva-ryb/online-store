create table ONLINESTORE_LEGAL_PERSON (
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
    FULL_NAME_LEGAL varchar(255),
    NAME varchar(255),
    EMAIL varchar(255),
    USER_ID uuid,
    --
    primary key (ID)
);