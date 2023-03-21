
/* RDBMS가 싫어하는 것..*/

--1. 테이블에 기본키가 없는 상태 + 3. 데이터가 중복되는 상태
create table tblTest(
    name varchar2(30) not null,
    age number(3) not null,
    address varchar2(300) not null
);

insert into tblTest (name, age, address) values ('홍길동', 20, '서울시'); --A
insert into tblTest (name, age, address) values ('아무개', 25, '인천시');
insert into tblTest (name, age, address) values ('호호호', 27, '부산시');

insert into tblTest (name, age, address) values ('홍길동', 20, '서울시'); --B

select * from tblTest;

--홍길동A 이사 > 강릉시
update tblTest set address = '강릉시' where name = '홍길동'; -- 홍길동A + 홍길동B

drop table tblTest;

--2. null이 많은 상태의 테이블

create table tblTest(
    name varchar2(30) not null,
    age number(3) not null,
    address varchar2(300) not null,
    hobby varchar2(300) null
);

insert into tblTest (name, age, address, hobby) values ('홍길동', 20, '서울시', '독서');
insert into tblTest (name, age, address, hobby) values ('아무개', 25, '인천시', null);
insert into tblTest (name, age, address, hobby) values ('호호호', 27, '부산시', '맛집,여행,운동,낮잠');
insert into tblTest (name, age, address, hobby) values ('후후후', 29, '부산시', '운동유튜브 보기');


select * from tblTest;

--독서가 취미?
select * from tblTest where hobby = '독서';


--운동이 취미?
select * from tblTest where hobby = '운동'; -- 검색 결과x..
select * from tblTest where hobby like '%운동%'; -- 정확하지 x

-- 운동 > 신체단력..
update tblTest set hobby='신체단련' where ? ;


-- 취미 컬럼 여러 개..
create table tblTest(   --생성 안 했음
    name varchar2(30) not null,
    age number(3) not null,
    address varchar2(300) not null,
    hobby1 varchar2(300) null,
    hobby2 varchar2(300) null,
    hobby3 varchar2(300) null,
    ...
    hobby8 varchar2(300) null
); -- null이 많은 테이블..

-- 공간 낭비
-- 홍길동, 20, 서울시, 독서, null,null,null,null,null,null,null 

--데이터 조작 곤란
-- select * from tblTest where hobby1 = '운동' or hobby2 = '운동' or .... hobby 8 = '운동';




--table about 직원 정보
--직원(번호(PK), 이름, 급여, 거주지, 담당프로젝트)
create table tblStaff (
    seq number primary key,         --번호(PK)
    name varchar2(30) not null,     --이름
    salary number not null,         --급여
    address varchar2(300) not null, --거주지
    project varchar2(300) null      --담당 프로젝트
);

insert into tblStaff values (1, '홍길동', 300, '서울시', '홍콩 수출');
insert into tblStaff values (2, '아무개', 250, '인천시', 'TV 광고');
insert into tblStaff values (3, '하하하', 350, '부산시', '매출 분석');

select * from tblStaff;


-- 한 명의 직원이 여러 개의 프로젝트 담당 가능
-- '홍길동'에게 담당 프로젝트 1건 추가 > '고객 관리'...
insert into tblStaff values (4, '홍길동', 300, '서울시', '고객 관리');

-- '아무개' 담당 프로젝트 1건 추가 > '게시판 관리'
update tblStaff set project = project || ',게시판 관리' where name = '아무개';



drop table tblStaff;
drop table tblProject;


/* foreign key */

-- 원자값 보장 & 중복 발생 X > 정규화의 일부 (제1 정규화)

-- 부모 테이블(기본 테이블)
create table tblStaff (
    seq number primary key,         --번호(PK)
    name varchar2(30) not null,     --이름
    salary number not null,         --급여
    address varchar2(300) not null  --거주지
);

--자식 테이블(참조 테이블)
create table tblProject (
    seq number primary key,                             --번호(PK) > 가상키
    project varchar2(300) not null,                     --담당 프로젝트
    staff_seq number not null references tblStaff(seq)  --직원 번호 (참조키, 외래키, FK)
);


insert into tblStaff values (1, '홍길동', 300, '서울시');
insert into tblStaff values (2, '아무개', 250, '인천시');
insert into tblStaff values (3, '하하하', 350, '부산시');

