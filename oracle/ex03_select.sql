--select��

select �÷�����Ʈ from ���̺��;


-- ó�� ���� ���̺��� ����(��Ű��, Scheme) Ȯ��
desc employees; --SQL Developer, SQL Plus�� ����

-- ���� �÷� ��ȸ
select first_name from employees;
select email from employees;

-- ���� �÷� ��ȸ

select first_name, last_name from employees;

--1.
select first_name, last_name, email, salary, phone_number from employees;

--2.
select first_name, last_name, email, salary, phone_number 
from employees;

--3.
select 
    first_name, last_name, email, salary, phone_number 
from 
    employees;
    
--4.
select first_name, last_name, email, salary, phone_number 
    from employees;

--���ϵ� ī�� ���    
select * --���ϵ�ī��(*) > ��� �÷�
    from employees;
    
-- select���� �÷� ����Ʈ�� �÷� ������ ���� ���̺��� �÷� ������ �����ϴ�.
select last_name, first_name from employees;

-- ���� �÷��� �ݺ��ؼ� �������� �͵� �����ϴ�.(������ �׷� �� x)
select first_name, first_name from employees;   

-- �����ؼ��� �����!
select first_name, length(first_name) from employees;   


create table zipcode  (
   seq                  NUMBER(10)                        not null,
   zipcode              VARCHAR2(50),
   sido                 VARCHAR2(50),
   gugun                VARCHAR2(50),
   dong                 VARCHAR2(50),
   bunji                VARCHAR2(50),
   constraint PK_ZIPCODE primary key (seq)
)

select count(*) from zipcode;

select * from tblAddressBook; --�ּҷ�
select * from tblComedian; --�ڹ̵��
select * from tblCountry; --��������
select * from tblDiary; --���̾
select * from tblHousekeeping; --�����
select * from tblInsa; --��������
select * from tblMen; --����
select * from tblWomen; --����
select * from tblTodo; --����
select * from tblZoo; --����






