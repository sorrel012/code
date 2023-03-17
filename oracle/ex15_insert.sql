
/* insert */

drop table tblMemo;

create table tblMemo (
    
    seq number(3) primary key,
    name varchar2(50),
    memo varchar2(1000) not null,
    regdate date default sysdate
    
);

drop sequence seqMemo;
create sequence seqMemo;

--1. 표준
-- - 원본 테이블에 정의된 컬럼 순서와 개수대로 컬럼리스트를 만들고 그에 따라 값리스트를  구성하는 방법
insert into tblMemo (seq, name, memo, regdate) 
            values(seqMemo.nextVal, '홍길동', 'memo', sysdate);
       
--2. 컬럼리스트의 순서는 원본 테이블과 상관이 없다.
insert into tblMemo (name, memo, regdate, seq)             
            values('gildong', 'memo2', sysdate, seqMemo.nextVal);
            

--3. 컬럼 리스트의 컬럼 개수와 값리스트의 값 개수는 반드시 일치해야 한다. 
insert into tblMemo (seq, name, memo, regdate)            --4
            values(seqMemo.nextVal, '홍길동', sysdate);    --3

--4. 컬럼 리스트의 컬럼 개수와 값리스트의 값 개수는 반드시 일치해야 한다.
insert into tblMemo (seq, name, memo)  --3
            values(seqMemo.nextVal, '홍길동', 'memo', sysdate);    --4
            
--5. null조작 > name을 안 넣고 싶다. > null 대입

--5.1 null 상수 사용
insert into tblMemo (seq, name, memo, regdate)
            values(seqMemo.nextVal, null, 'memo', sysdate); 

--5.2 컬럼 생략
insert into tblMemo (seq, memo, regdate)
            values(seqMemo.nextVal, 'memo', sysdate); 


--6. dafault 조작

--6.1 default 상수 사용
insert into tblMemo (seq, name, memo, regdate)
            values(seqMemo.nextVal, 'honggildong', 'memo', default); 
            

--6.2 컬럼 생략
insert into tblMemo (seq, name, memo)
            values(seqMemo.nextVal, 'honggildong', 'memo'); 

--6.3 null 상수를 사용하면 사용자의 의사를 우선해서 default가 동작하지 않음.
insert into tblMemo (seq, name, memo, regdate)
            values(seqMemo.nextVal, 'honggildong', 'memo', null); 
            

--7. 단축 표현
-- 컬럼리스트 생략 가능 > 원본 테이블의 컬럼 순서를 참고해서 실행
-- 컬럼리스트를 생략하면 값리스트의 순서를 변경할 수 없다!!
insert into tblMemo values(seqMemo.nextVal, 'honggildong', 'memo', sysdate);

insert into tblMemo values(seqMemo.nextVal, null, 'memo', sysdate);

insert into tblMemo values(seqMemo.nextVal, 'honggildong', 'memo', default);


-- 8. tblMemo 테이블 복사 > tbleMemoCopy 테이블

create table tblMemoCopy (
    
    seq number(3) primary key,
    name varchar2(50),
    memo varchar2(1000) not null,
    regdate date default sysdate
    
);

insert into tblMemoCopy select * from tblMemo;



drop table tblMemoCopy;

--9. tblMemo 테이블 복사 
-- 컬럼 구조는 복사가 되는데, 제약 사항은 복사되지 않는다.************************
-- 실사용은 힘들고, 개발용으로 대용량의 더미가 필요한 경우에 사용
create table tblMemoCopy as select * from tblMemo;


select * from tblMemo; 
select * from tblMemoCopy; 
