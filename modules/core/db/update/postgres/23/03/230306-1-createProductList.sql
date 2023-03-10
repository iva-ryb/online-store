create table ONLINESTORE_PRODUCT_LIST (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    product_ID uuid,
    ONLINEORDER_ID uuid,
    --
    primary key (ID)
);