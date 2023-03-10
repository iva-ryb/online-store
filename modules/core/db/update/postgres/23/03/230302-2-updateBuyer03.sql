alter table ONLINESTORE_BUYER rename column user_id to user_id__u80328 ;
alter table ONLINESTORE_BUYER drop constraint FK_ONLINESTORE_BUYER_ON_USER ;
drop index IDX_ONLINESTORE_BUYER_ON_USER ;
