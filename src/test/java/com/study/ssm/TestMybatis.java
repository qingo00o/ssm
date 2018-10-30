package com.study.ssm;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.study.ssm.model.User;
import com.study.ssm.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class) //表示继承了SpringJUnit4ClassRunner的类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TestMybatis {

	private static Logger logger=Logger.getLogger(TestMybatis.class);
	private ApplicationContext ac=null;
	@Resource
	private UserService userService=null;
	
	@Before
	public void before() {
		ac=new ClassPathXmlApplicationContext("spring-mybatis.xml");
		userService = (UserService) ac.getBean("userService");
	}
	@Test
	public void test1() {
		User user=userService.getUserById(1);
		
		System.out.println(user.getUserName());
	}
}
