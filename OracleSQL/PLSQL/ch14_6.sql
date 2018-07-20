set serveroutput on
declare
	dan	number := 2;
	i number := 1;
begin
	loop
		loop
			dbms_output.put_line( dan || ' * ' || i || ' = ' || (dan * i) );
			i := i + 1;
			if i > 9 then
				i := 1;
				exit;
			end if;
		end loop;
		dbms_output.put_line('');
		dan := dan + 1;
		if dan > 9 then
			exit;
		end if;
	end loop;
end;
/