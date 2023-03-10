alter table ONLINESTORE_PRODUCT_LIST rename column product_id to product_id__u38045 ;
alter table ONLINESTORE_PRODUCT_LIST drop constraint FK_ONLINESTORE_PRODUCT_LIST_ON_PRODUCT ;
drop index IDX_ONLINESTORE_PRODUCT_LIST_ON_PRODUCT ;
alter table ONLINESTORE_PRODUCT_LIST add column STORE_PRODUCT_ID uuid ;
