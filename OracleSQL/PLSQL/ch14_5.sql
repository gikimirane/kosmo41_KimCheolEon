set serveroutput on
declare
	v_eno employee.eno%type;
	v_ename employee.ename%type;
	v_dno employee.ename%type;
	v_dname	varchar2(20) := null;
begin
	select eno, ename, dno
	into v_eno, v_ename, v_dno
	from employee
	where ename = 'SCOTT';
	
	if( v_dno = 10 ) then
		v_dname := 'ACCOUNTING';
	elsif( v_dno = 20 ) then
		v_dname := 'RESEARCH';
	elsif( v_dno = 30 ) then
		v_dname := 'SALES';
	elsif( v_dno = 40 ) then
		v_dname := 'OPERATIONS';
	end if;
		
	dbms_output.put_line('사원번호		사원이름		부서명');
	dbms_output.put_line('----------------------------------------');	
	dbms_output.put_line(v_eno || '			' || 
						v_ename || '			' ||
						v_dname);
end;
/