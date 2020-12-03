create table if not exists cic_job_info
(
    id int not null primary key,
    cic_type   varchar(20) null,
    cic_remark varchar(40) null
);