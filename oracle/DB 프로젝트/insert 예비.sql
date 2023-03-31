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