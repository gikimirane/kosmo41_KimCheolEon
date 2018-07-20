set serveroutput on
declare
	dan	number := 2;
	i number := 1;
begin
	while dan <= 9 loop
		while i <= 9 loop		
			dbms_output.put_line( dan || ' * ' || i || ' = ' || (dan * i) );
			i := i + 1;
		end loop;
		dbms_output.put_line('');
		i := 1;
		dan := dan + 1;
	end loop;
	
end;
/