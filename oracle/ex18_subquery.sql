
/* subquery */

-- tblCountry. 인구수가 가장 많은 나라의 이름?
select 
    name
from tblCountry
    where population = (select max(population) from tblCountry);
    
    
-- tblComedian. 체중이 가장 많이 나가는 사람?
select 
    *
from tblComedian
    where weight = (select max(weight) from tblComedian); 
    
    
-- tblInsa. 급여 1등
select *  from tblInsa where basicpay = (select max(basicpay) from tblInsa);


-- tblInsa. 막내 직원
select * from tblInsa where ibsadate = (select max(ibsadate) from tblInsa);


-- tblInsa. 최고참
select * from tblInsa where ibsadate = (select min(ibsadate) from tblInsa);


-- tblInsa. 평균 급여보다 더 많이 받는 직원
select * from tblInsa where basicpay >= (select avg(basicpay) from tblInsa);


--tblInsa. 길동이보다 더 급여를 많이 받는 직원
select * from tblInsa where basicpay > (select basicpay from tblInsa where name='홍길동');



/*1. 조건절 */

-- a. 반환값이 1행 1열 > 단일값 반환 > 값 1개로 취급
select * from tblInsa
    where basicpay >= (select avg(basicpay) from tblInsa);
    
--b. 반환값이 n행 1열 > 다중값(같은 성질의 여러 개 데이터) 반환 > 값 n개로 취급

-- 급여를 260만원 이상 받는 직원이 근무하는 부서 직원들
select * from tblInsa
    where buseo in (select buseo from tblInsa where basicpay >= 2600000);

-- '홍길동'과 같은 지역 + 같은 직위를 가지는 사람이 소속된 부서의 직원 명단
select * from tblInsa
    where buseo in (select buseo from tblInsa 
                        where city = (select city from tblInsa where name='홍길동') 
                            and jikwi = (select jikwi from tblInsa where name='홍길동')
                                and name <> '홍길동');
    
-- c. 반환값이 1행 n열 > 다중값(서로 다른 성질의 여러 개 데이터) 반환 > n:n 비교

-- '홍길동'과 같은 지역 + 같은 직위 > 어떤 직원들?
select * from tblInsa
    where (city, jikwi) = (select city, jikwi from tblInsa where name = '홍길동');

-- '기예주'와 성별, 나이, 직업, 키가 같은 사람?
select * from tblAddressBook
    where (gender, age, job, height) = (select gender, age, job, height from tblAddressBook where name = '기예주');
    
-- d. 반환값이 n행 n열 > 다중값 반환

-- 급여가 260만 이상인 직원과 같은 부서 + 같은 지역에 있는 모든 직원
-- 기획부 + 서울 && 총무부 + 경남    
select * from tblInsa
    where (city, buseo) in (select city, buseo from tblInsa where basicpay >= 2600000);

-- having절에 적용
-- 영업부 평균급여보다 많이 받는 부서의 평균 급여
select 
    buseo,
    avg(basicpay)
from tblInsa
    group by buseo
        having avg(basicpay) > (select avg(basicpay) from tblInsa where buseo = '영업부');


/* 2. 컬럼리스트 */

--a. 컬럼명
select
    name, 
    (select sysdate from dual)
from tblInsa;

select 
    name,
    (select basicpay from tblInsa where name = '홍길동')
from tblInsa;

select 
    name, buseo, basicpay,
    (select round(avg(basicpay)) from tblInsa) as "평균급여"
from tblInsa;


select 
    name, buseo, basicpay,
    (select round(avg(basicpay)) from tblInsa b where b.buseo = a.buseo) as "소속 부서 평균 급여" -- 상관 서브 쿼리
from tblInsa a;


-- 식별자 정리WW

-- 현재 접속중인 계정명은 생략 가능하다.
select * from tblInsa;      -- 생략
select * from hr.tblInsa;   -- 계정명(스키마).테이블명


-- 하나의 select문일 때 컬럼명에서 테이블명은 생략 가능하다.
select name, buseo from tblInsa;                            -- 생략
select hr.tblInsa.name, hr.tblInsa.buseo from hr.tblInsa;   -- 계정명(스키마).테이블명


-- 와일드카드(*)와 다른 컬럼을 동시에 가져오는 방법
select tblInsa.*, sysdate from tblInsa; -- 테이블명.*

-- 테이블 별칭
select i.*, sysdate from tblInsa i;



select 
    name, buseo, basicpay,
    (select round(avg(basicpay)) from tblInsa b where buseo = i.buseo) as "소속 부서 평균 급여"
from tblInsa i;



drop table tblMen;
drop table tblWomen;


-- 남자 명단(이름, 나이) 출력 > 여자친구가 있으면 여자친구(이름, 나이)를 같이 출력하시오.
select 
    name, age, 
    couple as "여자친구 이름",
    (select age from tblWomen where name = i.couple) as "여자친구 나이"
from tblMen i;


/* 3. from절 */

