package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.Aspect;

import org.springframework.stereotype.Service;
import com.springbook.biz.user.UserVO;


@Service
@Aspect
public class AfterReturningAdvice {

	
	
	@AfterReturning(pointcut="Pointcut.Common.getPointcut()", returning="returnObj")
	public void afterLog(JoinPoint jp, Object returnObj){
		
		String method = jp.getSignature().getName();
		
		if(returnObj instanceof UserVO){
			UserVO user = (UserVO) returnObj;
			if(user.getRole().equals("Admin")){
				System.out.println(user.getName() +" 로그인(Admin)");
			}
			
		}
		
		System.out.println("[사후 처리] "+ method +"()메서드 리터ㅓㄴ값 : "+returnObj.toString());
	}
	
}
