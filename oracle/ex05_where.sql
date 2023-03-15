--where

SELECT *
    FROM tblCountry
        where name = '대한민국';
        
select *
    from tblCountry
        where continent = 'AS';
        
select *
    from tblInsa
        where basicpay > 2000000;
    
select *
    from tblInsa
        where basicpay <= 2000000;    
        
select *
    from tblInsa
        where buseo = '개발부';
        
select *
    from tblInsa
        where buseo<> '개발부';
        
select *
    from tblInsa
        where buseo =  '개발부' and jikwi = '부장';       
        
select *
    from tblInsa
        where city = '서울' or city = '경기';
        
select *
    from tblInsa
        where not buseo = '개발부';

-- tblComedian
--1. 몸무게가 60kg 이상이고, 170cm 미만인 사람을 가져오시오 > 3명
select *
    from tblComedian
        where weight >= 60 and height < 170;
        
--2. 몸무게가 70kg 이하인 여자만 가져오시오. 1명
select *
    from tblComedian
        where weight <= 70 and gender = 'f';

--tblInsa
--3. 부서가 '개발부'이고, 급여를 150만원 이상 받는 직원을 가져오시오  4묭
select * 
    from tblInsa
        where buseo='개발부' and basicpay >= 1500000;

--4. 급여 + 수당을 합한 금액이 200만원 이상인 직원을 가져오시오 > 26명
select *
    from tblInsa
        where (basicpay + sudang) >= 2000000;

--between
select *
    from tblComedian
        where height between 172 and 178;

--비교형
--1. 숫자형
select *
    from tblInsa
        where basicpay >= 1500000 and basicpay <= 2000000;
        
select *
    from tblInsa
        where basicpay between 1500000 and 2000000;

--2. 문자형
select * from tblInsa where name >= '박';
select * from tblInsa where name between '박' and '유';

--3. 날짜시간형
desc tblInsa;
select * from tblInsa where ibsadate >= '2000-01-01'; --2000년 이후에 입사한 직원들
select * from tblInsa where ibsadate between '2000-01-01' and '2000-12-31';

-- 홍보부 or 개발부
select * from tblInsa where buseo = '홍보부' or buseo = '개발부';
select * from tblInsa where buseo in ('홍보부', '개발부');

select * from tblInsa
    where jikwi in('과장', '부장') and city in ('서울', '인천')
        and basicpay between 2500000 and 3000000;

-- 패턴 문자열
-- like, _, %

-- _
select name from tblInsa where name like '김__';
select name from tblInsa where name like '__수';
select name from tblInsa where name like '_길_';

--%
select name from tblInsa where name like '김%';
select * from tblAddressBook where address like '서울특별시%';
select * from tblAddressBook where address like '%동대문구%';
select * from tblAddressBook where name like '이%';
select * from tblAddressBook where name like '%이';
select * from tblAddressBook where name like '%이%';

--여직원만
select * from tblInsa where ssn like '______-2______';
select * from tblInsa where ssn like '%-2%';
