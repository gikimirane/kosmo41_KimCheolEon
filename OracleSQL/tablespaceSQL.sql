drop tablespace KOSMO41 including contents;

SELECT TABLESPACE_NAME, STATUS, CONTENTS FROM DBA_TABLESPACES;

create tablespace KOSMO41
datafile 'c:\oraclexe\oradata\kosmo41.dbf' size 500M
default storage
(
  INITIAL    10K
  NEXT      10K
  MINEXTENTS 2
  MAXEXTENTS 50
  PCTINCREASE 50
);