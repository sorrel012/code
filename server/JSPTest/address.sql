create table tblAddress (
    seq number primary key,         --번호(PK)
    name varchar2(30) not null,     --이름
    age number(3) not null,         --나이
    tel varchar2(15) not null,      --연락처
    address varchar2(300) not null  --주소
);

create sequence seqAddress;