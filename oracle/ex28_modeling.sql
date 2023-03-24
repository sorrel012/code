
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

