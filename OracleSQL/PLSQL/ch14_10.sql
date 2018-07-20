set serveroutput on
declare
	v_dept	department%rowtype;
	cursor c1
		is
		select * from department;
begin
	dbms_output.put_line('사원번호		사원이름		지역명');
	dbms_output.put_line('-----------------------------------------------');

	for v_dept in c1 loop
		exit when c1 %notfound;
		dbms_output.put_line(v_dept.dno || '			' || 
							v_dept.dname || '			' ||
							v_dept.loc);
	end loop;
end;
/