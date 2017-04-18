package rabbitmq.ha.consumer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import rabbitmq.ha.domain.Order;

@EnableRabbit
@SpringBootApplication
public class Listener {
	
	private static final String QUEUE_NAME = "rabbitmq-ha";
	private static Logger logger = LoggerFactory.getLogger(Listener.class);
	private Long timestamp;

	public static void main(String[] args) {
		SpringApplication.run(Listener.class, args);
	}

	@RabbitListener(queues = QUEUE_NAME)
	public void onMessage(Order order) {
		if (timestamp == null)
			timestamp = System.currentTimeMillis();
		logger.info((System.currentTimeMillis() - timestamp) + " : " + order.toString());
	}

	@Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
		connectionFactory.setUsername("guest");
		connectionFactory.setPassword("guest");
		//connectionFactory.setAddresses("Centos67161:5672,Centos67162:5672,Centos67163:5672");
		connectionFactory.setAddresses("192.168.153.27:30000,192.168.153.27:30002,192.168.153.27:30004,");
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

}
