
/*plsql*/

/*프로시저, Procedure*/

-- 메소드 : 선언 > 호출
-- 익명프로시저: 호출
-- dbms_output.put_line 결과 > 기본값으로 안 보이게 설정

-- dbms_output.put_line 결과 보이게 켜기
-- 접속할 때마다 다시 실행
set serveroutput on;
set serverout on;

-- dbms_output.put_line 결과 보이게 끄기
set serveroutput off;
set serverout off;

begin
    --System.out.println()
    dbms_output.put_line(100);
    dbms_output.put_line('홍길동');
end;

declare 
    num number;
    name varchar2(30);
    today date;
begin
    num := 10;
    dbms_output.put_line(num);
    
    name := '홍길동';
    dbms_output.put_line(name);
    
    today := sysdate;
    dbms_output.put_line(today);    
end;

declare
    num1 number;
    num2 number;
    num3 number := 30;
    num4 number default 40;
    num5 number not null := 50;
    num6 number not null default 0;
begin
    num1 := 10;
    dbms_output.put_line(num1);
    
    dbms_output.put_line('---');
    dbms_output.put_line(num2); --null
    dbms_output.put_line('---');
    
    dbms_output.put_line(num3);
    
    dbms_output.put_line(num4);
    num4 := 400;    
    dbms_output.put_line(num4);
    
    dbms_output.put_line(num5);
end;


--***********PL/SQl 블럭 안에는 ANSI-SQL의 select문을 사용할 수 없다.
-- select into 절 사용
declare
    vname varchar2(30);
    buseo varchar2(30);
begin
    select name into vname from tblInsa where num = 1001;
    dbms_output.put_line(vname);
    
    --     컬럼        변수
    select buseo into buseo from tblInsa where num = 1001;
    dbms_output.put_line(buseo);
    --                    변수
end;


--회사 > 프로젝트팀
create table tblTeam(
    num number primary key,
    name varchar2(15) not null,
    buseo varchar2(15) not null,
    jikwi varchar2(15) not null
);

-- 개발부 + 부장
-- 1. ANSI-SQL
-- 2. PL/SQL

-- 1-1. 노가다.. > 비추천
select * from tblInsa where buseo = '개발부' and jikwi = '부장';
insert into tblTeam values (1003, '이순애', '개발부', '부장');


-- 1-2. 서브쿼리
insert into tblTeam values((select num from tblInsa where buseo = '개발부' and jikwi = '부장'),
                            (select name from tblInsa where buseo = '개발부' and jikwi = '부장'),
                            '개발부', '부장');


-- 2.
declare
    vnum number;
    vname varchar2(15);
begin
    --select의 결과는 반드시 PL/SQL에 넣어야 한다.
    select num into vnum from tblInsa where buseo = '개발부' and jikwi = '부장';    
    select name into vname from tblInsa where buseo = '개발부' and jikwi = '부장';    
    
    insert into tblTeam values(vnum, vname, '개발부', '부장');
end;

select * from tblTeam;


-- select into > select 결과 1개값 > PL/SQL n:n 대입도 가능

declare
    -- select 값을 저장할 변수 > 해당 컬럼의 자료형 + 길이를 미리 알고 있어야 함..
    vname varchar2(15);
    vbuseo varchar2(15);
    vjikwi varchar2(15);
begin
    
    select name, buseo, jikwi into vname, vbuseo, vjikwi from tblInsa where num = 1001;
    
    dbms_output.put_line(vname);
    dbms_output.put_line(vbuseo);
    dbms_output.put_line(vjikwi);
    
end;



/*타입 참조*/

--1. %type

declare
    vname tblInsa.name%type; -- vname varchar2(20);
    vbuseo tblInsa.buseo%type;
    vjikwi tblInsa.jikwi%type;
begin
    select name, buseo, jikwi into vname, vbuseo, vjikwi from tblInsa where num = 1002;

    dbms_output.put_line(vname);
    dbms_output.put_line(vbuseo);
    dbms_output.put_line(vjikwi);    
    
end;


-- 특정 직원에게 보너스 지급 > 내역 저장..
-- 보너스 = basicpay * 1.5
create table tblBonus (
    seq number primary key,
    num number(5) not null references tblInsa(num),
    bonus number not null
);

create sequence seqBonus;
select * from tblInsa where buseo = '총무부' and jikwi = '부장';

--1. ANSI-SQL
insert into tblBonus values(seqBonus.nextVal, 
                        (select num from tblInsa where buseo = '총무부' and jikwi = '부장'),
                        (select basicpay from tblInsa where buseo = '총무부' and jikwi = '부장') * 1.5);
                        
--2. PL/SQL
declare
    vnum tblInsa.num%type;
    vbasicpay tblInsa.basicpay%type;
begin
    select num, basicpay into vnum, vbasicpay from tblInsa 
        where buseo = '총무부' and jikwi = '부장';        
    insert into tblBonus values (seqBonus.nextVal, vnum, vbasicpay * 1.5);
end;

select * from tblBonus;


--2. %rowtype

