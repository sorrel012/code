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


-- select into  null처리 함수 > null value 함수

--1. nvl(컬럼, 대체값)
select 
    name,
    case
        when tel is not null then tel
        else '대체값' 
    end tel
from tblInsa;


select name, nvl(tel, '대체값') from tblInsa;


--2. nvl2(컬럼, 값A, 값B)
select 
    name,
    case
        when tel is not null then '값A'
        else '값B' 
    end tel
from tblInsa;


select name, nvl2(tel, '값A', '값B') from tblInsa;

-- cursor + loop

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


-- 기획부 직원 > 다른 테이블에 복사
select * from tblTeam;

select * from tblInsa where buseo = '기획부';

-- ANSI
insert into tblTeam (select num, name, buseo, jikwi from tblInsa where buseo = '기획부');

-- select into

--PL/SQL

declare

    cursor vcursor is 
        select num, name, jikwi, buseo from tblInsa where buseo = '기획부';
        
    vnum tblInsa.num%type;
    vname tblInsa.name%type;
    vjikwi tblInsa.jikwi%type;
    vbuseo tblInsa.buseo%type;
    
begin
    
    open vcursor;
    
        loop
        
            fetch vcursor into vnum, vname, vjikwi, vbuseo;
            exit when vcursor%notfound;
            
            insert into tblTeam values (vnum, vname, vbuseo, vjikwi);
            
        end loop;
    
    close vcursor;
    
end;

--전직원 > 보너스 지급 > 간부 1.5 / 사원2
select * from tblBonus;

declare
    cursor vcursor is
        select * from tblInsa;
        
    vrow tblInsa%rowtype;
begin
    --반복 패턴 코드 > Boilerplate Code, 축제코드
    open vcursor;
        loop
            fetch vcursor into vrow;
            exit when vcursor%notfound;
            
            -- 간부 vs 사원
            if vrow.jikwi in('과장', '부장') then
                insert into tblBonus values(seqBonus.nextVal, vrow.num, vrow.basicpay*1.5);
            else
                insert into tblBonus values(seqBonus.nextVal, vrow.num, vrow.basicpay*2);
            end if;
            
        end loop;
    close vcursor;
end;

select 
    b.*,
    (select name from tblInsa where num = b.num) as name,
    (select jikwi from tblInsa where num = b.num) as jikwi,
    (select basicpay from tblInsa where num = b.num) as basicpay
from tblBonus b;


/* 커서 탐색*/

--1. 커서 + loop > 비선호


declare
    cursor vcursor is
        select * from tblInsa;
begin
    open vcursor;
        loop
            fetch vcursor into vrow;
            exit when vcursor%notfound;
        end loop;
    close vcursor;
end;



--2. 커서 + for loop > 선호

declare
    cursor vcursor is
        select * from tblInsa;
begin
    -- open + loop + fetch into + vrow + exit when + 
    for vrow in vcursor loop --vcursor(결과 테이블 = 레코드집합)
        dbms_output.put_line(vrow.name);
    end loop;
end;


/*예외 처리*/

declare
    vname varchar2(15);
begin

    dbms_output.put_line('시작');
    select name into vname from tblInsa; --레코드가 1개가 아니라서 에러 발생
    dbms_output.put_line('종료');

exception

    --when 예외상수 then 처리;
    when others then --others: 모든 예외
        dbms_output.put_line('예외 처리');

end;


--DB 오류 발생 > 기록 남긴다.
create table tblError (
    seq number primary key,
    code varchar2(4) not null check(code in ('A001', 'B001', 'B002')), --에러 상태 코드
    regdate date default sysdate not null
);

delete from tblCountry;

declare
    vcnt number;
    vname varchar2(15);
begin
    
    --1. 
--    select count(*) into vcnt from tblCountry;
--    dbms_output.put_line(100 / vcnt);
    
    --2.
    select name into vname from tblInsa; -- where num = 1001;
    dbms_output.put_line(vname);

exception
    
    when ZERO_DIVIDE then
        dbms_output.put_line('0으로 나누었습니다.');
        insert into tblError values ((select nvl(max(seq), 0) + 1 from tblError), 'A001', default);
        
    when TOO_MANY_ROWS then
        dbms_output.put_line('가져온 행이 많습니다.');
        insert into tblError values ((select nvl(max(seq), 0) + 1 from tblError), 'B001', default);
    
    when others then
        dbms_output.put_line('예외 처리');
        insert into tblError values ((select nvl(max(seq), 0) + 1 from tblError), 'B002', default);
        
