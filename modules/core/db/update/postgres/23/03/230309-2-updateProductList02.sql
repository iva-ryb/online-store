alter table ONLINESTORE_PRODUCT_LIST rename column store_product_id to store_product_id__u30608 ;
alter table ONLINESTORE_PRODUCT_LIST drop constraint FK_ONLINESTORE_PRODUCT_LIST_ON_STORE_PRODUCT ;
drop index IDX_ONLINESTORE_PRODUCT_LIST_ON_STORE_PRODUCT ;
alter table ONLINESTORE_PRODUCT_LIST add column PRODUCT_ID uuid ;
