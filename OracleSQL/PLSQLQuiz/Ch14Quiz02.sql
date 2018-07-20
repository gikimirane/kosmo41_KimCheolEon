set serveroutput on
declare
	i number := 0;
	buffer number := 0;
begin
	loop
		i := i + 1;
			
		if i > 10 then
			exit;
		end if;
		
		buffer := buffer + i;	
		
	end loop;
	dbms_output.put_line( '1부터 10 사이 합(1~9) : ' || buffer);
end;
/