-- 23년6월7일 ~ 23년 11월 29일

create table tblDateTest (
    dat DATE primary key
);

-- 날짜 추출
select 
    to_date('2023-06-07', 'yyyy-mm-dd') + level - 1
from dual
    connect by level <= 176;
    


delete from tblDateTest;

insert into tblDateTest values(to_date('23/11/02'));

select * from tblDateTest;

select to_char(dat, 'yyyy-mm-dd') from tblDateTest;

insert into tblDateTest values(to_date('23/11/02'));


create sequence seqAttendance start with 1;

create table  tblSeq(
    seq number primary key
);

begin
    for i in 1..31680 loop
        insert into tblSeq values (seqAttendance.nextVal);
    end loop;
end;



select 
    to_date('08:00', 'yyyy-mm-dd') + level - 1
from dual
    connect by level <= 31;
    
drop table tblAttendanceTest;
create table tblAttendanceTest(
    checkin varchar2(30)
);


select
    level
from dual
    connect by level <= 176;

update tblAttendanceTest set checkin = 'null' where seq in(4, 5, 11, 12, 18, 19, 25, 26, 32, 33, 39, 40, 46, 47, 53, 54, 60, 61, 67, 68, 70, 74, 
75, 81, 82, 88, 89, 95, 96, 102, 103, 109, 110, 114, 115, 116, 117, 119, 123, 124, 125, 130, 131, 137, 138, 144, 145, 151, 152, 158, 159, 165, 166, 172, 173);



/* 교육생 테이블  */

create table tblStudentTest(
    student_seq number primary key
);

create sequence seqStudentTest start with 901;

begin
    for i in 1..180 loop
        insert into tblStudentTest values(seqStudentTest.nextVal);
    end loop;    
end;



/* 출결 테이블 */
create table tblAttendanceTest (    
    attendance_seq number primary key,
    attendanceDate date  null, 
    attendanceCheckTime varchar2(20) null, 
    attendanceOutTime varchar2(20) null, 
    attendanceDetail varchar2(10) null,
    student_seq not null,  

    constraint ad_student_seq_fk foreign key(student_seq) references tblStudentTest(student_seq)
);

delete from tblAttendanceTest;


-- 무단결석
select * from tblAttendanceTest where attendanceCheckTime is null and attendanceOutTime is null and attendanceDetail is null and attendanceDate not in 
((to_date('23/06/10')), (to_date('23/06/11')), (to_date('23/06/17')), (to_date('23/06/18')), (to_date('23/06/24')), (to_date('23/06/25')), (to_date('23/07/01')), (to_date('23/07/02'))
, (to_date('23/07/08')), (to_date('23/07/09')), (to_date('23/07/15')), (to_date('23/07/16')), (to_date('23/07/22')), (to_date('23/07/23')), (to_date('23/07/29')), (to_date('23/07/30'))
, (to_date('23/08/05')), (to_date('23/08/06')), (to_date('23/08/12')), (to_date('23/08/13')), (to_date('23/08/15')), (to_date('23/08/19')), (to_date('23/08/20')), (to_date('23/08/26')), (to_date('23/08/27'))
, (to_date('23/09/02')), (to_date('23/09/03')), (to_date('23/09/09')), (to_date('23/09/10')), (to_date('23/09/16')), (to_date('23/09/17')), (to_date('23/09/23')), (to_date('23/09/24'))
, (to_date('23/09/28')), (to_date('23/09/29')), (to_date('23/09/30')), (to_date('23/10/01')), (to_date('23/10/03')), (to_date('23/10/07')), (to_date('23/10/08')), (to_date('23/10/09'))
, (to_date('23/10/14')), (to_date('23/10/15')), (to_date('23/10/21')), (to_date('23/10/22')), (to_date('23/10/28')), (to_date('23/10/29'))
, (to_date('23/11/04')), (to_date('23/11/05')), (to_date('23/11/11')), (to_date('23/11/12')), (to_date('23/11/18')), (to_date('23/11/19')), (to_date('23/11/25')), (to_date('23/11/26')))
and student_seq not in (911,921,931,941,951,961,971,981,991,1001,1011,1021,1031,1041,1051,1061,1071,1080) order by student_seq;


/*결석 처리 테이블*/
create table tblAbsentTest (
    absent_seq number primary key,
    late number default 0,
    leaveEarly number default 0,
    outing number default 0,
    absent number default 0,
    student_seq not null,  

    constraint as_student_seq_fk foreign key(student_seq) references tblStudentTest(student_seq)
);    


-- 결석에 누적하기

declare
    vlate number;
    vearly number;
    vouting number;
    vabsent number;
    vsum number;
    vfloor number;
begin
    
    for i in 901..1080 loop
        select late into vlate from tblAbsentTest where student_seq = i;
        select leaveEarly into vearly from tblAbsentTest where student_seq = i;
        select outing into vouting from tblAbsentTest where student_seq = i;
        select absent into vabsent from tblAbsentTest where student_seq = i;
        
        vsum := vlate + vearly + vouting;        
        vfloor := floor(vsum / 3);
        
        update tblAbsentTest set absent = vabsent + vfloor where student_seq = i ;
    end loop;
    
end;

select * from tblAbsentTest;

/* 교사 테이블 */
create table tblTeacherTest (
    teacher_seq number primary key
)
insert into tblTeacherTest values(1);
insert into tblTeacherTest values(2);
insert into tblTeacherTest values(3);
insert into tblTeacherTest values(4);
insert into tblTeacherTest values(5);
insert into tblTeacherTest values(6);
insert into tblTeacherTest values(7);
insert into tblTeacherTest values(8);
insert into tblTeacherTest values(9);
insert into tblTeacherTest values(10);


/* 과목 테이블 */
create table tblSubTest (
    subject_seq number primary key,
    subjectName varchar2(30) 
)

insert into tblSubTest values(1, 'Java');
insert into tblSubTest values(2, 'Oracle');
insert into tblSubTest values(3, 'Spring');
insert into tblSubTest values(4, 'React');
insert into tblSubTest values(5, 'CSS');
insert into tblSubTest values(6, 'JavaScript');
insert into tblSubTest values(7, 'HTML');
insert into tblSubTest values(8, 'JSP');
insert into tblSubTest values(9, 'Aws');
insert into tblSubTest values(10, 'Jquery');
insert into tblSubTest values(11, 'Node.js');
insert into tblSubTest values(12, 'Kotlin');


/* 강의 가능 과목 테이블*/
create table tblAvailSubTest(
    teacher_seq number not null,
    subject_seq number not null,
    
    constraint ast_teacher_seq_fk foreign key(teacher_seq) references tblTeacherTest(teacher_seq),
    constraint ast_subject_seq_fk foreign key(subject_seq) references tblSubTest(subject_seq)
);
    
    