insert into tblProject values(1, '홍콩 수출', 1);      --홍길동
insert into tblProject values(2, 'TV 광고', 2);        -- 아무개
insert into tblProject values(3, '매출 분석', 3);      --하하하
insert into tblProject values(4, '노조 협상', 1);      --홍길동
insert into tblProject values(5, '대리점 분양', 2);    --아무개

select * from tblStaff;
select * from tblProject;



--A. 신입 사원 입사 > 신규 프로젝트 담당
--A.1 신입 사원 추가
insert into tblStaff values (4, '호호호', 250, '일산시');

-- A-2. 신규 프로젝트 추가 + 담당 지정
insert into tblProject values (6, '자재 매입', 4);

-- A-3. 신규 프로젝트 추가 + 담당 지정   > 문재 발생!! > 존재하지 않는 직원 번호를 사용(5번..)
insert into tblProject values (7, '고객 유치', 5);


-- 사장님! 고객 유치 담당자 확인
select * from tblStaff
    where seq = (select staff_seq from tblProject where project = '고객 유치');
    
    
--B. '홍길동' 퇴사
--B-1. '홍길동' 정보 삭제
delete from tblStaff where seq = 1;


-- 사장님 > '홍콩 수출' 담당자
select * from tblStaff
    where seq = (select staff_seq from tblProject where project = '홍콩 수출');


--B-2. '아무개' 퇴사 > 인수 인계(위임) > '하하하'
update tblProject set staff_seq = 4 where staff_seq =2 ;

update tblProject set staff_seq = (select seq from tblStaff where name = '하하하')
    where staff_seq = (select seq from tblStaff where name = '아무개');
    
    
-- B-3 '아무개' 퇴사
delete from tblStaff where seq = 2;

-- 사장님 > 'TV 광고'
select * from tblStaff
    where seq = (select staff_seq from tblProject where project = 'TV 광고');

-- 두 테이블의 데이터 비교 > 먼저 존재해야 할 성격의 데이터 > 부모 테이블
    

--비디오 대여점

-- 고객 테이블 > 부모 테이블
create table tblCustomer(
    seq number primary key,         --고객번호(PK)
    name varchar2(30) not null,     --고객명
    tel varchar2(15) not null,      --연락처
    address varchar2(100) not null  --주소
);

-- 판매내역 테이블 > 자식 테이블
create table tblSales (
    seq number primary key,                           --판매번호(PK)
    item varchar2(50) not null,                       --상품명
    qty number not null,                              --수량
    regdate date default sysdate,                     --판매날짜
    cseq number not null references tblCustomer(seq)  --고객번호(FK)
);


--장르 테이블 > 비디오 테이블의 부모 테이블
create table tblGenre (
    seq number primary key,     --장르번호(PK)
    name varchar2(30) not null, --장르명
    price number not null,      --대여가격
    period number not null      --대여기간
);

-- 비디오 테이블 > 장르 테이블의 자식 테이블 / 대여 테이블의 부모 테이블
create table tblVideo (
    seq number primary key,                         --비디오 번호(PK)
    name varchar2(100) not null,                    --비디오 제목
    qty number not null,                            --보유 수량
    company varchar2(50) null,                      --제작사
    director varchar2(50) null,                     --감독
    major varchar2(50) null,                        --주연배우
    genre number not null references tblGenre(seq)  --장르번호(FK)
);

-- 고객 테이블 > 대여 테이블의 부모 테이블
create table tblMember (
    seq number primary key,         --고객번호(PK)
    name varchar2(30) not null,     --고객명
    grade number(1) not null,       --고객등급
    byear number(4) not null,       --생년
    tel varchar2(15) not null,      --연락처
    address varchar2(300) null,     --주소
    money number not null           --예치금
);


-- 대여 테이블 > 고객 테이블, 비디오 테이블의 자식 테이블
create table tblRent (
    seq number primary key,                             --대여번호(PK)
    member number not null references tblMember(seq),   --대여한 회원번호(FK)
    video number not null references tblVideo(seq),     --대여한 비디오번호(FK)
    rentdate date default sysdate not null,             --대여날짜
    retdate date null,                                  --반납날짜
    remark varchar2(500) null                           --비고란
);

