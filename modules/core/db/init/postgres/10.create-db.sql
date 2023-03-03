-- begin ONLINESTORE_BUYER
create table ONLINESTORE_BUYER (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    DTYPE varchar(31),
    --
    TYPE varchar(50),
    USER_ID uuid,
    --
    primary key (ID)
)^
-- end ONLINESTORE_BUYER
-- begin ONLINESTORE_ONLINE_ORDER
create table ONLINESTORE_ONLINE_ORDER (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NUMBER varchar(255),
    BUYER_ID uuid,
    DISCOUNT integer,
    STATUS varchar(255),
    --
    primary key (ID)
)^
-- end ONLINESTORE_ONLINE_ORDER
-- begin ONLINESTORE_PRIVATE_PERSON
create table ONLINESTORE_PRIVATE_PERSON (
    ID uuid,
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
    --
    primary key (ID)
)^
-- end ONLINESTORE_PRIVATE_PERSON
-- begin ONLINESTORE_LEGAL_PERSON
create table ONLINESTORE_LEGAL_PERSON (
    ID uuid,
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
)^
-- end ONLINESTORE_LEGAL_PERSON
-- begin SEC_USER
alter table SEC_USER add column BUYER_ID uuid ^
alter table SEC_USER add column DTYPE varchar(31) ^
update SEC_USER set DTYPE = 'sec$User' where DTYPE is null ^
-- end SEC_USER
