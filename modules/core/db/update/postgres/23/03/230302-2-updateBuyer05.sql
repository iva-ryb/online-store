alter table ONLINESTORE_BUYER add constraint FK_ONLINESTORE_BUYER_ON_USER foreign key (USER_ID) references SEC_USER(ID);
create index IDX_ONLINESTORE_BUYER_ON_USER on ONLINESTORE_BUYER (USER_ID);
