--column

--�÷� ���
select name, buseo
    from tblInsa;
    
-- ����
select name, basicpay, basicpay * 2 as basicpay2
    from tblInsa;
    
-- ���
select name, 'ȫ�浿'
    from tblInsa;
    
    
/*distinct*/

-- 14�� ������ ���� ���� ���
select continent from tblCountry;

-- tblCountry�� �ִ� ����� ����
select distinct continent from tblCountry;

--tblInsa�� �ִ� �μ� ����
select distinct buseo from tblInsa;

--tblInsa�� �ִ� ���� ����
select distinct jikwi from tblInsa;

--�ڡڡڡڡڡڡڡ� DB�� ���̺��� �������̶�� ���� ����.
select distinct continent, name from tblCountry;

select age, height from tblAddressBook where age = 36;


/*case
    - ����
*/

select 
    last || first as name,
    gender
from tblcomedian;

select 
    last || first as name,
    gender,
    case
        when gender = 'm' then '����'
        when gender = 'f' then '����'
    end as genderName
from tblComedian;

select 
    name, 
    continent,
    case 
        when continent = 'AS' then '�ƽþ�'
        when continent = 'EU' then '����'
        when continent = 'AF' then '������ī'
        else '��Ÿ'
    end as continentName
from tblCountry;

select 
    name, 
    continent,
    case continent
        when 'AS' then '�ƽþ�'
        when 'EU' then '����'
        when 'AF' then '������ī'
    end as continentName
from tblCountry;

select
    last || first as name,
    weight,
    case
        when weight > 90 then '��ü��'
        when weight >= 50 then '����ü��'
        else '��ü��'
    end as state,
    case 
        when weight  >= 50 and weight <= 90 then '����ü��'
        else '�̻�ü��'
    end as state2,
    case
        when weight between 50 and 90 then '����ü��'
        else '�̻�ü��'
    end as state3
from tblComedian;

select 
    name, jikwi,
    case
        when jikwi in ('����', '����') then '���α�'
        else '������'
    end state
from tblInsa;

select 
    name,
    case
        when name like '��%' then 100
        when name like '��%' then 100
        when name like '��%' then 100
        else 50
    end as ������
from tblInsa;

select 
    title,
    case
        when completedate is null then '�̿Ϸ�'
        when completedate is not null then '�Ϸ�'
    end as state
from tblTodo;














