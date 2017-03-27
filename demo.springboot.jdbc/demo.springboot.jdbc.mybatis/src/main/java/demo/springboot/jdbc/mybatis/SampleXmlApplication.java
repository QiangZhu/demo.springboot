/**
 * 2017年3月20日
 * zq
 */
package demo.springboot.jdbc.mybatis;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import demo.springboot.jdbc.mybatis.application.HotelMapper;
import demo.springboot.jdbc.mybatis.application.impl.CityServiceImpl;

/**
 * Package : demo.springboot.jdbc.mybatis
 * 
 * @author YixinCapital -- zq 2017年3月20日 下午5:21:48
 *
 * @see https://github.com/mybatis/spring-boot-starter/tree/master/mybatis-spring-boot-samples
 *
 */
@SpringBootApplication
public class SampleXmlApplication implements CommandLineRunner {

	/**
	 * 
	 * @param args
	 * @author YixinCapital -- zq 2017年3月20日 下午5:21:48
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(SampleXmlApplication.class, args);
	}

	private final CityServiceImpl cityService;

	private final HotelMapper hotelMapper;

	public SampleXmlApplication(CityServiceImpl cityService, HotelMapper hotelMapper) {
		this.cityService = cityService;
		this.hotelMapper = hotelMapper;
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(this.cityService.selectCityById(1));
		System.out.println(this.hotelMapper.selectByCityId(1));
	}
}
