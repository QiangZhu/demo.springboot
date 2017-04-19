package rabbitmq.ha.consumer;


import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import rabbitmq.ha.domain.Order;

@EnableRabbit
@SpringBootApplication
public class Listener {
	
	@Value("${spring.rabbitmq.addresses}")
	private String springRabbitmqAddresses;

	@Value("${spring.rabbitmq.username}")
	private String springRabbitmqUsername;

	@Value("${spring.rabbitmq.password}")
	private String springRabbitmqPassword;
	
	private static final String QUEUE_NAME = "rabbitmq-ha";
	private static Logger logger = LoggerFactory.getLogger(Listener.class);
	private static AtomicLong total = new AtomicLong();

	@RabbitListener(queues = QUEUE_NAME)
	public void onMessage(Order order) {
		logger.info(String.format("[received message:%d]%s",total.incrementAndGet(),order.toString()));
	}

	@Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
		connectionFactory.setAddresses(springRabbitmqAddresses);
		connectionFactory.setUsername(springRabbitmqUsername);
		connectionFactory.setPassword(springRabbitmqPassword);
		connectionFactory.setChannelCacheSize(10);
		return connectionFactory;
	}

	@Bean
	public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory() {
		SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory());
		factory.setConcurrentConsumers(10);
		factory.setMaxConcurrentConsumers(20);
		return factory;
	}

	@Bean
	public Queue queue() {
		return new Queue(QUEUE_NAME);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Listener.class, args);
	}

}
