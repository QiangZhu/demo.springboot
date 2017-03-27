#使用编程的方式自定义Servlet
#匹配的优先级是从精确到模糊，复合条件的Servlet并不会都执行

mvn clean package -Dmaven.test.skip=true

java -jar ./target/demo.springboot.web.servlet.sample1-0.0.1-SNAPSHOT.jar

http://localhost:8080/xs/myServerlet

http://localhost:8080/xs/abc

