alter table ONLINESTORE_PRODUCT_LIST rename column store_product_id to store_product_id__u93591 ;
alter table ONLINESTORE_PRODUCT_LIST drop constraint FK_ONLINESTORE_PRODUCT_LIST_ON_STORE_PRODUCT ;
drop index IDX_ONLINESTORE_PRODUCT_LIST_ON_STORE_PRODUCT ;
alter table ONLINESTORE_PRODUCT_LIST add column PRICE decimal(19, 2) ;
-- alter table ONLINESTORE_PRODUCT_LIST add column PRODUCT_ID uuid ^
-- update ONLINESTORE_PRODUCT_LIST set PRODUCT_ID = <default_value> ;
-- alter table ONLINESTORE_PRODUCT_LIST alter column PRODUCT_ID set not null ;
alter table ONLINESTORE_PRODUCT_LIST add column PRODUCT_ID uuid not null ;
