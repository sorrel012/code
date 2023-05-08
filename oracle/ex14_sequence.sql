
/* sequence */


create sequence seqNum;

drop sequence seqNum;

select seqNum.nextVal from dual;

create sequence seqTest;

select seqTest.nextVal from dual; 

drop table tblMemo;


create table tblMemo (

    seq number(3) primary key,                                    
    name varchar2(30),
    memo varchar2(1000),
    regdate date
    
);

--메모 번호 시퀀스 객체
create sequence seqMemo;

insert into tblMemo (seq, name, memo, regdate)
    values (seqMemo.nextVal, '홍길동', '메모입니다.' || seqMemo.nextVal, sysdate);
    
select max(seq) from tblMemo;

-- currVal > 시퀀스 객체가 마지막에 만든 숫자를 확인하는 함수 
select seqMemo.currVal from dual;


drop sequence seqMemo;

create sequence seqMemo
                    start with 7;

select * from tblMemo;


-- 일련번호 > 숫자로만 X
-- 쇼핑몰 상품번호 > ABC10010

select seqNum.nextVal from dual;

select 'ABC' || seqNum.nextVal from dual;

select 'ABC' || to_char(seqNum.nextVal, '0000') from dual;

select 'ABC' || ltrim(to_char(seqNum.nextVal, '0000')) from dual;


/*option*/

drop sequence seqNum;

create sequence seqNum
                start with 200;
                
create sequence seqNum
                increment by 100;

create sequence seqNum
                increment by -1;

create sequence seqNum
                start with 100
                increment by -1
                maxvalue 100;

create sequence seqNum
                maxvalue 10;    
                
create sequence seqNum
                increment by -1
                minvalue -10;

create sequence seqNum
                increment by 1
                start with 1
                maxvalue 10
                cycle
                cache 20;
                
select seqNum.nextVal from dual;


-- 버그 > 가끔씩 캐시 휘리릭 날라감..

-- 구멍이 발생해도 상관 없음.. 캐시번호부터 다시 시작해도 됨....

-- 하지만 구멍을 메꾸고 싶다면 start with 활용하기