end;

select * from tblError order by regdate desc;



-- 익명 프로시저 > 즉시 실행 > 실행 회차별 비용 = 동일
declare
    vnum number;
begin
    vnum := 100;
    dbms_output.put_line(vnum);
end;


-- 저장 프로시저 > 선언 > 오라클 서버에 저장
create or replace procedure procTest
is
    vnum number;
begin
    vnum := 100;
    dbms_output.put_line(vnum);
end;


-- 저장 프로시저를 호출하는 방법(메소드 실행하는 방법)
-- 현재 코딩하는 영역 > ANSI-SQL 영역
select * from tblInsa;
procTest; --PL/SQL 구문은 그냥 호출할 수 없음

-- PL/SQL 영역을 만든 뒤 > 그 안에서 프로시저를 호출할 수 있다.
begin
    -- 이 안이 PL/SQL 영역
    procTest;
end;

-- 아래 방법도 있지만 위의 방식을 선호
execute procTest;
exec procTest;
call procTest();




-- 저장 프로시저 = 메소드
-- 매개변수 & 반환값

-- 1. 매개변수가 있는 프로시저
create or replace procedure procTest(pnum number) --매개변수
is
    vnum number; --일반변수(지역 변수)
begin
    
    vnum := pnum * 2;
    dbms_output.put_line(vnum);
    
end procTest; -- end뒤에 프로시저명 적는게 관례(헷갈리지 않도록) > 다르게 적으면 에러남

--호출
begin
    procTest(100);
    procTest(200);
    procTest(300);
end;



create or replace procedure procTest(
    width number, 
    height number
)
is
    vnum number;
    vresult number;
begin
    
    vnum := width * height;
    dbms_output.put_line(vnum);
    
end procTest;

--호출
begin
    procTest(10, 20);
end;


-- 일반 변수: vname varchar2(30) not null default '이름'

-- *** 프로시저 매개변수는 길이와 not null 표현이 불가능하다. (default 가능)
create or replace procedure procTest(
    pname varchar2 -- varchar2(30) 길이 지정하면 에러
)
is -- declare 대신하는 is(as)는 변수 선언이 없어도 반드시 기재 
begin
    dbms_output.put_line('안녕하세요.' || pname || '님');
end procTest;

begin
    procTest('홍길동');
end;



create or replace procedure procTest(
    width number, 
    height number default 10
)
is
    vnum number;
    vresult number;
begin
    
    vnum := width * height;
    dbms_output.put_line(vnum);
    
end procTest;

--호출
begin
    -- 오버로딩(X) 매개변수 기본값 때문(O)
    procTest(10, 20);
    procTest(10);
end;


-------------------------------------------------------------

/*

    매개변수 모드
    - 매개변수가 값을 전달하는 방식
    - call by value
    - call by reference
    
    1. in 모드 > 기본 모드
    2. out 모드 (return문 같은 역할)
    3. in out 모드 > 거의 안 씀

*/

create or replace procedure procTest (
    pnum1 in number, -- 우리가 알고있는 기존의 매개변수(호출할 때 넘기는 데이터) --in 생략가능
    pnum2 in number,
    presult1 out number, -- 변수 자체가 전달. 변수의 주소값 전달 > 반환값 역할
    presult2 out number, -- 여러개 가능
    presult3 out number
)
is
begin
    dbms_output.put_line(pnum1+pnum2);
    presult1 := pnum1 + pnum2;
    presult2 := pnum1 * pnum2;
    presult3 := pnum1 / pnum2;
end procTest;


-- PLS-00363: expression 'TO_NUMBER(SQLDEVBIND1Z_1)' cannot be used as an assignment target
declare
    vresult number;
begin
    procTest(10, 20, vresult);
    dbms_output.put_line(vresult);
end;


declare
    vresult1 number;
    vresult2 number;
    vresult3 number;
begin
    procTest(10, 20, vresult1, vresult2, vresult3);
    dbms_output.put_line(vresult1);
    dbms_output.put_line(vresult2);
    dbms_output.put_line(vresult3);
end;



--문제
-- 프로시저 생성 + 호출

-- 1. 부서 지정 > 해당 부서 직원 중 급여 가장 많이 받는 사람의 번호 반환
--      in 1개 > out 1개
-- procTest1
-- 매개변수 in 부서/ out 직원번호


--답안
create or replace procedure procTest1 (
    pbuseo  in   varchar2,
    pnum    out  number
)
is
begin
    select num into pnum from tblInsa
        where basicpay = (select max(basicpay) from tblInsa where buseo = pbuseo) and buseo = pbuseo;
