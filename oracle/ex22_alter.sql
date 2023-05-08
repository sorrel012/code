
/* alter */
drop table tblEdit;

create table tblEdit (
    seq number primary key,
    data varchar2(20) not null
);

insert into tblEdit values (1, '마우스');
insert into tblEdit values (2, '키보드');
insert into tblEdit values (3, '모니터');


-- 1. 새로운 컬럼 추가하기
-- 가격 컬럼 추가하기 > price, number
alter table tblEdit 
    add (price number not null);

alter table tblEdit 
    add (price number not null);

desc tblEdit;

delete from tblEdit;

select * from tblEdit;

alter table tblEdit
    add (memo varchar2(100) not null);


insert into tblEdit values (1, '마우스', 10000, '로지텍');
insert into tblEdit values (2, '키보드', 20000, 'MS');
insert into tblEdit values (3, '모니터', 30000, 'Dell');


-- 2. 컬럼 삭제하기
alter table tblEdit
    drop column memo;
    
alter table tblEdit --PK 컬럼 삭제.. > 절대 금지!!
    drop column seq;

-- 3. 컬럼 수정하기
insert into tblEdit values (4, '인텔 i7 13세대 최신형 노트북');

--3.1 컬럼의 길이 수정하기(확장/축소)
alter table tblEdit
    modify (data varchar2(100));

desc tblEdit;

select * from tblEdit;

--3.2 컬럼의 제약사항 수정하기
alter table tblEdit
    modify (data varchar2(100) null);
    

--3.3 컬럼의 자료형 수정하기

delete from tblEdit;

alter table tblEdit
    modify (data number);


alter table tblEdit
    add (price number default 0 not null );

select * from tblEdit;


