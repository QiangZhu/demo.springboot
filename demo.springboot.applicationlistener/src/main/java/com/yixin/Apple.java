/**
 * 2017年4月28日
 * zq
 */
package com.yixin;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * Package : com.yixin
 * 
 * @author YixinCapital -- zq
 *		   2017年4月28日 上午9:58:42
 *
 */
@Lazy(false)
@Component
public class Apple extends Fruit  implements InitializingBean{
	
	
	private String name;

	/**
	 * 
	 * @return 
	 * @author YixinCapital -- zq
	 *	       2017年4月28日 上午9:58:42
	 */
	@Override
	protected String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	/**
	 * 
	 * @param name
	 * @return 
	 * @author YixinCapital -- zq
	 *	       2017年4月28日 上午9:58:42
	 */
	@Override
	protected void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		UtilEnum.INSTANCE.load(this);
	}

}
