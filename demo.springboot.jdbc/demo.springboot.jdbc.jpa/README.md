mvm clean install -Dmaven.test.skip=true

java -jar ./target/demo.springboot.jdbc.jpa-0.0.1-SNAPSHOT.jar

http://localhost:8080/myspringboot/score/scoreList

POST /myspringboot/score/insert HTTP/1.1
Host: localhost:8080
Content-Type: application/json;charset=utf-8
Cache-Control: no-cache
Postman-Token: cec96406-8933-79b7-979e-ff0f0a4a3e0a

{"stuId":2,"subjectName":"maths","score":61.00,"examTime":"2017-03-20 07:35:52"}

