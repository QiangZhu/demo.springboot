package com.example.controller;

import com.example.dto.NotificationDto;
import com.example.service.NotificationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

/**
 * Created by zhuqiang on 2018-01-27.
 */
@Controller
public class NotificationController {

	protected  final Logger logger = LoggerFactory.getLogger(NotificationController.class);

	@Autowired
	private SimpMessagingTemplate messageTemplate;
	@Autowired
	private NotificationService noti1ficationService;

	@Scheduled(fixedDelay = 2000)
	public void message() throws JsonProcessingException {
		NotificationDto dto = noti1ficationService.message();
		logger.info("message : {}",dto);
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writeValueAsString(dto);
		messageTemplate.convertAndSendToUser(dto.getDomainAccount(),"/greetings", jsonInString);
	}
}
