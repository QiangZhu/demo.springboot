#tomcat jdbc pool
mvm clean install -Dmaven.test.skip=true

java -jar ./target/demo.springboot.jdbc.tomcatdbcppool.0.0.1-SNAPSHOT.jar

http://localhost:8080/stu/list