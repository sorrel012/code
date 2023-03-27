
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










