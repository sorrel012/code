
--회원
drop table tblUser;

create table tblUser (
    id varchar2(50) primary key,
    pw varchar2(50) not null,
    name varchar2(50) not null,
    email varchar2(100) not null,
    lv char(1) not null,
    pic varchar2(100) default 'pic.png' not null,
    profile varchar2(500) not null
);


--게시판
create table tblBoard(
    seq number primary key,                         --번호(PK)
    subject varchar2(300) not null,                 --제목
    content varchar2(4000) not null,                --내용
    id varchar2(30) not null references tblUser(id),--아이디(FK)
    regdate date default sysdate not null,          --작성시각
    readcount number default 0 not null             --읽음
);

create sequence seqBoard;

create or replace view vwBoard
as
select
    seq, subject, id, regdate, readcount,
    (select name from tblUser where id = tblBoard.id) as name
from tblBoard order by seq desc;