-- 고객 데이터
insert into tblcustomer (seq, name, tel, address)
      values (1, '홍길동', '010-1234-5678', '서울시');
insert into tblcustomer (seq, name, tel, address)
      values (2, '아무게', '010-3333-4444', '인천시');
insert into tblcustomer (seq, name, tel, address)
      values (3, '하하하', '010-5555-6666', '부산시');


-- 판매 데이터
insert into tblsales (seq, item, qty, cseq) values (1, '전화기', 1, 1);
insert into tblsales (seq, item, qty, cseq) values (2, '다이어리', 3, 2);
insert into tblsales (seq, item, qty, cseq) values (3, '노트', 10, 2);
insert into tblsales (seq, item, qty, cseq) values (4, '볼펜', 20, 3);
insert into tblsales (seq, item, qty, cseq) values (5, '지우개', 15, 3);
insert into tblsales (seq, item, qty, cseq) values (6, '마우스', 5, 1);
insert into tblsales (seq, item, qty, cseq) values (7, '키보드', 2, 3);
insert into tblsales (seq, item, qty, cseq) values (8, '모니터', 1, 2);
insert into tblsales (seq, item, qty, cseq) values (9, '선풍기', 2, 1);

commit;


-- 장르 데이터
INSERT INTO tblGenre VALUES (1, '액션',1500,2);
INSERT INTO tblGenre VALUES (2, '에로',1000,1);
INSERT INTO tblGenre VALUES (3, '어린이',1000,3);
INSERT INTO tblGenre VALUES (4, '코미디',2000,2);
INSERT INTO tblGenre VALUES (5, '멜로',2000,1);
INSERT INTO tblGenre VALUES (6, '기타',1800,2);




-- 비디오 데이터
INSERT INTO tblVideo (seq, Name, qty, Company, Director, Major, Genre) VALUES (1, '영구와 땡칠이',5,'영구필름','심영래','땡칠이',3);
INSERT INTO tblVideo (seq, Name, qty, Company, Director, Major, Genre) VALUES (2, '어쭈구리',5,'에로 프로덕션','김감독','박에로',2);
INSERT INTO tblVideo (seq, Name, qty, Company, Director, Major, Genre) VALUES (3, '털미네이터',3,'파라마운트','James','John',1);
INSERT INTO tblVideo (seq, Name, qty, Company, Director, Major, Genre) VALUES (4, '육복성',3,'대만영화사','홍군보','생룡',4);
INSERT INTO tblVideo (seq, Name, qty, Company, Director, Major, Genre) VALUES (5, '뽀뽀할까요',6,'뽀뽀사','박감독','최지후',5);
INSERT INTO tblVideo (seq, Name, qty, Company, Director, Major, Genre) VALUES (6, '우정과 영혼',2,'파라마운트','James','Mike',5);
INSERT INTO tblVideo (seq, Name, qty, Company, Director, Major, Genre) VALUES (7, '주라기 유원지',1,NULL,NULL,NULL,1);
INSERT INTO tblVideo (seq, Name, qty, Company, Director, Major, Genre) VALUES (8, '타이거 킹',4,'Walt','Kebin','Tiger',3);
INSERT INTO tblVideo (seq, Name, qty, Company, Director, Major, Genre) VALUES (9, '텔미 에브리 딩',10,'영구필름','강감독','심으나',5);
INSERT INTO tblVideo (seq, Name, qty, Company, Director, Major, Genre) VALUES (10, '동무',7,'부산필름','박감독','장동근',1);
INSERT INTO tblVideo (seq, Name, qty, Company, Director, Major, Genre) VALUES (11, '공동경쟁구역',2,'뽀뽀사','박감독','이병흔',1);




