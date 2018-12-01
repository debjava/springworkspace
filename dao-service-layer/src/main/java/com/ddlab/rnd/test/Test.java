package com.ddlab.rnd.test;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ddlab.rnd.entity.UserEntity;
import com.ddlab.rnd.service.IUserService;
import com.ddlab.rnd.service.impl.Singleton;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
//		IUserService userService = (IUserService) context.getBean("userService");
//		UserEntity userEntity = new UserEntity("Deba1");
//		userService.save(userEntity);
//		
//		List<UserEntity> usersList = (List<UserEntity>) userService.getAll();
//		for(UserEntity user : usersList) {
//			System.out.println(user.getId()+"---->"+user.getName());
//		}
//		
//		UserEntity user1 = userService.getById(1L);
//		System.out.println("User Name :::"+user1.getName());
		
		
		
		Singleton sing1 = (Singleton) context.getBean("singleton");
		int counter = sing1.getCounter();
		counter++;
		sing1.setCounter(++counter);
		System.out.println("Sing1 Counter---->"+sing1.getCounter());
		
		
		Singleton sing2 = (Singleton) context.getBean("singleton");
		System.out.println("Sing2 counter----->"+sing2.getCounter());
		
		if( sing1 == sing2 ) {
			System.out.println("They are the same instance..");
		}
		
		
		
		
	}
}
