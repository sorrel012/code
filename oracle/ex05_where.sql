--where

SELECT *
    FROM tblCountry
        where name = '���ѹα�';
        
select *
    from tblCountry
        where continent = 'AS';
        
select *
    from tblInsa
        where basicpay > 2000000;
    
select *
    from tblInsa
        where basicpay <= 2000000;    
        
select *
    from tblInsa
        where buseo = '���ߺ�';
        
select *
    from tblInsa
        where buseo<> '���ߺ�';
        
select *
    from tblInsa
        where buseo =  '���ߺ�' and jikwi = '����';       
        
select *
    from tblInsa
        where city = '����' or city = '���';
        
select *
    from tblInsa
        where not buseo = '���ߺ�';

-- tblComedian
--1. �����԰� 60kg �̻��̰�, 170cm �̸��� ����� �������ÿ� > 3��
select *
    from tblComedian
        where weight >= 60 and height < 170;
        
--2. �����԰� 70kg ������ ���ڸ� �������ÿ�. 1��
select *
    from tblComedian
        where weight <= 70 and gender = 'f';

--tblInsa
--3. �μ��� '���ߺ�'�̰�, �޿��� 150���� �̻� �޴� ������ �������ÿ�  4�D
select * 
    from tblInsa
        where buseo='���ߺ�' and basicpay >= 1500000;

--4. �޿� + ������ ���� �ݾ��� 200���� �̻��� ������ �������ÿ� > 26��
select *
    from tblInsa
        where (basicpay + sudang) >= 2000000;

--between
select *
    from tblComedian
        where height between 172 and 178;

--����
--1. ������
select *
    from tblInsa
        where basicpay >= 1500000 and basicpay <= 2000000;
        
select *
    from tblInsa
        where basicpay between 1500000 and 2000000;

--2. ������
select * from tblInsa where name >= '��';
select * from tblInsa where name between '��' and '��';

--3. ��¥�ð���
desc tblInsa;
select * from tblInsa where ibsadate >= '2000-01-01'; --2000�� ���Ŀ� �Ի��� ������
select * from tblInsa where ibsadate between '2000-01-01' and '2000-12-31';

-- ȫ���� or ���ߺ�
select * from tblInsa where buseo = 'ȫ����' or buseo = '���ߺ�';
select * from tblInsa where buseo in ('ȫ����', '���ߺ�');

select * from tblInsa
    where jikwi in('����', '����') and city in ('����', '��õ')
        and basicpay between 2500000 and 3000000;

-- ���� ���ڿ�
-- like, _, %

-- _
select name from tblInsa where name like '��__';
select name from tblInsa where name like '__��';
select name from tblInsa where name like '_��_';

--%
select name from tblInsa where name like '��%';
select * from tblAddressBook where address like '����Ư����%';
select * from tblAddressBook where address like '%���빮��%';
select * from tblAddressBook where name like '��%';
select * from tblAddressBook where name like '%��';
select * from tblAddressBook where name like '%��%';

--��������
select * from tblInsa where ssn like '______-2______';
select * from tblInsa where ssn like '%-2%';


/*
    RDBS������ null
    -�ڹ��� null�� ����
    - �÷���(��)�� ����ִ� ����
    - null ��� ����
    - ��κ��� ���� null�� ������ ����� �� �� ����.�ڡڡڡڡ�
    
    null ����
    - where������ ���
    
*/

select * from tblCountry where population is null;

select * from tblCountry where population is not null;

select * from tblInsa where tel is null;

-- ���� �������� ���� ��
select * from tblTodo where completedate is null;

--�Ϸ��� ��
select * from tblTodo where completedate is not null;



-- �䱸����.001.tblCountry
-- ��� ��� ��� �÷��� �������ÿ�.
select * from tblCountry;


-- �䱸����.002.tblCountry
-- ������� �������� �������ÿ�.
select name, capital from tblCountry;


-- �䱸����.003.tblCountry
-- �Ʒ��� ���� �������ÿ�
-- [������]    [������]   [�α���]   [����]    [���] <- �÷���
-- ���ѹα�   ����        4403       101       AS     <- ������
select 
    name as "[������]",
    capital as "[������]", 
    population as "[�α���]", 
    area as "[����]", 
    continent as "[���]"  
from tblCountry;


--�䱸����.004.tblCountry
--�Ʒ��� ���� �������ÿ�
-- [��������] <- �÷���
-- ������: ���ѹα�, ������: ����, �α���: 4403   <- ������
select
    '������: ' || name || ', ������: ' || capital || ', �α���: ' || population as "[��������]"
from tblCountry;

--�䱸����.005
--�Ʒ��� ���� �������ÿ�.employees
-- [�̸�]                 [�̸���]                 [����ó]            [�޿�]
-- Steven King           SKING@gmail.com   515.123.4567      $24000
select 
    first_name || ' ' || last_name as "[�̸�]",
    email as "[�̸���]", 
    phone_number as "[����ó]", 
    salary as "�޿�" 
