

-- 주소록 테이블
create table tblAddress (
    seq number primary key,
    name varchar2(10) not null,
    age number(3) not null check(age between 1 and 99),
    gender char(1) not null check(gender in ('m', 'f')),
    tel varchar2(15) not null,
    address varchar2(300) not null,    
    regdate date default sysdate not null
);

create sequence seqAddress;

--DML(CRUD)

--Create
insert into tblAddress (seq, name, age, gender, tel, address, regdate)
    values (seqAddress.nextVal, '홍길동', 20, 'm', '010-1234-5678', '서울시 강남구 역삼동 한독빌딩', default);

--Read
select * from tblAddress;

--Update
update tblAddress set age = age + 1 where seq = 1;

--Delete
delete from tblAddress where seq = 1;