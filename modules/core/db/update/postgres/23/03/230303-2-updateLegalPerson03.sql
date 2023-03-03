alter table ONLINESTORE_LEGAL_PERSON rename column type to type__u17900 ;
alter table ONLINESTORE_LEGAL_PERSON rename column deleted_by to deleted_by__u39132 ;
alter table ONLINESTORE_LEGAL_PERSON rename column delete_ts to delete_ts__u17769 ;
alter table ONLINESTORE_LEGAL_PERSON rename column updated_by to updated_by__u08674 ;
alter table ONLINESTORE_LEGAL_PERSON rename column update_ts to update_ts__u73139 ;
alter table ONLINESTORE_LEGAL_PERSON rename column created_by to created_by__u05065 ;
alter table ONLINESTORE_LEGAL_PERSON rename column create_ts to create_ts__u41061 ;
alter table ONLINESTORE_LEGAL_PERSON rename column version to version__u41445 ;
alter table ONLINESTORE_LEGAL_PERSON alter column version__u41445 drop not null ;