-- 회원 데이터
INSERT INTO tblMember (seq, Name,Grade,Byear,Tel,address,Money) VALUES (1, '김유신',1,1970,'123-4567','12-3번지 301호',10000);
INSERT INTO tblMember (seq, Name,Grade,Byear,Tel,address,Money) VALUES (2, '강감찬',1,1978,'111-1111','777-2번지 101호',0);
INSERT INTO tblMember (seq, Name,Grade,Byear,Tel,address,Money) VALUES (3, '유관순',1,1978,'222-2222','86-9번지',20000);
INSERT INTO tblMember (seq, Name,Grade,Byear,Tel,address,Money) VALUES (4, '이율곡',1,1982,'333-3333',NULL,15000);
INSERT INTO tblMember (seq, Name,Grade,Byear,Tel,address,Money) VALUES (5, '신숙주',1,1988,'444-4444','조선 APT 1012호',0);
INSERT INTO tblMember (seq, Name,Grade,Byear,Tel,address,Money) VALUES (6, '안중근',1,1981,'555-5555','대한빌라 102호',1000);
INSERT INTO tblMember (seq, Name,Grade,Byear,Tel,address,Money) VALUES (7, '윤봉길',1,1981,'666-6666','12-1번지',0);
INSERT INTO tblMember (seq, Name,Grade,Byear,Tel,address,Money) VALUES (8, '이순신',1,1981,'777-7777',NULL,1500);
INSERT INTO tblMember (seq, Name,Grade,Byear,Tel,address,Money) VALUES (9, '김부식',1,1981,'888-8888','73-6번지',-1000);
INSERT INTO tblMember (seq, Name,Grade,Byear,Tel,address,Money) VALUES (10, '박지원',1,1981,'999-9999','조선 APT 902호',1200);



-- 대여 데이터

INSERT INTO tblRent (seq, member, video, Rentdate, Retdate) VALUES (1, 1,1,'2022-01-01',NULL);
INSERT INTO tblRent (seq, member, video, Rentdate, Retdate) VALUES (2, 2,2,'2022-02-02','2022-02-03');
INSERT INTO tblRent (seq, member, video, Rentdate, Retdate) VALUES (3, 3,3,'2022-02-03',NULL);
INSERT INTO tblRent (seq, member, video, Rentdate, Retdate) VALUES (4, 4,3,'2022-02-04','2022-02-08');
INSERT INTO tblRent (seq, member, video, Rentdate, Retdate) VALUES (5, 5,5,'2022-02-05',NULL);
INSERT INTO tblRent (seq, member, video, Rentdate, Retdate) VALUES (6, 1,2,'2022-02-10',NULL);

commit;

select * from tblCustomer;
select * from tblSales;

select * from tblGenre;
select * from tblVideo;
select * from tblMember;
select * from tblRent;


/* join */

--1. 단순 조인, Cross Join

select * from tblCustomer;  --3명
select * from tblSales;     --9건

select * from tblCustomer cross join tblSales;
select * from tblCustomer, tblSales;

--2. 내부 조인, Inner Join

select 
    * 
from tblCustomer 
    inner join tblSales 
        on tblCustomer.seq = tblSales.cseq;


select 
    c.name, s.item, c.seq, s.seq
from tblCustomer c
    inner join tblSales s
        on c.seq = s.cseq;

select 
   *
from tblCustomer c
    inner join tblSales s
        on c.seq = s.cseq;
                      
select * from tblCustomer, tblSales where tblCustomer.seq = tblSales.cseq;

-- 원래 아래 2개의 테이블은 2개의 테이블이었다.
select * from tblStaff;
select * from tblProject;

-- 원래 1개의 테이블 정보를 2개로 나눴다 > 가끔은 다시 1개로 합쳐 봐야 할 업무가 생긴다.
select 
   *
from tblStaff s
    inner join tblProject p
        on s.seq = p.staff_seq;


--1. 직원 명단을 가져오시오.
select * from tblStaffl

--2. 진행중인 프로젝트 목록을 가져오시오.
select * fromt tblProject;

--3. 진행중인 프로젝트명과 해당 담당직원의 이름을 가져오시오.
select 
    p.project,
    s.name
from tblStaff s
    inner join tblProject p
        on s.seq = p.staff_seq;
        
--4.비디오 제목과 대여 가격을 가져오시오.
select 
    v.name,
    g.price
from tblGenre g
    inner join tblVideo v
        on g.seq = v.genre;
        
-- 조인 or 서브쿼리
-- tblCustomer + tblSales

-- 고객명 + 상품명

--1. join
select
    c.name as "고객명",
    s.item as "상품명"
from tblCustomer c
    inner join tblSales s
        on c.seq = s.cseq;

-- 2. subquery (메인 쿼리 : 자식 테이블)
select
    item as "상품명",
    (select name from tblCustomer where seq = tblSales.cseq) as "고객명"
from tblSales;


select 
    *
from tblGenre g
    inner join tblVideo v
        on g.seq = v.genre
            inner join tblRent r
                on v.seq = r.video;


select 
    v.name as "비디오",
    r.rentdate as "빌린 날짜",
    g.period as "대여기간",
    r.rentdate + g.period as "반납날짜"
from tblGenre g
    inner join tblVideo v
        on g.seq = v.genre
            inner join tblRent r
                on v.seq = r.video;

select * from tblGenre;
select * from tblVideo;
select * from tblRent;
select * from tblMember;

select 
    m. name as "회원",
    v.name as "비디오",
    r.rentdate as "대여날짜",
    g. price as "가격"
from tblGenre g
    inner join tblVideo v
        on g.seq = v.genre
            inner join tblRent r
                on v.seq = r.video
                    inner join tblMember m
                        on m.seq = r.member;


-- 관계 없는 테이블끼리 join

select * from tblStaff; --직원
select * from tblSales; --판매

select 
    *
from tblStaff s1
    inner join tblSales s2
        on s1.seq = s2.cseq;
        
-- hr >  7개
select * from employees;
select * from departments;
select * from locations;
select * from countries;
select * from regions;

select * from jobs;

select 
    e.first_name || ' ' || e.last_name as "이름",
    d.department_name as "부서",
    l.city as "도시",
    c.country_name as "국가",
    r.region_name as "대륙",
    j.job_title as "직업"
from employees e
    inner join departments d
        on d.department_id = e.department_id
            inner join locations l
                on l.location_id = d.location_id
                    inner join countries c
                        on c.country_id = l.country_id
                            inner join regions r
                                on r.region_id  = c.region_id
                                    inner join jobs j
                                        on j.job_id = e.job_id;
 
 -- 3. 외부 조인 , Outer Join                                   

select * from tblCustomer;
select * from tblSales;

insert into tblCustomer values(4, '호호호', '010-1234-4321', '서울시');

--한 번이라도 구매한 이력이 있는 고객들의 정보와 구매 이력을 가져오시오.
select
    * 
from tblCustomer c
    inner join tblSales s
        on c.seq = s. cseq;

-- 구매 이력과 상관 없이 모든 고객들의 정보를 가져오되, 구매 이력이 있으면 같이 가져오시오.
select
    * 
from tblCustomer c
    left outer join tblSales s
        on c.seq = s. cseq;
        

select * from tblStaff;
select * from tblProject;

--1. inner join
-- 아무개 제외 > 담당 프로젝트가 없어서,, > 부모 레코드가 자식 테이블에 참조되지 않았기 때문에
select
    *
from tblStaff s
    inner join tblProject p
        on s.seq = p.staff_seq;
        
--2. outer join
-- 담당 프로젝트가 없는 직원들까지 > 참조가 없는 부모 레코드까지 가져오시오.
select
    *
from tblStaff s
    left outer join tblProject p
        on s.seq = p.staff_seq;
        
        
-- tblVideo, tblRent
select * from tblVideo;
select * from tblRent;

-- 대여가 한 번이라도 된 비디오와 그 대여 내역 > inner join
select
    *
from tblVideo v
    inner join tblRent r
        on v.seq = r.video;
    
-- 대여와 상관없이 모든 비디오와 그 대여 내역을 가져오시오. > outer join
select 
    *
from tblVideo v
    left outer join tblRent r
        on v.seq = r.video;
        
        
-- 대여를 한 번도 안 한 비디오.. 악성 재고 > outer join
select 
    *
from tblVideo v
    left outer join tblRent r
        on v.seq = r.video
            where rentdate is null;

-- 대여 순위 > inner join
select
    name,
    count(name)
from tblVideo v
    inner join tblRent r
        on v.seq = r.video
            group by name
                order by count(name) desc;
                
-- 대여 순위 > outer join
select
    name,
    count(rentdate)
from tblVideo v
    left outer join tblRent r
        on v.seq = r.video
                group by name                
                    order by count(rentdate) desc;
                
-- tblMember, tblRent
select * from tblMember;
select * from tblRent;

--대여를 1회 이상 > 고객 정보 + 대여 정보
select 
    *
