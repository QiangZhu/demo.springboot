/**
 * 2017年3月15日
 * zq
 */
package com.yixin.demo.sprintboot.logback.info;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Package : com.yixin.demo.sprintboot.logback.info
 * 
 * @author YixinCapital -- zq
 *		   2017年3月15日 下午3:40:29
 *
 */
public class LogInfo {
	
	private static final Logger logger = LoggerFactory.getLogger(LogInfo.class);
	
	public static void logTest(){
		logger.debug("LogInfo日志输出测试 Debug");
	    logger.trace("LogInfo日志输出测试 Trace");
	    logger.info("LogInfo日志输出测试 Info");
	    logger.warn("LogInfo日志输出测试warn");
	    logger.error("LogTrace日志输出测试error");
	}

}
