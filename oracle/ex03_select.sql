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