from tblMember m
    inner join tblRent r
        on m.seq = r.member;
        
-- 대여를 한 번도 안 한 사람도 포함..
select
    *
from tblMember m
    left outer join tblRent r
        on m.seq = r.member;

-- 대여를 한 번도 안 한 사람
select
    *
from tblMember m
    left outer join tblRent r
        on m.seq = r.member
            where rentdate is null;
            
            
 --========================================Q==========================================           
-- tblStaff, tblProject. 현재 재직중인 모든 직원의 이름, 주소, 월급, 담당프로젝트명을 가져오시오.
select * from tblStaff; --이름, 월급, 주소
select * from tblProject; -- 이름, 담당프로젝트명

select
    s.name, 
    s.address,
    s.salary, 
    p.project
from tblStaff s
    left outer join tblProject p
        on s.seq = p.staff_seq
            order by s.name asc;       
       
       
-- tblVideo, tblRent, tblMember. '뽀뽀할까요' 라는 비디오를 빌려간 회원의 이름은?
select * from tblVideo;
select * from tblMember;
select * from tblRent;

select
    m.name
from tblMember m
    inner join tblRent r
        on m.seq = r.member
            where r.video = (select seq from tblVideo where name = '뽀뽀할까요') ;
    
    
-- tblStaff, tblProject. 'TV 광고'을 담당한 직원의 월급은 얼마인가?
select * from tblStaff; -- 월급, 직원 번호
select * from tblProject; -- 프로젝트명, staff_seq

select 
    s.salary
from tblStaff s
    inner join tblProject p
        on s.seq = p.staff_seq
            where p.project = 'TV 광고';
    
    
-- tblVideo, tblRent, tblMember. '털미네이터' 비디오를 한번이라도 빌려갔던 회원들의 이름은?
select * from tblVideo; -- v.name(털미네이터)의 비디오 번호(v.seq)
select * from tblMember; -- r.member에 해당하는 회원의 이름 (m.name)
select * from tblRent; -- v. seq를 한 번이라도 빌려간 적 있는(r.video) 회원 번호(r.member)

select 
    m.name
from tblMember m
    inner join tblRent r
        on m.seq = r.member
            where r.video = (select v.seq from tblVideo v
                                where v.name = '털미네이터');

                
-- tblStaff, tblProject. 서울시에 사는 직원을 제외한 나머지 직원들의 이름, 월급, 담당프로젝트명을 가져오시오.
select * from tblStaff; -- name, salary (address <> '서울시') , seq
select * from tblProject; -- 프로젝트명, staff_seq

select
    s.name,
    s.salary,
    p.project
from tblStaff s
    left outer join tblProject p
        on s.seq = p.staff_seq
            where s.address <> '서울시';

        
-- tblCustomer, tblSales. 상품을 2개(단일상품) 이상 구매한 회원의 연락처, 이름, 구매상품명, 수량을 가져오시오.
select * from tblCustomer; -- seq /tel, name
select * from tblSales; -- cseq / item, qty

select
    c.tel,
    c.name,
    s.item,
    s.qty
from tblCustomer c
    inner join tblSales s
        on c.seq = s.cseq
            where qty >= 2
                order by name asc, qty desc;

                                
-- tblVideo, tblGenre. 모든 비디오 제목, 보유수량, 대여가격을 가져오시오.
select * from tblGenre; -- seq / price
select * from tblVideo; -- genre / name / qty

--TODO 시간 되면 tblRent에서 빌려간 수량 빼서 계산해보기..
select 
    v.name,
    v.qty,
    g.price
from tblGenre g
    inner join tblVideo v
        on g.seq = v.genre
          
                
-- tblVideo, tblRent, tblMember, tblGenre. 2022년 2월에 대여된 구매내역을 가져오시오. 회원명, 비디오명, 언제, 대여가격
select * from tblGenre; -- seq/price
select * from tblVideo; -- genre/seq/ name
select * from tblMember; --seq / name
select * from tblRent;  --member/video / rentdate

select
    (select name from tblMember m where m.seq = r.member) as member,
    v.name,
    r.rentdate,
    g.price
from tblGenre g
    inner join tblVideo v
        on g.seq = v.genre
            inner join tblRent r
                on v.seq = r.video
                    where substr(r.rentdate, 4,2) = '02';
        
        
