package com.example.serviceimpl;

import com.example.dto.NotificationDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by zhuqiang on 2018-01-28.
 */
@Service("rabbitMqReceiver")
public class RabbitMqReceiver  implements ChannelAwareMessageListener {

	protected  final Logger log = LoggerFactory.getLogger(RabbitMqReceiver.class);
	@Autowired
	private SimpMessagingTemplate messageTemplate;

	@Override
	public void onMessage(Message message, Channel channel) throws Exception {

		String result = new String(message.getBody());
		log.info("从rabbitMQ队列,接收到消息：{}",  result);
		if (!result.isEmpty()) {
			ObjectMapper mapper = new ObjectMapper();
			NotificationDto dto = mapper.readValue(result, NotificationDto.class);
			messageTemplate.convertAndSendToUser(dto.getDomainAccount(), "/greetings", result);
		}
	}
}
