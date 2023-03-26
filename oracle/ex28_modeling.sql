
/* 

    modeling 
    
    모델링 작업 > ERD(논리,물리) > [정규화] > 안정성 높고, 효율적 구조로 변경 > ERD 
    
    데이터베이스 설계
    
    정규화
    
    역정규화 
    
*/


--복합키 생성하기 + 사용하기

--학생
create table tblStudent (
    seq number primary key,     --번호(PK)
    name varchar2(30) not null  --학생명
);


--과목
create table tblSubject (
    seq number primary key,     --번호(PK)
    name varchar2(30) not null  --과목명
);


--수강신청
--create table tblRegister (
--    
--    -- 컬럼수준에서는 복합키를 지정할 수 없다.
--    student_seq number primary key,
--    subject_seq number primary key,
--    regdate date default sysdate
--    
--);


create table tblRegister (
    
    student_seq number references tblStudent(seq),
    subject_seq number references tblSubject(seq),
    regdate date default sysdate,
    
    constraint register_pk primary key(student_seq, subject_seq) --복합키 선언
    
);

--성적
create table tblScore (
    seq number primary key,
    score number not null,
    student_seq number,
    subject_seq number,
    
    constraint score_fk foreign key(student_seq, subject_seq) 
        references tblRegister(student_seq, subject_seq)    
);


insert into tblStudent values (1, '홍길동');
insert into tblStudent values (2, '아무개');
insert into tblStudent values (3, '하하하');

insert into tblSubject values (1, '자바');
insert into tblSubject values (2, '오라클');
insert into tblSubject values (3, 'JDBC');
insert into tblSubject values (4, 'JSP');
insert into tblSubject values (5, 'Spring');

insert into tblRegister values (1, 1, sysdate);
insert into tblRegister values (1, 2, sysdate);
insert into tblRegister values (1, 3, sysdate);
insert into tblRegister values (2, 2, sysdate);
insert into tblRegister values (2, 4, sysdate);
insert into tblRegister values (2, 5, sysdate);
insert into tblRegister values (2, 1, sysdate);
insert into tblRegister values (3, 2, sysdate);
insert into tblRegister values (3, 5, sysdate);

insert into tblScore values (1, 100, 1, 1);
insert into tblScore values (2, 90,  1, 2);
insert into tblScore values (3, 80,  1, 3);
insert into tblScore values (4, 70,  2, 2);
insert into tblScore values (5, 60,  3, 2);


select * from tblStudent;
select * from tblSubject;
select * from tblRegister;
select * from tblScore;

--어떤 학생이 어떤 과목을 수강 신청 했는지?

select 
    st.name as "학생명",
    sj.name as "과목명"
from tblStudent st
    inner join tblRegister r
        on st.seq = r.student_seq
            inner join tblSubject sj
                on sj.seq = r.subject_seq;

--어떤 학생이 어떤 과목을 수강 신청 했는지 + 성적까지
select 
    st.name as "학생명",
    sj.name as "과목명",
    sc.score as "성적"
from tblStudent st
    inner join tblRegister r
        on st.seq = r.student_seq
            inner join tblSubject sj
                on sj.seq = r.subject_seq
                    left outer join tblScore sc
                        on r.student_seq = sc.student_seq and r.subject_Seq = sc. subject_Seq;


--========================================데이터 설계해보기===========================================

/*

    네이버 영화 > 영화 랭크
    
    - 모든 영화에 대한 정보(데이터) 
    
    1. 데이터 수집 + 분석
        - 데이터 인식
        - 데이터베이스에 저장할 데이터 선별
        
    2. ERD 작성(*****)
        a. 개념적 모델링 > 산출물
        b. 논리 모델링   > 산출물
        c. 물리 모델링   > 산출물
    
    3. DDL 작성
        - create문 작성
        a. 테이블
        b. 시퀀스
        c. 뷰
        
        > 산출물
        
    4. DML 작성
        - 데이터 추가
        - insert문
        - 50편 영화
        
        > 산출물
        
    4. select 문
        - 검증용
        
          a. 조회수 순서대로 가져오시오.(순위, 영화명, 변동폭)
          b. '박성웅' 배우가 출연한 영화를 가져오시오.
          c. '김주환' 감독이 제작한 영화를 가져오시오.
          d. 남자들이 선호하는 영화를 가져오시오.
          e. 20대가 선호하는 영화를 가져오시오.
          f. '좋아요'를 20,000개 이상 받은 영화를 가져오시오.          
          g. 한줄평 개수가 40,000개 이상 달린 영화를 가져오시오.           
          h. 네티즌 관람객 평점이 4.5이상인 영화를 가져오시오.
          i. 영화의 명대사를 영화 제목과 함께 가져오시오.(명대사 배우명도 같이)          
          j. 등록된 50개의 영화중 가장 많은 영화에 참여한 배우를 가져오시오.          
          k. '드라마'와 '코미디' 2개 장르에 속한 영화를 가져오시오.
          l. 런타임이 120분 미만인 영화를 가져오시오.
          m. 성인 관람가 영화를 가져오시오.
          n. 누적 관객 100,000명이 넘는 영화를 가져오시오.
        
*/