-- tblVideo, tblRent, tblMember. 현재 반납을 안한 회원명과 비디오명, 대여날짜를 가져오시오.
select * from tblVideo; -- seq/ name
select * from tblMember; --seq / name
select * from tblRent;  --member/video / rentdate, retdate

select 
    m.name,
    v.name,
    r.rentdate
from tblMember m
    inner join tblRent r
        on m.seq = r.member
            inner join tblVideo v
                on v.seq = r.video
where r.retdate is null;
    
    
-- employees, departments. 사원들의 이름, 부서번호, 부서명을 가져오시오.
select * from employees; -- department_id / first_name || ' ' || last_name, department_id
select * from departments; -- department_id/department_name

select
    (e.first_name || ' ' || e.last_name) as name,
    e.department_id,
    d.department_name
from departments d
    inner join employees e
        on d.department_id = e.department_id;    
        
        
-- employees, jobs. 사원들의 정보와 직업명을 가져오시오.
select * from employees; --job_id
select * from jobs; --job_id / job_title

select 
    e.*,
    j.job_title
from jobs j
    inner join employees e
        on j.job_id = e.job_id;
        
        
-- employees, jobs. 직무(job_id)별 최고급여(max_salary) 받는 사원 정보를 가져오시오.
select * from employees; --job_id
select * from jobs; --job_id / max_salary

--TODO????????????????????????
select 
    *
from jobs j
    inner join employees e
        on j.job_id = e.job_id

    
-- departments, locations. 모든 부서와 각 부서가 위치하고 있는 도시의 이름을 가져오시오.
select * from departments; -- location_id/department_name
select * from locations; --location_id / city

select
    d.department_name,
    l.city
from locations l
    inner join departments d
        on l.location_id = d.location_id;
        
        
-- locations, countries. location_id 가 2900인 도시가 속한 국가 이름을 가져오시오.
select * from locations;
select * from countries;

select
    c.country_name
from countries c
    inner join locations l
        on l.country_id = c.country_id
            where l.location_id = 2900;
            
            
-- employees. 급여를 12000 이상 받는 사원과 같은 부서에서 근무하는 사원들의 이름, 급여, 부서번호를 가져오시오.
select * from employees;

-- TODO 본인 제외?
select
    (first_name || ' ' || last_name) as name,
    salary,
    department_id
from employees
    where department_id in (select department_id from employees where salary >= 12000)
        order by department_id asc;
            
        
-- employees, departments. locations.  'Seattle'에서(LOC) 근무하는 사원의 이름, job_id, 부서번호, 부서이름을 가져오시오.
select * from employees; -- (first_name || ' ' || last_name) as name, department_id
select * from departments; -- department_id, department_name, location_id
select * from locations; --city, location_id

select 
    (e.first_name || ' ' || e.last_name) as name, 
    e.job_id,
    d.department_id,
    d.department_name
from employees e
    inner join departments d
        on d.department_id = e.department_id
            where d.location_id = (select location_id from locations 
                                    where city = 'Seattle');    

    
-- employees, departments. first_name이 'Jonathon'인 직원과 같은 부서에 근무하는 직원들 정보를 가져오시오.
select * from employees; -- first name, department_id
select * from departments; --사용xx

select
    *
from employees
    where department_id = (select department_id from employees 
                            where first_name = 'Jonathon')
    and first_name <> 'Jonathon';
    
    
-- employees, departments. 사원이름과 그 사원이 속한 부서의 부서명, 그리고 월급을 출력하는데 월급이 3000이상인 사원을 가져오시오.
select * from employees; -- (first_name || ' ' || last_name) as name, department_id, salary
select * from departments; --department_id, department_name

select 
    (e.first_name || ' ' || e.last_name) as name,
    d.department_name
from departments d
    inner join employees e
        on d.department_id = e.department_id
where e.salary >= 3000
    order by e.salary desc;
    
            
-- employees, departments. 부서번호가 10번인 사원들?의 부서번호, 부서이름, 사원이름, 월급을 가져오시오.
select * from employees; -- department_id, (first_name || ' ' || last_name) as name, salary
select * from departments; --department_id, department_name

