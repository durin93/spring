package com.springbook.biz.user;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.biz.user.impl.UserService;

public class UserServiceClient {
	public static void main(String[] args) {
		
		//1. Spring �����̳ʸ� �����ϳ�.
		AbstractApplicationContext container =
				new GenericXmlApplicationContext("applicationContext.xml");
		
		//2. Spring �����̳ʷ� ���� UserServiceImpl ��ü�� LookUp �Ѵ�.
		
		UserService userServcie = (UserService) container.getBean("userService");
		
		
		//3. �α��� ��� �׽�Ʈ
		UserVO vo = new UserVO();
		vo.setId("test");
		vo.setPassword("test123");
		
		UserVO user = userServcie.getUser(vo);
		if(user != null){
			System.out.println(user.getName()+"�� ȯ���մϴ�");
		}else{
			System.out.println("�α��� �Ӥ���");
		}
		
		
		//4. �������������̳�����
		container.close();
		
	}
}
