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