select 
    d.department_id,
    d.department_name,    
    (e.first_name || ' ' || e.last_name) as name,
    e.salary
from departments d
    inner join employees e
        on d.department_id = e.department_id
where e.department_id = 10;
            
            
-- departments, job_history. 퇴사한 사원의 입사일, 퇴사일, 근무했던 부서 이름을 가져오시오.
select * from departments; -- department_id/ department_name
select * from job_history; -- department_id/start_date,end_date

select 
    h.start_date,
    h.end_date,
    d.department_name
from departments d
    inner join job_history h
        on d.department_id = h.department_id;
        
        
-- employees. 사원번호와 사원이름, 그리고 그 사원을 관리하는 관리자의 사원번호와 사원이름을 출력하되 각각의 컬럼명을 '사원번호', '사원이름', '관리자번호', '관리자이름'으로 하여 가져오시오.
select * from employees;    --   employee_id, (first_name || ' ' || last_name), manager_id, employee_id
     
select
    e1.employee_id as "사원번호",
    (e1.first_name || ' ' || e1.last_name) as "사원이름",
    e1.manager_id as "관리자번호",
    (e2.first_name || ' ' || e2.last_name) as "관리자이름"
from employees e1
    left outer join employees e2
        on e1.manager_id = e2.employee_id
order by e1.employee_id;


-- employees, jobs. 직책(Job Title)이 Sales Manager인 사원들의 입사년도와 입사년도(hire_date)별 평균 급여를 가져오시오. 년도를 기준으로 오름차순 정렬.
select * from employees; -- job_id/ hire_date, salary, 
select * from jobs; --job_id / job_title='Sales Manager' / 

select 
    substr(e.hire_date,1,2) as hire_year,
    avg(e.salary)
from employees e
    where job_id = (select job_id from jobs where job_title = 'Sales Manager')
        group by substr(e.hire_date,1,2)
            order by substr(e.hire_date,1,2) asc;


-- employees, departments. locations. 각 도시(city)에 있는 모든 부서 사원들의 평균급여가 가장 낮은 도시부터 도시명(city)과 평균연봉, 해당 도시의 사원수를 가져오시오.
-- 단, 도시에 근 무하는 사원이 10명 이상인 곳은 제외하고 가져오시오.
select * from employees; --department_id/avg(salary), count(*)
select * from departments; --department_id/location id/
select * from locations; -- location_id/city

select
    l.city,
    round(avg(e.salary),2) as avg_salary,
    count(*) as count_employees
from employees e
    inner join departments d
        on d.department_id = e.department_id
            inner join locations l
                on d.location_id = l.location_id
group by l.city
    order by avg(e.salary) asc;
            
            
-- employees, jobs, job_history. ‘Public Accountant’의 직책(job_title)으로 과거에 근무한 적이 있는 모든 사원의 사번과 이름을 가져오시오. 
-- 현재 ‘Public Accountant’의 직책(job_title)으로 근무하는 사원은 고려 하지 말것.
select * from employees; -- job_id/employee_id, (e.first_name || ' ' || e.last_name)
select * from jobs; --job_id
select * from job_history; -- employee_id, job_id

select
    h.employee_id,
    (e.first_name || ' ' || e.last_name) as name
from employees e
    inner join job_history h
        on e.employee_id = h.employee_id
where h.job_id = (select job_id from jobs where job_title = 'Public Accountant');
    
    
-- employees, departments, locations. 커미션을 받는 모든 사람들의 first_name, last_name, 부서명, 지역 id, 도시명을 가져오시오.
select * from employees; -- department_id/first_name, last_name + where commission_pct is not null
select * from departments; -- department_id / location_id/ department_name
select * from locations;  --location_id / city

select
    e.first_name,
    e.last_name,
    d.department_name,
    l.city
from employees e
    left outer join departments d
        on d.department_id = e.department_id
            left outer join locations l
                on l.location_id = d.location_id
where e.commission_pct is not null;
        
-- employees. 자신의 매니저보다 먼저 고용된 사원들의 first_name, last_name, 고용일을 가져오시오.
select * from employees; 

select
    e1.first_name,
    e1.last_name,
    e1.hire_date
from employees e1
    inner join employees e2
        on e1.manager_id = e2.employee_id
where e1.hire_date < e2.hire_date;
            
            