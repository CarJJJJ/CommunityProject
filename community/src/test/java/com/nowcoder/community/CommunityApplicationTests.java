package com.nowcoder.community;

import com.nowcoder.community.config.AlphaConfig;
import com.nowcoder.community.dao.AlphaDao;
import com.nowcoder.community.service.AlphaService;
import com.nowcoder.community.service.AlphaServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
class CommunityApplicationTests implements ApplicationContextAware {

	private ApplicationContext applicationContext;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext=applicationContext;
	}
	@Test
	public void testApplicationContext(){
		System.out.println(applicationContext);
		AlphaDao alphaDao = applicationContext.getBean(AlphaDao.class);
		System.out.println(alphaDao.select());
		AlphaDao alphaDao1 = applicationContext.getBean("Hibernate",AlphaDao.class);
		System.out.println(alphaDao1.select());
	}
	@Test
	public void testAlphaService(){
		AlphaService alphaService = applicationContext.getBean(AlphaService.class);
		AlphaService alphaService1 = applicationContext.getBean(AlphaService.class);
		System.out.println(alphaService);
		System.out.println(alphaService1);
	}
	@Test
	public void testConfig(){
		SimpleDateFormat simpleDateFormat = applicationContext.getBean("simpleDateFormat",SimpleDateFormat.class);
		System.out.println(simpleDateFormat.format(new Date()));
	}
	@Autowired
	private AlphaDao alphaDao;

	@Autowired
	@Qualifier("Hibernate")
	private AlphaDao alphaDao1;

	@Autowired
	private AlphaService alphaService;

	@Test
	public void testDI(){
		System.out.println(alphaDao);
		System.out.println(alphaDao1);
		System.out.println(alphaService);
	}
}
