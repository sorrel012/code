/*
    
A.04 개설 과목 관리
	- 특정 개설 과정 선택 시 개설 과목 정보 출력 및 개설 과목 신규 등록
	- 개설 과목 정보 입력시 과목명, 과목기간(시작 년월일, 끝 년월일), 교재명, 교사명을 입력
	- 개설 과목 출력 시 개설 과정 정보(과정명, 과정기간(시작 년월일, 끝 년월일), 강의실)와 과목명, 과목기간(시작 년월일, 끝 년월일), 교재명, 교사명을 출력
	- 개설 과목 정보에 대한 입력, 출력, 수정, 삭제

*/

/*개설 과목 정보*/

-- 1. 입력(과목 시작일, 과목 종료일, 과정번호, 과목번호, 교사번호 / 과목 번호, 교재번호)

--프로시저
create or replace procedure procSubInfoI_h (
    psubStart date,
    psubEnd date,
    pcurrSeq number,
    pteacherSeq number,
    psubSeq number,
    pbookSeq number
)
is
begin
    insert into tblCurSub(cursubStart, cursubEnd, curriculum_seq, subject_seq, teacher_seq)
        values(psubStart, psubEnd, pcurrSeq, psubSeq, pteacherSeq);
    insert into tblSubBook(subject_seq, book_seq) 
        values(psubSeq, pbookSeq);
end procSubInfoI_h;


--호출
begin
    procSubInfoI_h('2023-12-04', '2024-02-02', 37, 11, 13, 24);
end;
     
select * from  vwCurrInfo;
-- 2. 출력

select lectureRoomnum from vwCurrInfo;

--프로시저
create or replace procedure procSubInfoR_h(
    psubSeq number
)
is 
    vscurrtName vwCurrInfo.curriculumName%type;
    vcurrtStart vwCurrInfo.curriculumStart%type;
    vcurrtEnd vwCurrInfo.curriculumEnd%type;
    vlecture vwCurrInfo.lectureRoomnum%type;
    vsubName vwSubInfo.subjectName%type;
    vcursubStart vwSubInfo.cursubStart%type;
    vcursubEnd vwSubInfo.cursubEnd%type;
    vbookName vwSubInfo.bookName%type;
    vteacherName vwSubInfo.teacherName%type;
    
    cursor vcursor is select distinct vc.curriculumName, vc.curriculumStart, vc.curriculumEnd, vc.lectureRoomnum, vs.subjectName, vs.cursubStart,  vs.cursubEnd, vs.bookName, vs.teacherName
                        from vwCurrInfo vc
                            inner join vwSubInfo vs on vc.curriculum_seq = vs.curriculum_seq
                        where vs.subject_seq = psubSeq
                            order by vs.subjectName, vs.cursubStart;
begin
    open vcursor;
    
        loop
        
            fetch vcursor into vscurrtName, vcurrtStart, vcurrtEnd, vlecture, vsubName, vcursubStart, vcursubEnd, vbookName, vteacherName;
            exit when vcursor%notfound;
            
            dbms_output.put_line('과정명: ' ||vscurrtName || ' / 과정 시작일: ' || to_char(vcurrtStart, 'yyyy-mm-dd') || ' / 과정 종료일: ' || to_char(vcurrtEnd, 'yyyy-mm-dd') ||  ' / 강의실: '|| vlecture 
                                    || '호 / 과목명: ' || vsubName || ' / 과목 시작일: ' || vcursubStart || ' / 과목 종료일: ' || vcursubEnd || ' / 교재명: ' || vbookName || ' / 교사명: ' || vteacherName);            
        
        end loop;    
        
    close vcursor;
end procSubInfoR_h;


--호출
begin
    procSubInfoR_h(1);
end;


-- 3. 수정

-- 프로시저

-- 과목 기간 
create or replace procedure procSubPerU_h(
    pstart date,
    pend date,
    pcurrSeq number,
    psubSeq number
)
is 
begin    
    update tblCurSub set cursubStart = pstart, cursubEnd = pend
        where curriculum_seq = pcurrSeq and subject_seq = psubSeq;
end procSubPerU_h;

-- 담당 교사 
create or replace procedure procSubTeU_h(
    pteSeq number,
    pcurrSeq number,
    psubSeq number
)
is 
begin        
    update tblCurSub set teacher_seq = pteSeq
        where curriculum_seq = pcurrSeq and subject_seq = psubSeq;
end procSubTeU_h;
    
-- 교재 번호 
create or replace procedure procSubBookU_h(
    poldbkSeq number,
    pnewbkSeq number,
    psubSeq number
)
is 
begin    
    update tblSubBook set book_seq = pnewbkSeq
        where subject_seq = psubSeq and book_seq = poldbkSeq;
end procSubBookU_h;


-- 호출
begin
    procSubPerU_h('2023-12-04', '2024-02-01', 37, 13);
    procSubTeU_h(1, 37, 13);
    procSubBookU_h(24, 15, 13);
end;


-- 4. 삭제

--프로시저

--과목 정보
create or replace procedure procSubD_h(
    pcurrSeq number,
    psubSeq number
)
is 
begin    
    delete tblCurSub 
        where curriculum_seq = pcurrSeq and subject_seq = psubSeq;
end procSubD_h;

--과목별 교재 정보
create or replace procedure procSubBookD_h(
    psubSeq number
)
is 
begin    
    delete tblSubBook
        where subject_seq = psubSeq;
end procSubBookD_h;


--호출
begin
    procSubD_h(37, 13);
    procSubBookD_h(13);
end;

/* 특정 개설 과정 선택 시 개설 과목 정보 출력*/
create or replace procedure procCurSubInfoR_h(
    pCurSeq number
)
is 
    vscurrtName vwCurrInfo.curriculumName%type;
    vsubName vwSubInfo.subjectName%type;
    vcursubStart vwSubInfo.cursubStart%type;
    vcursubEnd vwSubInfo.cursubEnd%type;
    vbookName vwSubInfo.bookName%type;
    vteacherName vwSubInfo.teacherName%type;
    
    cursor vcursor is select distinct vc.curriculumName, vs.subjectName, vs.cursubStart, vs.cursubEnd, vs.bookName, vs.teacherName
                        from vwCurrInfo vc
                            inner join vwSubInfo vs on vc.curriculum_seq = vs.curriculum_seq
                        where vs.curriculum_seq = pCurSeq
                            order by vs.subjectName, vs.cursubStart;
begin
    open vcursor;
    
        loop
        
            fetch vcursor into vscurrtName, vsubName, vcursubStart, vcursubEnd, vbookName, vteacherName;
            exit when vcursor%notfound;
            
            dbms_output.put_line('과정명: ' ||vscurrtName || ' / 과목명: ' || vsubName || ' / 과목 시작일: ' || vcursubStart || ' / 과목 종료일: ' || vcursubEnd || ' / 교재명: ' || vbookName || ' / 교사명: ' || vteacherName);            
        
        end loop;    
        
    close vcursor;
end procCurSubInfoR_h;


--호출
begin
    procCurSubInfoR_h(1);
end;
    
    