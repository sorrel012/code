/*
    
A.04 개설 과목 관리
	- 특정 개설 과정 선택 시 개설 과목 정보 출력 및 개설 과목 신규 등록
	- 개설 과목 정보 입력시 과목명, 과목기간(시작 년월일, 끝 년월일), 교재명, 교사명을 입력
	- 개설 과목 출력 시 개설 과정 정보(과정명, 과정기간(시작 년월일, 끝 년월일), 강의실)와 과목명, 과목기간(시작 년월일, 끝 년월일), 교재명, 교사명을 출력
	- 개설 과목 정보에 대한 입력, 출력, 수정, 삭제

*/


/*개설 과목 정보*/

-- 1. 입력(과목 시작일, 과목 종료일, 과정번호, 과목번호, 교사번호 / 과목 번호, 교재번호)
insert all
    into tblCurSub(cursubStart, cursubEnd, curriculum_seq, subject_seq, teacher_seq)
        values('2023-12-04', '2024-02-02', 37, 13, 11)
    into tblSubBook(subject_seq, book_seq) 
        values(13, 24)
select * from dual;


-- 2. 출력
select distinct
    c.curriculumName as "과정명",
    c.curriculumStart as "과정 시작일",
    c.curriculumEnd as "과정 종료일",
    l.lectureRoomnum||'호' as "강의실",
    s.subjectName as "과목명",
    cs.cursubStart as "과목 시작일",
    cs.cursubEnd as "과목 종료일",
    b.bookName as "교재명",
    t.teacherName as "교사명"
from tblCurriculum c
    inner join tblLecture l
        on c.curriculum_seq = l.curriculum_seq
            inner join tblCurSub cs
                on c.curriculum_seq = cs.curriculum_seq
                    inner join tblSubject s
                        on s.subject_seq = cs.subject_seq
                            inner join tblSubBook sb
                                on s.subject_seq = sb.subject_seq
                                    inner join tblBook b
                                        on b.book_seq = sb.book_seq
                                            inner join tblTeacher t
                                                on t.teacher_seq = cs.teacher_seq
where s.subject_seq = 1
    order by c.curriculumStart, cs.cursubStart;


-- 3-1. 과목 기간 수정
update tblCurSub set cursubStart = '2023-12-04', cursubEnd = '2024-02-01'
    where curriculum_seq = 37 and subject_seq = 13;
    
-- 3-2. 담당 교사 수정
update tblCurSub set teacher_seq = 1
    where curriculum_seq = 37 and subject_seq = 13;
    
-- 3-3. 교재 번호 수정
update tblSubBook set book_seq = 25
    where subject_seq = 13 and book_seq = 24;


-- 4-1. 과목 정보 삭제
delete tblCurSub 
    where curriculum_seq = 37 and subject_seq = 13;

-- 4-2. 과목별 교재 정보 삭제
delete tblSubBook
    where subject_seq = 13;
    


/* 특정 개설 과정 선택 시 개설 과목 정보 출력*/
select distinct
    c.curriculumName as "과정명",
    s.subjectName as "과목명",
    cs.cursubStart as "과목 시작일",
    cs.cursubEnd as "과목 종료일",
    b.bookName as "교재명",
    t.teacherName as "교사명"
from tblCurriculum c
    inner join tblCursub cs
        on c.curriculum_seq = cs.curriculum_seq 
            inner join tblSubject s
                on s.subject_seq = cs.subject_seq
                    inner join tblSubBook sb
                        on sb.subject_seq = s.subject_seq
                            inner join tblTeacher t
                                on t.teacher_seq = cs.teacher_seq
                                    inner join tblBook b
                                        on b.book_seq = sb.book_seq
where c.curriculum_seq = 1
    order by c.curriculumName, cs.cursubStart
    