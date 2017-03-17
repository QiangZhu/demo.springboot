/**
 * 2017年3月15日
 * zq
 */
package com.yixin.demo.springboot.logback.debug;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Package : com.yixin.demo.springboog.logback.debug
 * 
 * @author YixinCapital -- zq
 *		   2017年3月15日 下午3:30:01
 *
 */
public class LogDebug {
	
	private static final Logger logger = LoggerFactory.getLogger(LogDebug.class);
	
	public static void logTest(){
		logger.debug("LogDebug日志输出测试 Debug");
	    logger.trace("LogDebug日志输出测试 Trace");
	    logger.info("LogDebug日志输出测试 Info");
	    logger.warn("LogDebug日志输出测试warn");
	    logger.error("LogDebug日志输出测试error");
	}

}