from employees;


--�䱸����.006.tblCountry
--����(area)�� 100������ ������ �̸��� ������ �������ÿ�.
select name, area 
    from tblCountry
        where area <= 100;


--�䱸����.007.tblCountry
--�ƽþƿ� ���� ����� ���� ���� �������ÿ�.
select name
    from tblCountry
        where continent in ('AS', 'EU');


--�䱸����.008.employees
--����(job_id)�� ���α׷���(it_prog)�� ������ �̸�(Ǯ����)�� ����ó �������ÿ�.
select (first_name || ' ' || last_name), phone_number
    from employees 
        where job_id = 'IT_PROG';


--�䱸����.009.employees
--last_name�� 'Grant'�� ������ �̸�, ����ó, ��볯¥�� �������ÿ�.
select (first_name || ' ' || last_name), phone_number, hire_date
    from employees
        where last_name = 'Grant';
        

--�䱸����.010.employees
--Ư�� �Ŵ���(manager_id: 120)�� �����ϴ� ������ �̸�, �޿�, ����ó�� �������ÿ�.
select (first_name || ' ' || last_name), salary, phone_number
    from employees
        where manager_id=120;


--�䱸����.011.employees
--Ư�� �μ�(60, 80, 100)�� ���� �������� �̸�, ����ó, �̸���, �μ�ID �������ÿ�.
select (first_name || ' ' || last_name), phone_number, email, department_id
    from employees
        where department_id in(60, 80, 100);


--�䱸����.012.tblInsa
--��ȹ�� ������ �������ÿ�.
select * 
    from tblInsa
        where buseo = '��ȹ��';

--�䱸����.013.tblInsa
--���￡ �ִ� ������ �� ������ ������ ����� �̸�, ����, ��ȭ��ȣ �������ÿ�.
select name, jikwi, tel, city
    from tblInsa
        where city = '����' and jikwi = '����';


--�䱸����.014.tblInsa
--�⺻�޿� + ���� ���ļ� 150���� �̻��� ���� �� ���￡ ������ �������ÿ�.
select *
    from tblInsa
        where (basicpay + sudang) >= 1500000 and city = '����';


--�䱸����.015.tblInsa
--������ 15���� ������ ���� �� ������ ���, �븮�� �������ÿ�.
select *
    from tblInsa
        where sudang <= 150000 and jikwi in('���', '�븮');


--�䱸����.016.tblInsa
--������ ������ �⺻ ������ 2õ���� �̻�, ����, ���� ����(����)�� �������ÿ�.
select *
    from tblInsa
        where basicpay*12 >= 20000000 and city = '����' and jikwi in ('����', '����');

--�䱸����.017.tblCountry
--������ 'O��'�� ���� �������ÿ�.
select * 
    from tblCountry
        where name like '_��';


--�䱸����.018.employees
--����ó�� 515�� �����ϴ� ������ �������ÿ�.
select * 
    from employees
        where phone_number like '515%';
     

--�䱸����.019.employees
--���� ID�� SA�� �����ϴ� ������ �������ÿ�.
select * 
    from employees
        where job_id like 'SA%';
    
    
--�䱸����.020.employees
--first_name�� 'de'�� �� ������ �������ÿ�.
select * 
    from employees
        where first_name like '%de%';


--�䱸����.021.tblInsa
--���� ������ �������ÿ�.
select * 
    from tblInsa
        where ssn like '%-1%';


-- �䱸����.022.tblInsa
--���� ������ �������ÿ�.   
select * 
    from tblInsa
        where ssn like '%-2%';


--�䱸����.023.tblInsa
--������(7,8,9��) �¾ ������ �������ÿ�.
select * 
    from tblInsa
        where ssn like '__07%' or ssn like '__08%' or ssn like '__09%';


--�䱸����.024.tblInsa
--����, ��õ�� ��� �达�� �������ÿ�.    
select *
    from tblInsa
        where city in ('����', '��õ') and name like '��%';


--�䱸����.025.tblInsa > 10
--������/�ѹ���/���ߺ� ���� �� �����(���/�븮) �߿� 010�� ����ϴ� �������� �������ÿ�.
select *
    from tblInsa
        where buseo in ('������', '�ѹ���', '���ߺ�') 
            and jikwi in('���', '�븮')
            and tel like '010%';


--�䱸����.026.tblInsa > 18
--����/��õ/��⿡ ��� �Ի����� 1998~2000�� ������ �������� �������ÿ�.
select *
    from tblInsa
        where city in ('����', '��õ', '���') 
            and ibsadate between '1998-01-01' and '2000-12-31';


--�䱸����.027.employees > 1
--�μ��� ���� ���� �ȵ� �������� �������ÿ�. (department_id�� ���� ����)
select *
    from employees
        where department_id is null;




