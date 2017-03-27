/**
 * 2017年3月17日
 * zq
 */
package demo.springboot.web.init.sample1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 项目服务启动的时候就去加载一些数据或做一些事情这样的需求
 * 通过实现接口 CommandLineRunner 来实现
 * 利用@Order注解（或者实现Order接口）来规定所有CommandLineRunner实例的运行顺序
 * Package : demo.springboot.web.init.sample1
 * 
 * @author YixinCapital -- zq
 *		   2017年3月17日 下午7:40:23
 *
 */
@Component
@Order(value=2)
public class MyStartupRunner1 implements CommandLineRunner {

	/**
	 * 
	 * @param args
	 * @throws Exception 
	 * @author YixinCapital -- zq
	 *	       2017年3月17日 下午7:40:23
	 */
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MyStartupRunner1 服务启动执行，执行加载数据等操作");
	}

}
