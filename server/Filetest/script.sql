create table tblFile (
    seq number primary key,                 --번호(PK)
    name varchar2(30) not null,             --작성자
    filename varchar2(50) not null,         --파일명(하드에 저장되는 이름)
    regdate date default sysdate not null   --날짜
);

create sequence seqFile;

