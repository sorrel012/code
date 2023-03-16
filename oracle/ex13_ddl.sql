
/* DDL */

create table tblMemo (

    --컬럼명 자료형(길이) NULL 제약사항
    seq number(3) null,         --메모번호
    name varchar2(30) null,     --작성자
    memo varchar2(1000) null,   --메모
    regdate date null           --작성날짜

);

insert into 테이블(컬럼리스트) values (값리스트);

insert into tblMemo (seq, name, memo, regdate)
            values (1, '홍길동', '메모입니다.', sysdate);
            
insert into tblMemo (seq, name, memo, regdate)
            values (2, '아무개', null, sysdate); --메모 내용 생략(null)

insert into tblMemo (seq, name, memo, regdate)
            values (3, null, null, null); --메모 내용 생략(null)     
            
insert into tblMemo (seq, name, memo, regdate) 
            values (null, null, null, null);   --절대 생성 금지!!!!!!
            
insert into tblMemo (seq, name, memo, regdate)
            values (4, '홍길동', '메모입니다.', '2023-03-15');            

insert into tblMemo (seq, name, memo, regdate)
            values (5, '홍길동', '메모입니다.', to_date('2023-03-15 12:30:50', 'yyyy-mm-dd hh24:mi:ss'));       
            
select * from tblMemo;




