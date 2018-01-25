package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import com.springbook.biz.user.UserVO;

@Service
@Aspect
public class AfterReturningAdvice {
	
	@AfterReturning(pointcut="PointcutCommon.getPointcut()", returning="returnedObj")
	public void afterLog(JoinPoint jp, Object returnedObj) {
		
		String method = jp.getSignature().getName();
		
		if(returnedObj instanceof UserVO) {
			UserVO user = (UserVO)returnedObj;
			if(user.getRole().equals("Admin")) {
				System.out.println(user.getName() + " �α���(Admin)");
			}
		}
		
		System.out.println("[���� ó��] " + method + "() �޼ҵ� ���ϰ�: " + returnedObj.toString());
	}
}