/**
 * 2017年3月15日
 * zq
 */
package com.yixin.demo.springboot.logback.trace;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Package : com.yixin.demo.springboot.logback.trace
 * 
 * @author YixinCapital -- zq
 *		   2017年3月15日 下午3:24:12
 *
 */
public class LogTrace {
	
	private static final Logger logger = LoggerFactory.getLogger(LogTrace.class);
	
	public static void logTest(){
		logger.debug("LogTrace日志输出测试 Debug");
	    logger.trace("LogTrace日志输出测试 Trace");
	    logger.info("LogTrace日志输出测试 Info");
	    logger.warn("LogTrace日志输出测试warn");
	    logger.error("LogTrace日志输出测试error");
	}

}
