# 说明

    1. 资源路径的默认值；(application.properties or application.yml)
    
    2. 其中默认配置的 /** 映射到 /static （或/public、/resources、/META-INF/resources）
    
    3. 其中默认配置的 /webjars/** 映射到 classpath:/META-INF/resources/webjars/ 
    
       上面的 static、public、resources 等目录都在 classpath下（如 src/main/resources/static）
       优先级顺序为：META/resources > resources > static > public 

# 自定义资源映射
   1. 使用类路径
   2. 使用绝对路径 

# 注意事项
  如果想要自己完全控制WebMVC，就需要在@Configuration注解的配置类上增加@EnableWebMvc @SpringBootApplication 注解的程序入口类已经包含@Configuration），增加该注解以后WebMvcAutoConfiguration中配置就不会生效，你需要自己来配置需要的每一项。这种情况下的配置还是要多看一下WebMvcAutoConfiguration类.
