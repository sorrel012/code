
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
    seq, subject, id, readcount,
    (select name from tblUser where id = tblBoard.id) as name,
    (sysdate - regdate) as isnew,
    
    case
        when to_char(sysdate, 'yyyy-mm-dd') = to_char(regdate, 'yyyy-mm-dd') 
            then to_char(regdate, 'hh24:mi:ss')
        else
            to_char(regdate, 'yyyy-mm-dd')
    end as regdate,
    
    (select count(*) from tblComment where bseq = tblBoard.seq) as ccnt,
    content,
    depth
    
from tblBoard order by thread desc;


select * from vwBoard;


--댓글
create table tblComment (
    seq number primary key,                         --번호(PK)
    content varchar2(2000) not null,                --댓글내용
    id varchar2(50) not null references tblUser(id),--아이디(FK)
    regdate date default sysdate not null,          --날짜
    bseq number not null references tblBoard(seq)   --부모글(FK)
);

create sequence seqComment;


--답변형 게시판
create table tblBoard(
    seq number primary key,                         --번호(PK)
    subject varchar2(300) not null,                 --제목
    content varchar2(4000) not null,                --내용
    id varchar2(30) not null references tblUser(id),--아이디(FK)
    regdate date default sysdate not null,          --작성시각
    readcount number default 0 not null,            --읽음
    thread number not null,                         --답변형(정렬)
    depth number not null                           --답변형(출력)
);
