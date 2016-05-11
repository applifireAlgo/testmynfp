




echo $PATH
DB_PATH=/tmp/applifire/db/TM54QOGKFKLCDDESLNURKQ/18D01ABF-F632-496A-B379-FC50EDEAB8C0
MYSQL=/usr/bin
USER=test2
PASSWORD=test2
HOST=localhost


echo 'drop db starts....'
$MYSQL/mysql -h$HOST -u$USER -p$PASSWORD -e "SOURCE $DB_PATH/drop_db.sql";
echo 'drop db ends....'