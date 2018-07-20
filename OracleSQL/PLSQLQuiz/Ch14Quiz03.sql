set serveroutput on
declare
	buffer number := 0;
begin
	for i in 1 .. 10 loop
		if i > 10 then
			exit;
		end if;
		
		buffer := buffer + i;	
		
	end loop;
	dbms_output.put_line( '1부터 10 사이 합(1~9) : ' || buffer);
end;
/