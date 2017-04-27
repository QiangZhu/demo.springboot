package com.yixin;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum UtilEnum {
	
	INSTANCE;
	
	private final static Map<String,String> names = new ConcurrentHashMap<>();
	
	public Map<String,String> getNames(){
		return names;
	}

}
