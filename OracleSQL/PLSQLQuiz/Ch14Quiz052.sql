set serveroutput on
declare
	v_employee employee%rowtype;
	temp number(4) := 1;
	annsal number(7, 2);
begin
	select * into v_employee
	from employee
	where ename = 'SCOTT';
	
	if( v_employee.commission is null ) then
		v_employee.commission := 0;
	end if;
	
	annsal := v_employee.salary * 12 + v_employee.commission;
	
	dbms_output.put_line('사원번호		사원이름		연봉');
	dbms_output.put_line('----------------------------------------');	
	dbms_output.put_line(v_employee.eno || '			' || 
						v_employee.ename || '			' ||
						annsal);
end;
/