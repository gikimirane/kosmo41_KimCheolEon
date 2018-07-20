set serveroutput on
declare
	v_dno employee.dno%type;
	v_dname department.dname%type;
begin
	select dno into v_dno
	from employee
	where ename = 'KING';
	
	if( v_dno = 10 ) then
		v_dname := 'ACCOUNTING';
	elsif( v_dno = 20 ) then
		v_dname := 'RESEARCH';
	elsif( v_dno = 30 ) then
		v_dname := 'SALES';
	elsif( v_dno = 40 ) then
		v_dname := 'OPERATIONS';
	end if;
	
	dbms_output.put_line('부서번호		부서명');
	dbms_output.put_line('----------------------------------');	
	dbms_output.put_line(v_dno || '				' || v_dname);
end;
/