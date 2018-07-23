create or replace procedure adjust (
    n in varchar2,
    rate in float )
is
    newpay float;
begin
    select pay into newpay from salary where name = n;
    
    newpay := newpay + newpay * rate;
    update salary set pay = newpay where name = n;
end;
/
