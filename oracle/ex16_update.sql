
/* update */

commit;
rollback;

select * from tblCountry;

-- 대한민국 수도: 서울 > 세종
update tblCountry set capital = '세종'; --대한민국 세계정복.. 큰일..
update tblCountry set capital = '세종' where name = '대한민국';



update tblCountry set
    name = '한국', capital = '제주', continent = 'EU'
        where name = '대한민국';


-- 모든 나라의 인구 증가!! > 일괄적으로 증가 > 10% 증가
update tblCountry set
    population = population * 1.1;

-----------------------------------------------

/*delete*/

commit;
rollback;

select * from tblCountry;

delete from tblCountry where name = '일본';

delete from tblCountry where continent = 'EU';

delete from tblCountry;


/* update, delete 실수 */
--1. 백업
--2. commit/rollback > 트랜잭션 > 현재 세션에 한해서..
--3. 스크립트
