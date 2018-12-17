# -*- coding: utf-8 -*-
"""
Created on Tue Dec 11 13:11:04 2018

@author: kosmo
"""

import cx_Oracle as cx

host_name = 'localhost'
oracle_port = 1521
service_name = 'XE'
dsn_tns = cx.makedsn(host_name, oracle_port, service_name)
conn = cx.connect('scott', 'tiger', dsn_tns)

cursor = conn.cursor()
sql = 'SELECT * from employee where job >= :job111'

for result in cursor.execute(sql, job111='MANAGER'):
    print(result)

cursor.close()
conn.close()