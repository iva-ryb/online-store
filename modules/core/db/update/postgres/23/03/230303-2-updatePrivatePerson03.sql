alter table ONLINESTORE_PRIVATE_PERSON rename column type to type__u16494 ;
alter table ONLINESTORE_PRIVATE_PERSON rename column deleted_by to deleted_by__u32463 ;
alter table ONLINESTORE_PRIVATE_PERSON rename column delete_ts to delete_ts__u66406 ;
alter table ONLINESTORE_PRIVATE_PERSON rename column updated_by to updated_by__u81692 ;
alter table ONLINESTORE_PRIVATE_PERSON rename column update_ts to update_ts__u57677 ;
alter table ONLINESTORE_PRIVATE_PERSON rename column created_by to created_by__u65888 ;
alter table ONLINESTORE_PRIVATE_PERSON rename column create_ts to create_ts__u63119 ;
alter table ONLINESTORE_PRIVATE_PERSON rename column version to version__u97707 ;
alter table ONLINESTORE_PRIVATE_PERSON alter column version__u97707 drop not null ;
