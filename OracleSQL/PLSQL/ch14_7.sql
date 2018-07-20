set serveroutput on
declare
	dan	number := 2;
	i number := 1;
begin
	for dan in 2 .. 9 loop
		for i in 1 .. 9 loop
			dbms_output.put_line( dan || ' * ' || i || ' = ' || (dan * i) );
		end loop;
		dbms_output.put_line('');
	end loop;	
end;
/