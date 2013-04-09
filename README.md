healthcare
==========

1. Run MinaServer
---mvn assembly:assembly
---target directory
java -cp healthcare-jar-with-dependencies.jar com.fengtuo.healthcare.server.MinaServer

2. Delete all records
http://localhost:8080/healthcare/realTimeData/deleteAllRecords?password=111111