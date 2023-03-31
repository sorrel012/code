-- 23년6월7일 ~ 23년 11월 29일

select 
    to_date('2023-06-07', 'yyyy-mm-dd') + level - 1
from dual
    connect by level <= 176;
    

/*

날짜 양식!!!!!!!!!!!!!!!!!!!!
insert into tblDateTest values(to_date('23/11/02'));

*/

begin
    for i in 1..31680 loop
        seqAttendance.nextVal;
    end loop;
end;