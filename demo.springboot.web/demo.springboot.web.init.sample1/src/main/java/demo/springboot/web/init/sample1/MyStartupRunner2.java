/**
 * 2017年3月17日
 * zq
 */
package demo.springboot.web.init.sample1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Package : demo.springboot.web.init.sample1
 * 
 * @author YixinCapital -- zq
 *		   2017年3月17日 下午7:42:36
 *
 */
@Component
@Order(value=1)
public class MyStartupRunner2 implements CommandLineRunner {

	/**
	 * 
	 * @param args
	 * @throws Exception 
	 * @author YixinCapital -- zq
	 *	       2017年3月17日 下午7:42:36
	 */
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MyStartupRunner2 服务启动执行，执行加载数据等操作");
	}

}
