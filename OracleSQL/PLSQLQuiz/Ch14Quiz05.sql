set serveroutput on
declare
	v_emp	employee%rowtype;
	cursor c1
		is
		select * from employee
		where commission is not null
		order by ename;
begin
	dbms_output.put_line('사원번호		사원이름		급여');
	dbms_output.put_line('----------------------------------------');	

	for v_emp in c1 loop
		exit when c1 %notfound;
			dbms_output.put_line(v_emp.eno || '			' || 
						v_emp.ename || '			' ||
						v_emp.salary);
	end loop;
end;
/