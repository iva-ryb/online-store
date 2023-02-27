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
    BUYER_ID uuid,
    DISCOUNT integer,
    STATUS varchar(255),
    --
    primary key (ID)
)^
-- end ONLINESTORE_ONLINE_ORDER
-- begin SEC_USER
alter table SEC_USER add column BUYER_ID uuid ^
alter table SEC_USER add column DTYPE varchar(100) ^
update SEC_USER set DTYPE = 'sec$ExtUser' where DTYPE is null ^
-- end SEC_USER