-- 홍길동 > 모든 정보(컬럼 10개) 출력 > 프로시저
declare
    vnum tblInsa.num%type;
    vname tblInsa.name%type;
    vbuseo tblInsa.buseo%type;
    vjikwi tblInsa.jikwi%type;
    vssn tblInsa.ssn%type;
    vcity tblInsa.city%type;
    vbasicpay tblInsa.basicpay%type;
    vsudang tblInsa.sudang%type;
    vibsadate tblInsa.ibsadate%type;
    vtel tblInsa.tel%type;
begin
    select num, name, buseo, jikwi, ssn, city, basicpay, sudang, ibsadate, tel 
        into vnum, vname, vbuseo, vjikwi, vssn, vcity, vbasicpay, vsudang, vibsadate, vtel 
    from tblInsa where name = '홍길동';
    
    dbms_output.put_line(vname);
end;


declare
    vrow tblInsa%rowtype; --테이블 구조 순서대로 컬럼을 가져옴.
begin
    select * -- num, name, ssn, ibsadate, city, tel, buseo, jikwi, basicpay, sudang
        into vrow
    from tblInsa where name = '이순신';
    
    dbms_output.put_line(vrow.name);
    dbms_output.put_line(vrow.num);
    dbms_output.put_line(vrow.ssn);
    dbms_output.put_line(vrow.ibsadate);
    dbms_output.put_line(vrow.city);
    dbms_output.put_line(vrow.tel);
    dbms_output.put_line(vrow.buseo);
    dbms_output.put_line(vrow.jikwi);
    dbms_output.put_line(vrow.basicpay);
    dbms_output.put_line(vrow.sudang);
end;


--1. %type
declare
    vname tblInsa.name%type;
    vbuseo tblInsa.buseo%type;
    vjikwi tblInsa.jikwi%type;
    vcity tblInsa.city%type;
    vbasicpay tblInsa.basicpay%type;
begin
    select name, buseo, jikwi, city, basicpay
        into vname, vbuseo, vjikwi, vcity, vbasicpay
    from tblInsa where name = '홍길동';
end;

--2. %rowtype
declare
    vrow tblInsa%rowtype;
begin
    select * into vrow from tblInsa where name = '홍길동';
end;


-- '하하하' > 성전환 > tblWomen 이동
-- 1. tblMen > select > 정보
-- 2. tblWomen > insert(1번) > 복사
-- 3. tblMen > delete

declare 
    vrow tblMen%rowtype;
begin
    
    --1.
    select * into vrow from tblMen where name = '하하하';
    
    --2.
    insert into tblWomen values (vrow.name, vrow.age, vrow.height, vrow.weight, vrow.couple);
    
    --3.
    delete from tblMen where name = '하하하';
    
end;

select * from tblMen;
select * from tblWomen;



/* 
    제어문 
    1. 조건문
    2. 반복문
*/

/* 조건문*/

--1. if elsif else

declare
    vnum number := 10;
begin
    if vnum > 0 then 
        dbms_output.put_line('양수');
    end if;
end;


declare
    vnum number := -10;
begin
    if vnum > 0 then 
        dbms_output.put_line('양수');
    else 
        dbms_output.put_line('양수 아님');
    end if;
end;



declare
    vnum number := 0;
begin
    if vnum > 0 then 
        dbms_output.put_line('양수');
    elsif vnum < 0 then  
        dbms_output.put_line('음수');
    else 
        dbms_output.put_line('0');
        -- null > 빈 구문 만들 때 사용
    end if;
end;


-- 보너스 지급
-- 부장 or 과장이면 150% 지급
-- 사원급이면 200% 지급

declare
    vnum tblInsa.num%type;
    vbasicpay tblInsa.basicpay%type;
    vjikwi tblInsa.jikwi%type;
    vbonus  number;
begin
    
    --1.
    select num, basicpay, jikwi into vnum, vbasicpay, vjikwi from tblInsa where name = '이순신';
    
    --2.
    if vjikwi = '부장' or vjikwi = '과장' then
        vbonus := vbasicpay * 1.5;
    elsif vjikwi in ('사원', '대리') then
        vbonus := vbasicpay * 2;
    end if;    
    
    --3.
    insert into tblBonus values (seqBonus.nextVal, vnum, vbonus);
    
end;

select 
    b.*,
    (select name from tblInsa where num = b.num) as name,
    (select jikwi from tblInsa where num = b.num) as jikwi,
    (select basicpay from tblInsa where num = b.num) as basicpay
from tblBonus b;


--2. case(if)

declare
    vcontinent tblCountry.continent%type;
    vresult varchar2(30);
begin

    select continent into vcontinent from tblCountry where name = '대한민국';
    
    if vcontinent = 'AS' then
        vresult := '아시아';
    elsif vcontinent = 'EU' then
        vresult := '유럽';
    elsif vcontinent = 'AF' then
        vresult := '아프리카';
    else
        vresult := '기타';
    end if;
    
    dbms_output.put_line(vresult);
    
end;


