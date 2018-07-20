set serveroutput on
--off 하면 출력이 안됨?
declare
	v_eno	number(4); --스칼라 타입
	v_ename	employee.ename%type; --레퍼런스 타입
begin
	dbms_output.put_line('Hello Oracle!!');
	
	v_eno := 7788;
	v_ename := 'SCOTT';
	dbms_output.put_line('사원번호		사원이름');
	dbms_output.put_line('------------------------');
	dbms_output.put_line(v_eno || '			' || v_ename);
end;
/