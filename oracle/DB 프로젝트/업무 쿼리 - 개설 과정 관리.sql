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


/*view*/
create or replace view vwCurrInfo
as
select distinct
    c.curriculumName,
    c.curriculumStart,
    c.curriculumEnd,
    l.lectureRoomnum,
    c.curriculum_seq
from tblCurriculum c
    inner join tblLecture l
        on c.curriculum_seq = l.curriculum_seq
            left outer join tblCurSub cs
                on c.curriculum_seq = cs.curriculum_seq
                    left outer join tblSelect s
                        on c.curriculum_seq = s.curriculum_seq
    group by c.curriculumName, c.curriculumStart, c.curriculumEnd, l.lectureRoomnum, c.curriculum_seq
        order by c.curriculumStart;      
        

-- 2. 출력
select distinct
    v.curriculumName as "과정명",
    v.curriculumStart as "과정시작일",
    v.curriculumEnd as "과정종료일",
    v.lectureRoomnum || '호' as "강의실",
    case
        when cs.subject_seq is null then 'N'
        else 'Y'        
    end as "과목 등록 여부",   
    nvl(count(st.student_seq), 0) as "교육생 등록 인원"    
from vwCurrInfo v
    left outer join tblCurSub cs
        on v.curriculum_seq = cs.curriculum_seq
            left outer join tblSelect s
                on v.curriculum_seq = s.curriculum_seq
                    left outer join tblStudent st
                        on s.select_seq = st.select_seq
group by v.curriculumName, v.curriculumStart, v.curriculumEnd, v.lectureRoomnum, cs.cursubStart, cs.subject_seq
    order by v.curriculumStart;



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


/* view */
create or replace view vwSubInfo
as
select distinct
  s.subjectName, 
  cs.cursubStart, 
  cs.cursubEnd,
  b.bookName, 
  t.teacherName,
  cs.curriculum_seq,
  cs.subject_seq
from tblCurSub cs
    inner join tblSubject s on s.subject_seq = cs.subject_seq
    inner join tblSubBook sb on sb.subject_seq = s.subject_seq
    inner join tblBook b on b.book_seq = sb.book_seq
    inner join tblTeacher t on t.teacher_seq = cs.teacher_seq
order by s.subjectName, cs.cursubStart;


/* 특정 개설 과정 정보 과목명, 과목기간(시작 년월일, 끝년월일), 교재명, 교사명) 및 등록된 교육생 정보(교육생 이름, 주민번호 뒷자리, 등록일, 수료 및 중도 탈락) 조회 */

select distinct
  v.subjectName as "과목명",
  v.cursubStart as "과목시작일", 
  v.cursubEnd as "과목종료일",
  v.bookName as "교재명", 
  v.teacherName as "교사명",
  vs.applicantName as "교육생 이름",
  substr(vs.applicantSsn, 8, 7) as "주민번호 뒷자리",
  vs.studentRegdate as "등록일",
  case
    when c.certificateDetail = '졸업' then '수료'
    when c.certificateDetail = '중도탈락' then '중도 탈락'
    else '수강 중'
  end as "수료 여부"
from vwSubInfo v
    inner join vwSelectInfo vs on v.curriculum_seq = vs.curriculum_seq
    inner join tblCertificate c on c.student_seq = vs.student_seq
where v.curriculum_seq = 30
    order by v.cursubStart, v.teacherName, vs.applicantName;

/* 강의실 정보 추가 */

insert into tblLecture(lecture_seq, lectureRoomnum, lectureMaxstudent)
    values((select max(lecture_seq) from tblLecture) + 1, (select max(lectureRoomnum) from tblLecture) + 1, 30);

