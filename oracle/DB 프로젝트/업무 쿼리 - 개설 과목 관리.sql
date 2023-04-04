/*
    
A.04 개설 과목 관리
	- 특정 개설 과정 선택 시 개설 과목 정보 출력 및 개설 과목 신규 등록
	- 개설 과목 정보 입력시 과목명, 과목기간(시작 년월일, 끝 년월일), 교재명, 교사명을 입력
	- 개설 과목 출력 시 개설 과정 정보(과정명, 과정기간(시작 년월일, 끝 년월일), 강의실)와 과목명, 과목기간(시작 년월일, 끝 년월일), 교재명, 교사명을 출력
	- 개설 과목 정보에 대한 입력, 출력, 수정, 삭제

*/


/*개설 과목 정보*/


-- 1. 입력(과목명 / 과목 시작일, 과목 종료일, 과정번호, 과목번호, 교사번호 / 과목 번호, 교재번호)



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


-- 3-1. 수정
create table tblBookSign(    
    signature varchar2(20) null,
    book_seq number not null,
    student_seq number not null,

    constraint bs_book_seq_fk foreign key(book_seq) references tblBook(book_seq),
    constraint bs_student_seq_fk foreign key(student_seq) references tblStudent(student_seq)
);

select * from tblSubBook;


-- 4. 삭제


/* 특정 개설 과정 선택 시 개설 과목 정보 출력 및 개설 과목 신규 등록 */