end procTest1;

--테스트
declare
    vnum number;
begin
    procTest1('기획부', vnum);
    dbms_output.put_line(vnum);
end;

-- 2. 직원 번호 지정 > 같이 지역에 사는 직원 수, 같은 직위의 직원 수, 해당 직원보다 급여를 더 많이 받은 직원 수를 반환
--      in 1개 > out 3개
-- procTest2
-- in 직원번호 / out count

--답안
create or replace procedure procTest2 (
    pnum   in  number,
    pcnt1  out number,
    pcnt2  out number,
    pcnt3  out number
)
is 
    vcity tblInsa.city%type;
    vjikwi tblInsa.jikwi%type;
    vbasicpay tblInsa.basicpay%type;
begin
    
    select city, jikwi, basicpay into vcity, vjikwi, vbasicpay from tblInsa where num = pnum;
    
    select count(*) into pcnt1 from tblInsa where city = vcity;
    select count(*) into pcnt2 from tblInsa where jikwi = vjikwi;
    select count(*) into pcnt3 from tblInsa where basicpay = vbasicpay;
    
end procTest2;


--테스트
declare
    vcnt1 number; vcnt2 number; vcnt3 number;
begin
    procTest2(1001, vcnt1, vcnt2, vcnt3);
    dbms_output.put_line(vcnt1);
    dbms_output.put_line(vcnt2);
    dbms_output.put_line(vcnt3);
end;



-- A. 신입 사원 추가 + 프로젝트 담당

create or replace procedure procAddStaff (
    pname    in  varchar2,   --신입 사원명
    psalary  in  number,     --신입 급여
    paddress in  varchar2,   --신입 주소
    pproject in  varchar2,   --프로젝트명
    presult  out number      --피드백(성공/실패)
)
is
    vseq number; --신입 사원 번호
begin

    --신입 사원 번호 생성
    select nvl(max(seq), 0 ) + 1 into vseq from tblStaff;

    --1. 신입 사원 추가
    insert into tblStaff (seq, name, salary, address)
        values (vseq, pname, psalary, paddress);
    
    --2. 프로젝트 담당
    insert into tblProject (seq, project, staff_seq)
        values ((select nvl(max(seq), 0) + 1 from tblProject), pproject, vseq);
    
    presult := 1;
    
exception
    when others then
        presult := 0; --실패
end procAddStaff;


--테스트
declare
    vresult number; --결과(out)
begin
    
    --procAddStaff('이순신', 300, '서울시', '박물관 건립', vresult);
    procAddStaff('유관순', 350, '부천시', '미술관 건립', vresult);
    
    if vresult = 1 then
        dbms_output.put_line('성공');
    else
        dbms_output.put_line('실패');
    end if;
    
end;

set serveroutput on; --켜야됨


-- B. 사원 퇴사: 담당 프로젝트 확인 > 다른 직원에게 위임 > 퇴사 
create or replace procedure procRemoveStaff(
    pseq    in  number, --퇴사할 직원번호
    pdseq   in  number,    --위임할 직원번호
    presult out number
)
is
    vcnt number;
begin
    
    --1. 퇴사 직원 번호가 유효한지? 존재하는 번호인지?
    select count(*) into vcnt from tblStaff where seq = pseq;
    
    --2. 
    if vcnt = 1 then
        -- 존재
        --3. 위임받을 직원 번호 확인
        select count(*) into vcnt from tblStaff where seq = pdseq; --vcnt 재사용 가능
        
        if vcnt = 1 then
            --4. 담당 프로젝트 확인 > 위임
            select count(*) into vcnt from tblProject where staff_seq = pseq;
            
            if vcnt > 0 then
                --5. 위임
                update tblProject set
                    staff_seq = pdseq
                        where staff_seq = pseq;
            end if;
            
            --6. 퇴사
            delete from tblStaff where seq = pseq;
            presult := 1;
        
        else
            presult := 0;
        end if;
        
        
    else
        presult := 0;
    end if;
    
exception
    when others then
        presult := 0;

end procRemoveStaff;


--테스트
declare
    vresult number;
begin
    procRemoveStaff (7, 5, vresult);
    
    if vresult = 1 then
        dbms_output.put_line('성공');
    else
        dbms_output.put_line('실패');
    end if;
    
end;

select * from tblStaff;
select * from tblProject;


------------------------------------------------------

