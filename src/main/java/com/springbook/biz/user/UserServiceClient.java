package com.springbook.biz.user;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.biz.user.impl.UserService;

public class UserServiceClient {
	public static void main(String[] args) {
		
		//1. Spring 컨테이너를 구동하낟.
		AbstractApplicationContext container =
				new GenericXmlApplicationContext("applicationContext.xml");
		
		//2. Spring 컨테이너로 붙터 UserServiceImpl 객체를 LookUp 한다.
		
		UserService userServcie = (UserService) container.getBean("userService");
		
		
		//3. 로그인 기능 테스트
		UserVO vo = new UserVO();
		vo.setId("test");
		vo.setPassword("test123");
		
		UserVO user = userServcie.getUser(vo);
		if(user != null){
			System.out.println(user.getName()+"님 환영합니다");
		}else{
			System.out.println("로그인 ㅣㄹ패");
		}
		
		
		//4. 스프링컨ㄴ테이너종료
		container.close();
		
	}
}
