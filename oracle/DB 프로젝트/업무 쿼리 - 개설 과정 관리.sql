/*
    
A.03 개설 과정 관리
	- 과정명, 과정 기간(시작 년월일, 끝 년월일), 강의실 정보를 입력
	- 개설 과정 정보 입력, 출력, 수정, 삭제
	- 개설 과정 정보 출력 시 개설 과정명, 개설 과정기간(시작 년월일, 끝 년월일), 강의실명, 개설 과목 등록 여부, 교육생 등록인원을 출력
	- 특정 개설 과정 선택 시 개설 과정에는 등록된 개설 과목 정보(과목명, 과목기간(시작 년월일, 끝년월일), 교재명, 교사명) 및 등록된 교육생 정보(교육생 이름, 주민번호 뒷자리, 등록일, 수료 및 중도 탈락) 조회
	- 특정 개설 과정이 수료한 경우 등록된 교육생 전체에 대해서 수료날짜를 지정(중도탈락자 제외)
	- 강의실 정보 추가(강의실명으로 입력)
    
*/


/*개설 과정 정보 > 과정명, 과정 기간(시작 년월일, 끝 년월일), 강의실 정보, 개설 과목 등록 여부, 교육생 등록인원  */

-- 1. 입력
insert all
    into tblCurriculum(curriculum_seq, curriculumName, curriculumStart, curriculumEnd)
        values((select max(curriculum_seq) from tblCurriculum) + 1, '빅데이터기반 AI알고리즘 서비스(추천,트레이딩)개발자 양성과정', '2023-12-04', '2024-4-19')
    into tblLecture(lecture_seq, lectureMaxStudent, curriculum_seq, lectureRoomnum)
        values((select max(lecture_seq) from tblLecture) + 1, 30, (select max(curriculum_seq) from tblCurriculum)+1, 1)
select * from dual;



-- 2. 출력
select distinct
    c.curriculumName as "과정명",
    c.curriculumStart as "과정 시작일",
    c.curriculumEnd as "과정 종료일",
    l.lectureRoomnum || '호' as "강의실",
    case
        when cs.subject_seq is null then 'N'
        else 'Y'        
    end as "과목 등록 여부",   
    nvl(count(st.student_seq),0 )as "교육생 등록 인원"    
from tblCurriculum c
    inner inner join tblLecture l
        on c.curriculum_seq = l.curriculum_seq
            left outer inner join tblCurSub cs
                on c.curriculum_seq = cs.curriculum_seq
                    left outer inner join tblSelect s
                        on c.curriculum_seq = s.curriculum_seq
                            left outer inner join tblStudent st
                                on s.select_seq = st.select_seq
    group by c.curriculumName, c.curriculumStart, c.curriculumEnd, l.lectureRoomnum, cs.cursubStart, cs.subject_seq
        order by c.curriculumStart;



-- 3-1. 과정 기간 수정
update tblCurriculum set curriculumStart = '2023-12-04', curriculumEnd = '2024-04-19'
    where curriculum_seq = 37;


-- 3-2. 강의실 정보 수정
update tblLecture set lectureRoomnum = 3
    where curriculum_seq = 37;



-- 4. 강의실, 과정 삭제
delete tblLecture
    where curriculum_seq = 37;
    
delete tblCurriculum
    where curriculum_seq = 37;



/* 특정 개설 과정이 수료한 경우 등록된 교육생 전체에 대해서 수료날짜를 지정(중도탈락자 제외) */

-- 31 > 과정 번호
update tblCertificate set certificateDate = (select curriculumEnd from tblCurriculum where curriculum_seq = 31) 
    where certificateDetail = '졸업' and student_seq between ((31 - 1) * 30 + 1) and (31 * 30);



/* 특정 개설 과정 정보 과목명, 과목기간(시작 년월일, 끝년월일), 교재명, 교사명) 및 등록된 교육생 정보(교육생 이름, 주민번호 뒷자리, 등록일, 수료 및 중도 탈락) 조회 */

select distinct
  s.subjectName as "과목명",
  cs.cursubStart as "과목 시작일", 
  cs.cursubEnd as "과목 종료일",
  b.bookName as "교재명", 
  t.teacherName as "교사명",
  ap.applicantName as "교육생 이름",
  substr(ap.applicantSsn, 8, 7) as "주민번호 뒷자리",
  c.curriculumStart as "등록일"
from tblCurSub cs
    inner join tblSubject s on s.subject_seq = cs.subject_seq
    inner join tblSubBook sb on sb.subject_seq = s.subject_seq
    inner join tblBook b on b.book_seq = sb.book_seq
    inner join tblAvailSubject avs on avs.subject_seq = s.subject_seq
    inner join tblTeacher t on t.teacher_seq = avs.teacher_seq
    inner join tblStudent st on st.student_seq = sb.student_seq
    inner join tblApplicant ap on ap.curriculum_seq = cs.curriculum_seq
    inner join tblCurriculum c on c.curriculum_seq = cs.curriculum_seq
where c.curriculum_seq = 1
    order by s.subjectName, t.teacherName, ap.applicantName;


/* 강의실 정보 추가 */

insert into tblLecture(lecture_seq, lectureRoomnum, lectureMaxstudent)
    values((select max(lecture_seq) from tblLecture) + 1, (select max(lectureRoomnum) from tblLecture) + 1, 30);

