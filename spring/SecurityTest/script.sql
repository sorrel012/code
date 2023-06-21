create table users (
   username varchar2(50) not null primary key,
   password varchar2(50) not null,
   enabled char(1) default '1'
);

create table authorities (
   username varchar2(50) not null,
   authority varchar2(50) not null,
   constraint fk_authorities_users foreign key(username) references users(username)
);

create unique index ix_auth_username on authorities (username, authority);

insert into users (username, password) values('hong', '1111');
insert into users (username, password) values('test', '1111');
insert into users (username, password) values('admin', '1111');

insert into authorities (username, authority) values('hong', 'ROLE_MEMBER');
insert into authorities (username, authority) values('test', 'ROLE_MEMBER');
insert into authorities (username, authority) values('admin', 'ROLE_MEMBER');
insert into authorities (username, authority) values('admin', 'ROLE_ADMIN');

------------------------------------------------------------------------------------------------

create table tbl_member (
   userid varchar2(50) not null primary key,
   userpw varchar2(100) not null,
   username varchar2(100) not null,
   regdate date default sysdate,
   updatedate date default sysdate,
   enabled char(1) default '1'
);

create table tbl_member_auth (
   userid varchar2(50) not null,
   auth varchar2(50) not null,
   constraint fk_member_auth foreign key(userid) references tbl_member(userid)
);

select * from tbl_member;

select * from tbl_member_auth;


select 
    m.userid,
    m.userpw,
    m.username,
    m.enabled,
    m.regdate,
    m.updatedate,
    a.auth
from tbl_member m
    left outer join tbl_member_auth a
        on m.userid = a.userid
            where m.userid = ?;
            
-----------------------------------------------------------------------------

create table persistent_logins (
   username varchar(64) not null,
   series varchar(64) primary key,
   token varchar(64) not null,
   last_used timestamp not null
);
