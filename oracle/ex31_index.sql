
/* index */

create table tblIndex
as
select * from tblInsa;

select count(*) from tblIndex; --7,471,104

insert into tblIndex select * from tblIndex;


-- 시간 확인
set timing on;

-- SQL 실행
--1. Ctrl + Enter   > 결과 > 테이블  출력
--2. F5             > 결과 > 텍스트 출력 

select * from tblInsa;


-- 인덱스 없이 검색 > 2초
select distinct name from tblIndex where name = '홍길동';

-- name > 인덱스 생성 > 9초
create index idxName
    on tblIndex(name);
    
-- 인덱스 검색 > 0초
select distinct name from tblIndex where name = '홍길동';


/*
    인덱스 종류
    1. 고유 인덱스
    2. 비고유 인덱스
    3. 단일 인덱스
    4. 복합 인덱스
    5. 함수기반 인덱스

*/
select * from tblInsa;

--1. 고유 인덱스
create unique index idxName on tblIndex(name);

--2. 비고유 인덱스

--3. 단일 인덱스
create index idxBuseo on tblIndex(buseo);

select count(*) from tblIndex where buseo = '기획부'; --0.016초
select count(*) from tblIndex where name = '유관순' and buseo = '기획부'; --0.125초 > 인덱스 부분 적용

--4. 복합 인덱스
create index idxNameBuseo on tblIndex(name, buseo);

select count(*) from tblIndex where name = '유관순' and buseo = '기획부'; -- 0.00초
select count(*) from tblIndex where buseo = '기획부' and name = '유관순'; -- 0.00초

--5. 함수 기반 인덱스
create index idxSsn on tblIndex(ssn);
select count(*) from tblIndex where ssn = '790304-1788896';
select count(*) from tblIndex where substr(ssn, 8, 1) = '1'; --1.875초

create index idxSsn2 on tblIndex(substr(ssn, 8, 1));
select count(*) from tblIndex where substr(ssn, 8, 1) = '1'; --0.499초

