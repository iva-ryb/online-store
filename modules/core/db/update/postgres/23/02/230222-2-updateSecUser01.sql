alter table SEC_USER add constraint FK_SEC_USER_ON_BUYER foreign key (BUYER_ID) references ONLINESTORE_BUYER(ID);
create index IDX_SEC_USER_ON_BUYER on SEC_USER (BUYER_ID);
