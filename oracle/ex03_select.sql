--select문

select 컬럼리스트 from 테이블명;


-- 처음 보는 테이블의 구조(스키마, Scheme) 확인
desc employees; --SQL Developer, SQL Plus만 가능

-- 단일 컬럼 조회
select first_name from employees;
select email from employees;

-- 다중 컬럼 조회

select first_name, last_name from employees;

--1.
select first_name, last_name, email, salary, phone_number from employees;

--2.
select first_name, last_name, email, salary, phone_number 
from employees;

--3.
select 
    first_name, last_name, email, salary, phone_number 
from 
    employees;
    
--4.
select first_name, last_name, email, salary, phone_number 
    from employees;

--와일드 카드 사용    
select * --와일드카드(*) > 모든 컬럼
    from employees;
    
-- select절의 컬럼 리스트의 컬럼 순서는 원본 테이블의 컬럼 순서와 무관하다.
select last_name, first_name from employees;

-- 같은 컬럼을 반복해서 가져오는 것도 가능하다.(하지만 그럴 일 x)
select first_name, first_name from employees;   

-- 가공해서는 사용함!
select first_name, length(first_name) from employees;   


create table zipcode  (
   seq                  NUMBER(10)                        not null,
   zipcode              VARCHAR2(50),
   sido                 VARCHAR2(50),
   gugun                VARCHAR2(50),
   dong                 VARCHAR2(50),
   bunji                VARCHAR2(50),
   constraint PK_ZIPCODE primary key (seq)
)

select count(*) from zipcode;

select * from tblAddressBook; --주소록
select * from tblComedian; --코미디언
select * from tblCountry; --국가정보
select * from tblDiary; --다이어리
select * from tblHousekeeping; --가계부
select * from tblInsa; --직원정보
select * from tblMen; --남자
select * from tblWomen; --여자
select * from tblTodo; --할일
select * from tblZoo; --동물






