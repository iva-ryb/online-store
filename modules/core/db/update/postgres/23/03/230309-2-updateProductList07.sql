alter table ONLINESTORE_PRODUCT_LIST add constraint FK_ONLINESTORE_PRODUCT_LIST_ON_PRODUCT foreign key (PRODUCT_ID) references APPLICATION_PRODUCT(ID);
create index IDX_ONLINESTORE_PRODUCT_LIST_ON_PRODUCT on ONLINESTORE_PRODUCT_LIST (PRODUCT_ID);
