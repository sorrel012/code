
/* 트랜잭션, Transaction*/

create table tblTran    -- 완전한 복사본
as select name, buseo, jikwi from tblInsa;

select * from tblTran;

--******************* 어떤 명령어를 어떤 순서대로 실행햇는지 반드시 기억해야 함!!!

commit; -- 이 시각부터 새로운 트랜잭션이 시작된다!! > insert, update, delete만 포함된다.
        -- 현재 트랜잭션에 했던 모든 명령어를 있었던 일로 만들어라.(저장)

delete from tblTran where name = '박문수';

select * from tblTran;

-- 우리가 하는 모든 insert, update, delete는 데이터베이스에 적용되지 않는다.
-- > 임시로 메모리에 적용된다. > 실제 DB에는 적용이 되지 않는다.

rollback;   --현재 트랜잭션에서 했던 모든 명령어를 없었던 일로 만들어라.(되돌리기)

-- rollback 직후 > 이전 트랜잭션 완료 > 새로운 트랜잭션이 시작된다.
select * from tblTran;

delete from tblTran where name = '홍길동';
update tblTran set jikwi = '대리' where name = '이순신';

select * from tblTran;

commit; -- 현재 트랜잭션의 모든 작업을 실제 DB에 반영

select * from tblTran;

rollback; -- 이미 commit 돼서 홍길동 다시 못 살림..

select * from tblTran;

/* 트랜잭션 언제 시작? 언제 끝?*/

delete from tblTran where name = '이순신'; 


-- sql developer 창 닫아보기 > rollback하고 끄기 > 정상 종료

-- 다시 켜서..

select * from tblTran;


delete from tblTran where name = '이순신'; 


-- 작업관리자로 강제 종료 > commit 되지 않았음

-- 다시 켜서..

select * from tblTran; 

delete from tblTran where name = '이순신'; 

select * from tblTran;

-- 잠시 뒤에 commit or rollback.. > 보류!
create sequence seqTest;

rollback;

select * from tblTran;

commit;

 
delete from tblTran where jikwi = '사원';

select count(*) from tblTran; -- 27


-- 3. savepoint

update tblTran set jikwi = '이사' where name = '김종서'; --가

savepoint a; --중간 저장

select * from tblTran;

delete from tblTran where name = '허경운';              --나

savepoint b; --중간 저장

insert into tblTran values('하하하', '기획부', '사원');  --다

rollback to b;

select * from tblTran;

rollback to a;

select * from tblTran;

commit;




