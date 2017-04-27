/**
 * 2017年4月27日
 * zq
 */
package com.yixin;

import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * Package : com.yixin
 * 
 * @author YixinCapital -- zq
 *		   2017年4月27日 下午8:07:55
 *
 */
public class MyApplicationListener implements ApplicationListener<ApplicationEvent> {

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		Map<String,String> names = UtilEnum.INSTANCE.getNames();
		for(Entry<String, String> entry : names.entrySet()){
			System.out.println("--------------------->"+entry.getKey() + ":" + entry.getValue());
		}
		
	}

}