declare
    vcontinent tblCountry.continent%type;
    vresult varchar2(30);
begin

    select continent into vcontinent from tblCountry where name = '대한민국';
    
    case
        when vcontinent = 'AS' then vresult := '아시아';
        when vcontinent = 'EU' then vresult := '유럽';
        when vcontinent = 'AF' then vresult := '아프리카';
        else vresult := '기타';
    end case;
    
    dbms_output.put_line(vresult);

end;


--3. case(switch)
declare
    vcontinent tblCountry.continent%type;
    vresult varchar2(30);
begin

    select continent into vcontinent from tblCountry where name = '대한민국';
    
    case vcontinent
        when 'AS' then vresult := '아시아';
        when 'EU' then vresult := '유럽';
        when 'AF' then vresult := '아프리카';
        else vresult := '기타';
    end case;
    
    dbms_output.put_line(vresult);

end;


--'신숙주'가 대여한 비디오 제목?
select * from tblMember;
select * from tblRent;
select * from tblVideo;


--1. 조인
--2. 서브쿼리

--3. 프로시저
declare
    mseq tblMember.seq%type;
    vseq tblRent.video%type;
    vname tblVideo.name%type;
begin
    select seq into mseq from tblMember where name = '신숙주';
    select video into vseq from tblRent where member = mseq;
    select name into vname from tblVideo where seq = vseq;    
    dbms_output.put_line(vname);
end;



/* 
    반복문
    
    1. loop
    2. for loop
    3. while loop
    
*/


--1. loop
declare
    vnum number := 1;
begin

    loop
        dbms_output.put_line(to_char(sysdate, 'hh24:mi:ss'));
        dbms_output.put_line(vnum);
        vnum := vnum + 1;
        
        exit when vnum > 10; --조건 만족 > loop 탈출
    end loop;

end;


-- 더미 데이터 추가 x 1000건

create table tblLoop(
    seq number primary key,
    data varchar2(30) not null
);

create sequence seqLoop;


insert into tblLoop values(seqLoop.nextVal, '데이터1');
insert into tblLoop values(seqLoop.nextVal, '데이터2');
insert into tblLoop values(seqLoop.nextVal, '데이터3');

declare 
    vnum number := 4;
begin   

    loop
        insert into tblLoop values(seqLoop.nextVal, '데이터' || vnum);
        vnum := vnum + 1;
        
        exit when vnum > 1000;
    end loop;
    
end;

select * from tblLoop;


--2. for loop

begin
    for i in 1..10 loop
        dbms_output.put_line(i);
    end loop;
end;


create table tblGugudan(
    dan number,
    num number,
    result number not null,
    
    constraint tblgugudan_dan_num_pk primary key(dan, num)
);

begin    
    for dan in 2..9 loop
        for num in 1..9 loop
            insert into tblGugudan (dan, num, result) values (dan, num, dan * num);
        end loop;
    end loop;
end;

select * from tblGugudan;


--3. while loop

declare
    vnum number := 1;
begin
    while vnum <= 10 loop
    
        dbms_output.put_line(vnum);
        vnum := vnum + 1;
    
    end loop;
end;



/* 
    
    select 결과셋 > PL/SQL 변수에 대입
    
    1. select into
        -결과 셋의 레코드가 1개일 때만 사용 가능
        
    2. cursor + loop
        -결과 셋의 레코드가 n개일 때만 사용 가능
    
*/

declare
    vname tblInsa.name%type;
begin
    --      60    :    1    > 에러
    select name into vname from tblInsa;
    
    --      0    :    1     > 에러 > null 처리 필요!
    select name into vname from tblInsa where name = '유재석';
    dbms_output.put_outline(vname);
end;


declare
    cursor vcursor is select name from tblInsa;
    vname tblInsa.name%type;
begin

    open vcursor;   -- select문 실행 > 결과셋에 커서 연결(참조) > 탐색 > 자바의 Iterator
        
        fetch vcursor into vname;   -- select into와 동일한 역할
        dbms_output.put_line(vname);
       
        fetch vcursor into vname;   
        dbms_output.put_line(vname);
        
        fetch vcursor into vname; 
        dbms_output.put_line(vname);

        fetch vcursor into vname; 
        dbms_output.put_line(vname);
        
        fetch vcursor into vname; 
        dbms_output.put_line(vname);
       
    close vcursor;
    
end;


-- 잘 안 씀..
declare
    cursor vcursor is select name from tblInsa;
    vname tblInsa.name%type;
begin

    open vcursor;  
        
        for i in 1..60 loop
            fetch vcursor into vname;  
            dbms_output.put_line(vname);
        end loop;
    close vcursor;
    
end;


declare
    cursor vcursor is select name from tblInsa;
    vname tblInsa.name%type;
begin

    open vcursor;  
        
        loop
            fetch vcursor into vname; 
            --                  boolean
            exit when vcursor%notfound; --커서가 더이상 다음 레코드를 발견하지 못할 때
            
            dbms_output.put_line(vname);            
        end loop;
        
    close vcursor;
    
end;