/*저장 함수, Stored Function*/


-- 1 + 2 > 3
create or replace function fnSum (
    pnum1 number,
    pnum2 number
    --presult out number    --out 쓰는 순간 프로시저랑 똑같아짐.. 쓰면 X
    
) return number --리턴 타입
is
begin
    
    return pnum1 + pnum2;
    
end fnSum;
/ --슬래시 붙이면 실행할때 블럭 안잡아도 됨

declare
    vresult number;
begin

    -- 프로시저 out > 개수 1개 이상
    -- 함수 return > 개수 딱 1개
    vresult := fnSum(10, 20);
    dbms_output.put_line(vresult);
end;
/



select
    height, weight,
    height + weight,
    fnSum(height, weight) --함수 ANSI-SQL에서 사용 가능
    --procSum(height, weight, vresult)
from tblComedian;



-- 이름, 부서, 직위, 성별(남자|여자)
-- 팀 프로젝트(A 팀원 작업)
select
    name, buseo, jikwi,
    case substr(ssn, 8, 1)
        when '1' then '남자'
        when '2' then '여자'
    end as gender
from tblInsa;

-- 팀 프로젝트(B 팀원 작업)
-- 이름, 급여, 성별(남자|여자)
select
    name, basicpay,
    fnGender(ssn) as gender
from tblInsa;


create or replace function fnGender(
    pssn varchar2
) return varchar2
is
begin
    return case substr(pssn, 8, 1)
                when '1' then '남자'
                when '2' then '여자'
            end;
end fnGender;


/*트리거, Trigger*/

-- tblInsa > 직원 삭제
create or replace trigger trgInsa
    before      --삭제하기 직전에 프로시저를 실행해라
    --delete      --삭제가 발생하는지 감시해라
    update
    on tblInsa  --감시대상 > tblInsa
begin
    dbms_output.put_line('트리거가 실행되었습니다.');
end trgInsa;
/

select * from tblInsa;

rollback;

delete from tblBonus where num = 1001;
delete from tblInsa where name = '홍길동';

select * from tblInsa;
update tblInsa set
    name = '탈퇴',
    ssn = '탈퇴',
    ibsadate = sysdate,
    city = '탈퇴',
    tel = '탈퇴',
    buseo = '탈퇴',
    jikwi = '탈퇴',
    basicpay = 0,
    sudang = 0
        where num = 1001;

/*

    레코드 삭제 > 관계 맺은 자식 테이블에서 참조가 있는 경우..
    
    1. 홍길동 > 취소
    2. 홍길동 > 삭제
        a. 홍길동 삭제 + 자식 삭제
        b. 홍길동 삭제 + 자식 보존 > FK 제약 삭제 > 비권장!!!!!
        c. 홍길동 변형 + 자식 보존 > 회원 탈퇴
        
*/

select * from tblBonus where num = 1001; --5 1001 3915000

drop table tblBonus;

select * from tblInsa;
delete from tblInsa where num = 1001;

update tblInsa set city = '서울' where num = 1003;




-- tblInsa > 직원 퇴사 트리거
-- 수요일 > 퇴사 금지!!
create or replace trigger trgRemoveInsa
    before
    delete
    on tblInsa
begin
    
    dbms_output.put_line('트리거 실행');
    
    -- 수요일 퇴사 금지 > 현재 무슨 요일?
    --if to_char(sysdate, 'dat') = '수요일' then
    --if to_char(sysdate, 'dy') = '수' then
    if to_char(sysdate, 'd') = '4' then
        dbms_output.put_line('수요일');
        -- 퇴사 금지 > 지금 트리거 호출의 원인 > 실행 중인 delete문을 없었던 일로 > 취소 > 강제 예외 발생!!!
        -- 자바 > throw new Exception();
        -- -20000 ~ -29999 사이만 쓸 수 있음
        raise_application_error (-20000, '수요일에는 퇴사가 불가능합니다.');
    else
        dbms_output.put_line('다른 요일');
    end if;
        
end trgRemoveInsa;


delete from tblInsa where num = 1003;
delete from tblInsa where num = 1004;




select * from tblMen;

create table tblLogMen (
    seq number primary key,
    message varchar2(1000) not null,
    regdate date default sysdate not null
);

create sequence seqLogMen;


create or replace trigger trgLogMen
    after
    insert or update or delete --다수의 사건 동시에 감시
    on tblMen
declare
    vmessage varchar2(1000);
