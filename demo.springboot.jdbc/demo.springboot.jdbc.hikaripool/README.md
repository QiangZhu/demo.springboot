#使用hikari连接池
mvn clean package -Dmaven.test.skip=true

java -jar ./target/demo.springboot.jdbc.hikaripool-0.0.1-SNAPSHOT.jar

http://localhost:8080/myspringboot/stu/list