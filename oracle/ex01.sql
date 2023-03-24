
-- 단일라인 주석 (Ctrl + /)

/*
    다중라인 주석
*/

alter user hr account unlock;   --계정 풀기
alter user hr account lock;      --계정 잠그기


alter user movie account unlock;   --계정 풀기

alter user movie identified by java1234; --암호 바꾸기

--현재 계정이 보유하고 있는 테이블 목록 가져오기
select * from tabs;

--현재 작성중인 파일 > 스크립트 파일(*.sql)
-- *** 스크립트 파일은 계정에 비종속적이다. > 계정에 독립적이다.
-- *** 스크립트 내용을 실행할 당시의 접속 상태가 누구인지가 중요하다.

-- 파란색 > 키워드
-- 검정색 > 식별자
select * from REGIONS;      --부서 지역 국가 대륙 정보
select * from COUNTRIES;    --부서 지역 국가 정보
select * from LOCATIONS;    --부서 지역 정보
select * from DEPARTMENTS;  --부서 정보
select * from JOBS;         --직원 직업 정보
select * from EMPLOYEES;    --직원 정보
select * from JOB_HISTORY;  --

select * from tabs; --수업은 이걸로..

SELECT * FROM TABS;

select * from TABS;

--Ctrl + F7
SELECT
    *
FROM
    tabs; --FM (키워드는 대문자, 식별자는 검정색)
    
-- 식별자 > 30바이트 이내(30글자 이내)   
create table aaa (
    num number
);

create table aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa (
    num number
);

--password identifier longer than 30 bytes was specified.
create table aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa (
    num number
);


