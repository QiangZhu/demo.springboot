package rabbitmq.ha.producer;

import java.util.Random;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import rabbitmq.ha.domain.Order;
import rabbitmq.ha.domain.OrderType;


@SpringBootApplication
public class Sender {
	
	private static Logger logger = LoggerFactory.getLogger(Sender.class);
	private static final int TEST_COUNT = 10;
	private static final String QUEUE_NAME = "rabbitmq-ha";
	
	@Autowired
	RabbitTemplate template;

	@PostConstruct
	public void send() {
		for (int i = 0; i < TEST_COUNT; i++) {
			int id = new Random().nextInt(TEST_COUNT);
			template.convertAndSend(QUEUE_NAME,new Order(id, "TEST"+id, OrderType.values()[(id%2)]));
		}
		logger.info("Sending completed.");
	}
	
	@Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        //connectionFactory.setAddresses("Centos67161:5672,Centos67162:5672,Centos67163:5672");
        connectionFactory.setAddresses("192.168.153.27:30000,192.168.153.27:30002,192.168.153.27:30004,");
        return connectionFactory;
    }
    
    @Bean
    public RabbitTemplate template() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        //rabbitTemplate.setExchange("q.example");
        return rabbitTemplate;
    }
    
    public static void main(String[] args) {
		SpringApplication.run(Sender.class, args);
	}

}
