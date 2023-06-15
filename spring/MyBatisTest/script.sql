create table tblMyBatis (
    seq number primary key,         --번호(PK)
    name varchar2(30) not null,     --이름
    age number(3) not null,         --나이
    address varchar2(300) not null, --주소
    gender char(1) not null         --성별(m,f)
);

create sequence seqMyBatis;

insert into tblMyBatis(seq, name, age, address, gender) values (seqMyBatis.nextVal, '홍길동', 20, '서울시 강남구', 'm');

select * from tblMyBatis;