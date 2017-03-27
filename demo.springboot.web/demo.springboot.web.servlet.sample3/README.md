#自定义URLMapping后缀
mvn clean package -Dmaven.clean.skip=true

java -jar ./target/demo.springboot.web.servlet.sample3-0.0.1-SNAPSHOT.jar

http://localhost:8080/echo

http://localhost:8080/echo.do

http://localhost:8080/echo.json