select
    *
from (select * from tblInsa);


select
    *
from (select name, buseo, jikwi from tblInsa);


select
    이름
from(select name as 이름, buseo, jikwi from tblInsa);


select
    name, len
from(select name, length(name) as len from tblInsa);


select
    *
from (select name, age, couple, (select age from tblWomen where name = tblMen.couple) as age_2 from tblMen);


-- employees
select * from employees; --department_id 소속 부서
select * from departments; --location_id 위치 정보
select * from locations;   

select * from employees
    where department_id = (select department_id from departments
                            where location_id = (select location_id from locations
                                                    where city = 'Munich'));

select * from employees
    where department_id in (select department_id from departments
                            where location_id = (select location_id from locations
                                                    where city = 'Seattle'));



--==============================================Q==================================================

-- tblMen. tblWomen. 서로 짝이 있는 사람 중 남자와 여자의 정보를 모두 가져오시오. > select절
--    [남자]        [남자키]   [남자몸무게]     [여자]    [여자키]   [여자몸무게]
--    홍길동         180       70              장도연     177        65
--    아무개         175       null            이세영     163        null
--    ..
select 
    name as "[남자]",
    height as "[남자키]",
    weight as "[남자몸무게]",
    couple as "[여자]",
    (select height from tblWomen where name = i.couple) as "[여자키]",
    (select weight from tblWomen where name = i.couple) as "[여자몸무게]"
from tblMen i;


-- tblAddressBook. 가장 많은 사람들이 가지고 있는 직업은 주로 어느 지역 태생(hometown)인가? > where절
select
    max(hometown) as "지역"
from tblAddressBook
    where job = (select max(job) from tblAddressBook);
    

-- tblAddressBook. 이메일 도메인들 중 평균 아이디 길이가 가장 긴 이메일 사이트의 도메인은 무엇인가? > group by + having
select distinct
    substr(email, instr(email, '@')+1) as 도메인
from tblAddressBook
    group by substr(email, instr(email, '@')+1)
        having avg(instr(email, '@') - 1) = (select 
                                                max(avg(instr(email, '@') - 1))
                                            from tblAddressBook
                                                group by substr(email, instr(email, '@')+1)); 
                                                
    

-- tblAddressBook. 평균 나이가 가장 많은 출신(hometown)들이 가지고 있는 직업 중 가장 많은 직업은? > where + group by + having
select 
    max(job) as 직업
from tblAddressBook
    where hometown = (select hometown from tblAddressBook
                        group by hometown
                            having avg(age) = (select max(avg(age)) from tblAddressBook 
                                                group by hometown));   


-- tblAddressBook. 남자 평균 나이보다 나이가 많은 서울 태생 + 직업을 가지고 있는 사람들을 가져오시오. > where절
select * from tblAddressBook
    where age > (select avg(age) from tblAddressBook group by gender having gender = 'm')
    and hometown = '서울'
    and job <> '취업준비생';


-- tblAddressBook. gmail.com을 사용하는 사람들의 성별 > 세대별(10,20,30,40대) 인원수를 가져오시오. > where절
select
    gender,
    floor(age/10) || '0대' as 세대,
    count(*)
from tblAddressBook
    where substr(email, instr(email, '@')+1)='gmail.com'
        group by gender, floor(age/10)
            order by floor(age/10) asc;



-- tblAddressBook. 가장 나이가 많으면서 가장 몸무게가 많이 나가는 사람과 같은 직업을 가지는 사람들을 가져오시오. > where절
select
    * 
from tblAddressBook
    where job in (select job from tblAddressBook
                    where weight = (select max(weight) from tblAddressBook)
                        and age = (select max(age) from tblAddressBook));


-- tblAddressBook.  동명이인이 여러명 있습니다. 이 중 가장 인원수가 많은 동명이인(모든 이도윤)의 명단을 가져오시오. > where절
select 
    *
from tblAddressBook
    where name = (select name from tblAddressBook
                    group by name
                        having count(name) = (select max(count(name)) from tblAddressBook
                                                group by name));


-- tblAddressBook. 가장 사람이 많은 직업의(332명) 세대별 비율을 구하시오.> where + group by + having
--    [10대]       [20대]       [30대]       [40대]
--    8.7%        30.7%        28.3%        32.2%
select * from tblAddressBook;

select 
    round(count(case
            when floor(age/10) = 1 then 1
    end) / count(*) * 100, 2) as "10대",
    round(count(case
             when floor(age/10) = 2 then 1
    end) / count(*) * 100, 2) as "20대",
    round(count(case
            when floor(age/10) = 3 then 1
    end) / count(*) * 100, 2) as "30대",
    round(count(case
             when floor(age/10) = 4 then 1
    end) / count(*) * 100, 2) as "40대"
from tblAddressBook
    where job = (select job from tblAddressBook
                    group by job
                        having count(job) = (select max(count(job)) from tblAddressBook 
                                                group by job))
        group by age;
    


