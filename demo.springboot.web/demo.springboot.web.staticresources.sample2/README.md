#自定义类路径和绝对路径加载静态资源文件
#确保 D:/temp/myres/下有资源文件img.jpg
mvn clean package -Dmaven.test.skip=true

java -jar ./target/demo.springboot.web.staticresources-0.0.1-SNAPSHOT.jar

http://localhost:8080/newres/img.jpg

http://localhost:8080/newrew/img.png