#wait for the SQL Server to come up
sleep 30s

echo "running set up script"
#run the setup script to create the DB and the schema in the DB
/opt/mssql-tools/bin/sqlcmd -S localhost -U sa -P Secret1234 -d master -i /var/opt/mssql/init/DDLDatabase.sql

echo "create table finish"

/opt/mssql-tools/bin/sqlcmd -S localhost -U sa -P Secret1234 -d osama_raccolta_dati -i /var/opt/mssql/init/dump.sql

echo "insert data finish"
