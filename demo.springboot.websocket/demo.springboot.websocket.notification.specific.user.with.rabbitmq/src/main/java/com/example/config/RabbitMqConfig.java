package com.example.config;

import com.example.serviceimpl.RabbitMqReceiver;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.filter.CharacterEncodingFilter;

/**
 * Created by zhuqiang on 2018-01-28.
 */
@Configuration
public class RabbitMqConfig{
		// RabbitMQ的配置信息
		@Value("${spring.rabbitmq.host}")
		private String host;
		@Value("${spring.rabbitmq.port}")
		private String port;
		@Value("${spring.rabbitmq.username}")
		private String username;
		@Value("${spring.rabbitmq.password}")
		private String password;
		@Value("${spring.rabbitmq.virtual-host}")
		private String virtualHost;
		@Value("${spring.rabiitmq.websocket.exchange}")
		private String exchange;
		@Value("${spring.rabbitmq.websocket.builtinexchangetype}")
		private String builtinExchangeType;
		@Value("${srping.rabbitmq.websocket.routingkey}")
		private String routingKey;
		@Value("${srping.rabbitmq.websocket.queue}")
		private String queue;

		// 建立一个连接容器，类型数据库的连接池
		@Bean
		public ConnectionFactory connectionFactory() {
			CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
			connectionFactory.setHost(host);
			connectionFactory.setPort(Integer.parseInt(port));
			connectionFactory.setUsername(username);
			connectionFactory.setPassword(password);
			connectionFactory.setVirtualHost(virtualHost);
			connectionFactory.setPublisherConfirms(true);// 确认机制
			return connectionFactory;
		}

		@Bean
		@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
		public AmqpTemplate rabbitTemplate() {
			RabbitTemplate template = new RabbitTemplate(this.connectionFactory());
			template.setMessageConverter(this.jsonMessageConverter());
			template.setMandatory(true);
			return template;
		}

		/**
		 * 交换机 针对消费者配置 FanoutExchange: 将消息分发到所有的绑定队列，无routingkey的概念 HeadersExchange ：通过添加属性key-value匹配
		 * DirectExchange:按照routingkey分发到指定队列 TopicExchange:多关键字匹配
		 */
		@Bean
		public DirectExchange directExchange() {
			return new DirectExchange(exchange);
		}

		/**
		 * 队列
		 *
		 * @return
		 */
		@Bean
		public Queue queueReceive() {
			return new Queue(queue, true); // 队列持久
		}

		/**
		 * 绑定
		 *
		 * @return
		 */
		@Bean
		public Binding binding() {
			return BindingBuilder.bind(queueReceive()).to(directExchange())
					.with(routingKey);
		}

		@Bean
		public MessageConverter jsonMessageConverter() {
			return new Jackson2JsonMessageConverter();
		}

		@Bean
		MessageListenerAdapter listenerAdapter(RabbitMqReceiver receiver) {
			return new MessageListenerAdapter(receiver, "onMessage");
		}

		@Bean
		public SimpleMessageListenerContainer messageListenerContainer(
				MessageListenerAdapter listenerAdapter) {
			SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
			container.setConnectionFactory(connectionFactory());
			container.setQueueNames(queue);
			container.setExposeListenerChannel(true);
			container.setMaxConcurrentConsumers(1);
			container.setConcurrentConsumers(1);
			container.setAcknowledgeMode(AcknowledgeMode.AUTO); // 设置确认模式手工确认
			container.setMessageListener(listenerAdapter);
			container.setDefaultRequeueRejected(false);
			return container;
		}

		@Bean
		public CharacterEncodingFilter characterEncodingFilter() {
			CharacterEncodingFilter filter = new CharacterEncodingFilter();
			filter.setEncoding("UTF-8");
			filter.setForceEncoding(true);
			return filter;
		}


}
