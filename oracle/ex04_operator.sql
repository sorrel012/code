--연산자, Operator

desc tblCountry;
select * from tblCountry;


select population, area, population + area
    from tblCountry;

select name || capital
    from tblCountry;

-- 컬럼명 > 가공된 컬럼명 > 올바른 이름으로 수정 > 컬럼명 바꾸기 > 별칭(Alias)
-- 식별자 "컬럼명|바꿀 컬럼명"

select name as '이름';

drop table tblType;

create table tblType (
    num1 number,
    num2 varchar2(40)
);

insert into tblType (num1, num2) values (123, '123'); --숫자는 오른쪽 정렬, 문자열은 왼쪽 정렬

select * from tblType;