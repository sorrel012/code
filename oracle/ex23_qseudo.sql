
/* pseudo */

select  
    name, buseo,    --컬럼(속성)  > output > 객체의 특성에 따라 다른 값을 가진다.(개인 데이터)
    sysdate,        --함수        > output > 모든 레코드가 동일한 값을 가진다.(정적 데이터)
    substr(name, 2),--함수        > input + output > 객체마다 다른 값을 가진다.
    '상수',         --상수        > output > 모든 레코드가 동일한 값을 가진다.(정적 데이터)
    rownum          --의사 컬럼   > output > 객체의 특성에 따라 다른 값을 가진다.(개인 데이터)
from tblInsa;

select name, buseo, rownum from tblInsa;
select name, buseo, rownum from tblInsa where rownum = 1; --위치로 검색
select name, buseo, rownum from tblInsa where rownum <= 5;

select name, buseo, rownum from tblInsa where rownum = 10;
select name, buseo, rownum from tblInsa where rownum > 5;


select 
    name, buseo, rownum --3. 소비
from tblInsa            --1. 이 시점의 데이터를 가지고 rownum이 이미 할당되어 있다.****
    where rownum = 1;   --2. 조건
    
select 
    name, buseo, rownum --3. 소비
from tblInsa            --1. 생성
    where rownum = 3;   --2. 조건 > 조건을 충족하지 않을 경우 index가 shift됨.. > 


select 
    name, buseo, rownum
from tblInsa      
    order by basicpay desc; -- order by 전에 rownum이 매겨지기 때문에 order by를 할 경우 rownum이 뒤죽박죽 섞인다.  
    
select
    name, buseo, basicpay, rownum
from (select 
            name, buseo, basicpay, rownum
        from tblInsa      
            order by basicpay desc)
    where rownum <= 5;


-- 인구수가 가장 많은 나라 1~3등
SELECT
    *
FROM (SELECT * FROM tblcountry WHERE population IS NOT NULL ORDER BY population DESC)
    WHERE ROWNUM <= 3;

--1. 급여 순으로 정렬
SELECT a.*, ROWNUM FROM (SELECT * FROM tblinsa ORDER BY basicpay DESC) a;

SELECT a.*, ROWNUM FROM (SELECT * FROM tblinsa ORDER BY basicpay DESC) a WHERE ROWNUM = 1;
SELECT a.*, ROWNUM FROM (SELECT * FROM tblinsa ORDER BY basicpay DESC) a WHERE ROWNUM <= 5;
SELECT a.*, ROWNUM FROM (SELECT * FROM tblinsa ORDER BY basicpay DESC) a WHERE ROWNUM = 3;

SELECT * FROM(SELECT a.*, ROWNUM AS rnum FROM (SELECT * FROM tblinsa ORDER BY basicpay DESC) a)
    WHERE rnum = 3;
    
SELECT * FROM tblinsa;

-- 5번째 뚱뚱한 사람?
SELECT * FROM tblComedian;

-- 1. 정렬
SELECT * FROM tblcomedian ORDER BY weight DESC;

--2. 서브쿼리 > rownum 별칭
SELECT a.*, ROWNUM AS rnum FROM(SELECT * FROM tblcomedian ORDER BY weight DESC) a;

--3. 서브쿼리 > rownum 고정시키기 위해서
SELECT * FROM (SELECT a.*, ROWNUM AS rnum FROM(SELECT * FROM tblcomedian ORDER BY weight DESC) a)
    WHERE rnum = 5;
    

--====================================================Q=======================================================

-- 1. tblInsa. 남자 급여(기본급+수당)을 (내림차순)순위대로 가져오시오. (이름, 부서, 직위, 급여, 순위 출력)
SELECT name, buseo, jikwi, basicpay+sudang, rnum FROM(SELECT a.*, ROWNUM AS rnum FROM(SELECT * FROM tblinsa 
                                                        WHERE substr(ssn, 8, 1) = '1' 
                                                           ORDER BY basicpay+sudang DESC) a);


-- 2. tblInsa. 여자 급여(기본급+수당)을 (오름차순)순위대로 가져오시오. (이름, 부서, 직위, 급여, 순위 출력)
SELECT name, buseo, jikwi, basicpay+sudang, rnum FROM(SELECT a.*, ROWNUM AS rnum FROM(SELECT * FROM tblinsa 
                                                          WHERE substr(ssn, 8, 1) = '2' 
                                                             ORDER BY basicpay+sudang DESC) a);
                                                                                
-- 3. tblInsa. 여자 인원수가 (가장 많은 부서 및 인원수) 가져오시오.
select a.*, rownum from(select buseo, count(*) as count  from tblInsa 
                         where substr(ssn, 8, 1) = '2'
                            group by buseo
                             order by count(*) desc) a
    where rownum = 1;



-- 4. tblInsa. 지역별 인원수 (내림차순)순위를 가져오시오.(city, 인원수)
select a.*, rownum
    from (select city, count(*) as count 
            from tblInsa group by city order by count(*) desc) a;            


-- 5. tblInsa. 부서별 인원수가 가장 많은 부서명 및 인원수 출력.
select a.*, rownum
    from (select buseo, count(*) as count from tblInsa 
            group by buseo order by count(*) desc) a
    where rownum = 1;


-- 6. tblInsa. 남자 급여(기본급+수당)을 (내림차순) 3~5등까지 가져오시오. (이름, 부서, 직위, 급여, 순위 출력)
SELECT name, buseo, jikwi, basicpay+sudang, rnum 
    FROM(SELECT a.*, ROWNUM AS rnum FROM(SELECT * FROM tblinsa 
                                            WHERE substr(ssn, 8, 1) = '1' 
                                               ORDER BY basicpay+sudang DESC) a)
where rnum between 3 and 5;


-- 7. tblInsa. 입사일이 빠른 순서로 5순위까지만 가져오시오.
select a.*, rownum from(select * from tblInsa order by ibsadate) a
    where rownum <= 5; 
    
    
-- 8. tblhousekeeping. 지출 내역(가격 * 수량) 중 가장 많은 금액을 지출한 내역 3가지를 가져오시오.
select a.*, rownum from (select * from tblhousekeeping
                           order by price*qty desc) a
    where rownum <= 3;
    

-- 9. tblinsa. 평균 급여 2위인 부서에 속한 직원들을 가져오시오.
select * from tblInsa 
    where buseo = (select buseo from (select a.*, rownum as rnum from (select round(avg(basicpay+sudang), 2) as "avg(salary)", buseo from tblinsa 
                                                    group by buseo order by round(avg(basicpay+sudang), 2) desc)a)
                    where rnum = 2);   


-- 10. tbltodo. 등록 후 가장 빠르게 완료한 할일을 순서대로 5개 가져오시오.
select a.*, rownum from (select * from tblTodo where completedate is not null 
                            order by completedate-adddate) a
    where rownum <= 5;


-- 11. tblinsa. 남자 직원 중에서 급여를 3번째로 많이 받는 직원과 9번째로 많이 받는 직원의 급여 차액은 얼마인가?

select 
    (select basicpay+sudang from (select a.*, rownum as rnum from(select * from tblInsa 
                                 where substr(ssn, 8, 1) = '1'
                                      order by basicpay+sudang desc) a)
        where rnum = 3)
    -
    (select basicpay+sudang from (select a.*, rownum as rnum from(select * from tblInsa 
                                    where substr(ssn, 8, 1) = '1'
                                        order by basicpay+sudang desc) a)
        where rnum = 9) as gap        
from dual;





    
