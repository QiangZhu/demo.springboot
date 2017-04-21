package rabbitmq.ha.producer;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import rabbitmq.ha.domain.Order;
import rabbitmq.ha.domain.OrderType;

@SpringBootApplication
public class Sender {
	
	
	@Value("${spring.rabbitmq.queuename}")
	private String springRabbitmqQueueName;
	
	@Value("${spring.rabbitmq.exchangename}")
	private String springRabbitmqExchangeName;

	@Value("${test.rabbitmq.count}")
	private int testRabbitmqCount;
	
	@Value("${test.rabbitmq.sleeptime}")
	private int testRabbitmqSleeptime;
	
	@Value("${test.rabbitmq.expired}")
	private int testRabbitmqExpired;
	
	@Autowired
	RabbitTemplate template;

	private static Logger logger = LoggerFactory.getLogger(Sender.class);
	private static AtomicLong increment = new AtomicLong();
	private static final Random random = new Random();
	private static final int DEFAULT_STEEPTIME_MILLISECONDS = 1000;
	private static final long start = System.currentTimeMillis();
	
	@Bean
	Queue queue() {
		return new Queue(springRabbitmqQueueName, false);
	}
	
	@Bean
	TopicExchange exchange() {
		return new TopicExchange(springRabbitmqExchangeName);
	}
	
	@Bean
	Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(springRabbitmqQueueName);
	}
	
	private void execute(){
		int id = random.nextInt(testRabbitmqCount <= 0 ? Integer.MAX_VALUE : testRabbitmqCount);
		template.convertAndSend(springRabbitmqQueueName, new Order(increment.incrementAndGet(), UUID.randomUUID().toString(),
				"TEST" + String.valueOf(id), OrderType.values()[(id % 2)]));
	}

	@PostConstruct
	public void send() {
		if(testRabbitmqCount <= 0 ){
			while(true){
				if(System.currentTimeMillis() > start + testRabbitmqExpired){
					break;
				}
				execute();
				logger.info(String.format("[send rabbitmq message ] id : %d", increment.get()));
				try {
					Thread.sleep(testRabbitmqSleeptime <= 0 ? DEFAULT_STEEPTIME_MILLISECONDS : testRabbitmqSleeptime);
				} catch (InterruptedException e) {
					logger.error("found exception ", e);
				}
			}
		}else{
			for (int i = 0; i < testRabbitmqCount; i++) {
				execute();
			}
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(Sender.class, args).close();
		logger.info(String.format("[send rabbitmq message completed] total : %d", increment.get()));
	}

}
