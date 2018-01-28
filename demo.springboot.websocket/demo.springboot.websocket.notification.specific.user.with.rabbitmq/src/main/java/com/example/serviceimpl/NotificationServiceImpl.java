package com.example.serviceimpl;

import com.example.dto.NotificationDto;
import com.example.service.NotificationService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by zhuqiang on 2018-01-27.
 */
@Service("notificationService")
public class NotificationServiceImpl implements NotificationService {

	private static final String[] NAMES = {"tom","jerry"};

	@Override
	public NotificationDto message(){
		NotificationDto dto = new NotificationDto();
		String domainAccount  = NAMES[new Random().nextInt(9) % 2];
		dto.setDomainAccount(domainAccount);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dto.setContent(String.format("It's %s now, %s", sdf.format(new Date()), domainAccount));
		return dto;
	}
}