begin
    
    dbms_output.put_line('트리거 실행');
    
    -- 호출: insert? update? delete? 구분
    if inserting then
        dbms_output.put_line('새로운 항목이 추가되었습니다.');
        vmessage := '새로운 항목이 추가되었습니다.';
    elsif updating then
        dbms_output.put_line('항목이 수정되었습니다.');
        vmessage := '항목이 수정되었습니다.';
    elsif deleting then
        dbms_output.put_line('항목이 삭제되었습니다.');
        vmessage := '항목이 삭제되었습니다.';
    end if;
    
    insert into tblLogMen values (seqLogMen.nextVal, vmessage, default);
    
end trgLogMen;


select * from tblMen;

insert into tblMen values ('테스트', 22, 175, 60, null);
update tblMen set weight = 65 where name = '테스트';
delete from tblMen where name = '테스트';


select * from tblLogMen;


create or replace trigger trgCountry
    after
    update
    on tblCountry
begin
    
    update tblCountry set
        population = population * 1.1; --얘도 update > 다시 trigger 호출 > 무한루프..
    
end trgCountry;


-- 무한루프
update tblCountry set capital = '제주' where name = '대한민국';


select * from tblWomen;


create or replace trigger tblWomen
    after
    delete
    on tblWomen
    for each row --이것만 붙이면 행 단위 트리거 됨
begin
    dbms_output.put_line('레코드를 삭제했습니다.' || :old.name);
end trgWomen;


delete from tblWomen where name = '하하하';
delete from tblWomen;

rollback;



-- insert 트리거
create or replace trigger tblWomen
    after
    insert
    on tblWomen
    for each row --이것만 붙이면 행 단위 트리거 됨
begin
    -- :new > 새롭게 추가되는 행 참조 객체
    dbms_output.put_line('레코드를 추가했습니다.' || :new.name || :new.age);
end trgWomen;

insert into tblWomen values ('호호호', 20, 160, 50, null);

select * from tblWomen;



-- 상관 관계
-- 1. :new
-- 2. :old

create or replace trigger trgWomen
    after
    insert on tblWomen
    for each row
begin
    dbms_output.put_line(':old > ' || :old.name); --:old >
    dbms_output.put_line(':new > ' || :new.name); --:new > 테스트
    dbms_output.put_line(' ');
end trgWomen;


insert into tblWomen values ('테스트', 22, 175, 60, null);
update tblWomen set weight = 65 where name = '테스트'; 
delete from tblWomen where name = '테스트';


--update
create or replace trigger trgWomen
    after
    update on tblWomen
    for each row
begin
    dbms_output.put_line(':old > ' || :old.weight); --:old > 60
    dbms_output.put_line(':new > ' || :new.weight); --:new > 65
    dbms_output.put_line(' ');
end trgWomen;

rollback;

insert into tblWomen values ('테스트', 22, 175, 60, null);
update tblWomen set weight = 65 where name = '테스트'; 
delete from tblWomen where name = '테스트';


--delete
create or replace trigger trgWomen
    after
    delete on tblWomen
    for each row
begin
    dbms_output.put_line(':old > ' || :old.name); --:old > 테스트
    dbms_output.put_line(':new > ' || :new.name); --:new >
    dbms_output.put_line(' ');
end trgWomen;


-- 퇴사 > 위임 (트리거)
select * from tblStaff;
select * from tblProject;

-- '이순신' 퇴사
create or replace trigger trgRemoveStaff
    before          --3. 퇴사 직전에
    delete          --2. 퇴사를 하면
    on tblStaff     --1. 직원 테이블을 감시
    for each row    --4. 담당 프로젝트 위임한다.
declare
    vdseq number;
begin
    --5. 퇴사 전에 담당 프로젝트를 다른 사람에게 위임한다. > 현재 맡고 있는 프로젝트 수가 가장 적은 직원에게 (에러)
    --select min(count(*)) from tblProject group by staff_seq;
    
--    select seq into vdseq from (select
--                        s.seq
--                    from tblStaff s
--                        left outer join tblProject p
--                            on s.seq = p.staff_seq
--                                having count(p.seq) = (select
--                                                            min(count(p.seq))
--                                                        from tblStaff s
--                                                            left outer join tblProject p
--                                                                on s.seq = p.staff_seq
--                                                                    group by s.seq)
--                                    group by s.seq)
--                                        where rownum = 1;
    
    update tblProject set
        staff_seq = 2
            where staff_seq = :old.seq;
    
    
end trgRemoveStaff;


delete from tblStaff where seq = 5;

select * from tblProject;


