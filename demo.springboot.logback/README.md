# demo.springboot.logback
SpringBoot Logback Demo
测试注意事项


        1.单独使用application.properties简单配置时，请移除logback.xml,logback-spring.xml防止干扰结果
        2.使用logback-spring.xml进行个性化配置是，请务必移除logback-spring.xml防止干扰结果
        3.使用logback-spring.xml进行logback profile配置时，请务必移除logback.xml防止干扰结果


使用spring扩展profile支持注意事项：

    1. 要以logback-spring.xml命名
    2. src/main/resources 目录下不能包括logback.xml
    3. 使用如下命令在运行期指定使用的日志的profile
    
       java -jar ./target/demo.springboot.logback-0.0.1-SNAPSHOT.jar --spring.profiles.active=pro
