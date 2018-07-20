set serveroutput on
declare
	buffer number := 0;
	i number := 0;
begin
	while i <= 10 loop
	
		i := i + 1;
		
		if i > 10 then
			exit;
		end if;
		
		buffer := buffer + i;		
		
	end loop;
	dbms_output.put_line( '1부터 10 사이 합(1~9) : ' || buffer);
end;
/