create table tblMember (
    id varchar2(30) not null primary key,
    name varchar2(30) not null,
    pw varchar2(30) not null,
    email varchar2(100) not null,
    gender char(1) not null,
    regdate date default sysdate not null,
    enabled char(1) default '1'
);

create table tblAuth(
    id varchar2(30) not null references tblMember(id),
    auth varchar2(50) not null
);

alter table tblMember
    modify(pw varchar2(65));
    
select * from tblMember;

select * from tblAuth;

select 
    m.id, pw, name, email, gender,
    regdate, enabled, auth
from tblMember m
    left outer join tblAuth a
        on m.id = a.id
            where m.id = 'cat';