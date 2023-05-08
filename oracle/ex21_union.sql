
/* 관계 대수 연산 */


/* union, 합집합 */
-- 남자 + 여자
select * from tblMen
union
select * from tblWomen;


-- 회사 부서별 > 게시판
select * from 영업부게시판;
select * from 총무부게시판;
select * from 개발부게시판;

--사장님 > 모든 부서의 게시판 > 한번에 열람
select * from 영업부게시판
union
select * from 총무부게시판
union
select * from 개발부게시판;


create table tblUnionA (
    name varchar2(30) not null
);

create table tblUnionB (
    name varchar2(30) not null
);

insert into tblUnionA values('강아지'); --*
insert into tblUnionA values('고양이'); --*
insert into tblUnionA values('토끼');
insert into tblUnionA values('거북이');
insert into tblUnionA values('병아리');

insert into tblUnionB values('호랑이');
insert into tblUnionB values('사자');
insert into tblUnionB values('강아지'); --*
insert into tblUnionB values('코끼리');
insert into tblUnionB values('고양이'); --*

commit;

-- union > 중복값 허용x
select * from tblUnionA
union
select * from tblUnionB;

-- union > 중복값 허용o
select * from tblUnionA
union all
select * from tblUnionB;


/* intersect, 교집합 */
select * from tblUnionA
intersect
select * from tblUnionB;

/*minus, 차집합*/
select * from tblUnionA
minus
select * from tblUnionB;


select * from tblUnionB
minus
select * from tblUnionA;


