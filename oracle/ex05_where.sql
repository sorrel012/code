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
