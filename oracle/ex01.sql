
-- ���϶��� �ּ� (Ctrl + /)

/*
    ���߶��� �ּ�
*/

alter user hr account unlock;   --���� Ǯ��
alter user hr account lock;      --���� ��ױ�

alter user hr identified by java1234; --��ȣ �ٲٱ�

--���� ������ �����ϰ� �ִ� ���̺� ��� ��������
select * from tabs;

--���� �ۼ����� ���� > ��ũ��Ʈ ����(*.sql)
-- *** ��ũ��Ʈ ������ ������ ���������̴�. > ������ �������̴�.
-- *** ��ũ��Ʈ ������ ������ ����� ���� ���°� ���������� �߿��ϴ�.

-- �Ķ��� > Ű����
-- ������ > �ĺ���
select * from REGIONS;      --�μ� ���� ���� ��� ����
select * from COUNTRIES;    --�μ� ���� ���� ����
select * from LOCATIONS;    --�μ� ���� ����
select * from DEPARTMENTS;  --�μ� ����
select * from JOBS;         --���� ���� ����
select * from EMPLOYEES;    --���� ����
select * from JOB_HISTORY;  --

select * from tabs; --������ �̰ɷ�..

SELECT * FROM TABS;

select * from TABS;

SELECT * FROM tabs; --FM (Ű����� �빮��, �ĺ��ڴ� ������)
