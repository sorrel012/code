create table tblCode (
    seq number primary key,                 --번호(PK)
    subject varchar2(500) not null,         --제목(설명)
    code varchar2(2000) not null,           --코드조각
    regdate date default sysdate not null,  --날짜 시간
    language varchar2(50) not null          --언어 종류
);

create sequence seqCode;

select * from tblCode;
