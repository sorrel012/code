
-- ���̺� ����

-- ���� �ڵ� ������
-- - ��ü ���� > ��ü ���ξ� ���
create table tblType (

--    num number
--    num number(3)
--    num number(4,2)

    txt1 char(10),
    txt2 varchar2(10)    

);

-- ���̺� ����
drop table tblType;

-- ���̺��� �����Ǿ����� Ȯ���ϴ� ���
-- 1. SQL ��ɾ� > ��� ���� �����ϰ� ����
select * from tabs;

--2. ������ ����� �ٸ�


-- ������ �߰��ϱ�
insert into tblType (num) values (100);
insert into tblType (num) values (200);
insert into tblType (num) values (300);

insert into tblType (num) values (3.14); --�Ǽ��� ���ͷ�

insert into tblType (num) values (-100);

insert into tblType (num) values (1000);

insert into tblType (num) values (9.9);

insert into tblType (num) values (999);
insert into tblType (num) values (-999);

insert into tblType (num) values (3.14);
insert into tblType (num) values (3.142);
insert into tblType (num) values (3.149);

insert into tblType (num) values (99.99);
insert into tblType (num) values (-99.99);


insert into tblType (txt1) values ('A'); --���ڿ� ���ͷ�

--10����Ʈ > �� ���� ? > ����Ŭ ���ڵ� > UTF-8 > ����(1), �ѱ�(3)
insert into tblType (txt1) values ('ABCDEFGHUJ');
insert into tblType (txt1) values ('ABCDEFGHUJK'); --�����÷ο�

insert into tblType (txt1) values ('��');
insert into tblType (txt1) values ('������');
insert into tblType (txt1) values ('�����ٶ�'); --�����÷ο�

insert into tblType (txt1, txt2) values('ABC', 'ABC');


-- ������ Ȯ��
--1. 
select * from tblType;

-- ���� �ð�
select sysdate from dual;