--������, Operator

desc tblCountry;
select * from tblCountry;


select population, area, population + area
    from tblCountry;

select name || capital
    from tblCountry;

-- �÷��� > ������ �÷��� > �ùٸ� �̸����� ���� > �÷��� �ٲٱ� > ��Ī(Alias)
-- �ĺ��� "�÷���|�ٲ� �÷���"

select name as '�̸�';

drop table tblType;

create table tblType (
    num1 number,
    num2 varchar2(40)
);

insert into tblType (num1, num2) values (123, '123'); --���ڴ� ������ ����, ���ڿ��� ���� ����

select * from tblType;