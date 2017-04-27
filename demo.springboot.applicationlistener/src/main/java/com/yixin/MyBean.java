package com.yixin;

import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy(false)
@Component
public class MyBean implements InitializingBean {
	
	private String name = "MyBean";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Map<String,String> name = UtilEnum.INSTANCE.getNames();
		name.put(MyBean.class.getName(), MyBean.class.getName());
	}
	
	

}
