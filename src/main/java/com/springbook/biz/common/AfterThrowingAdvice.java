package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;


@Service
@Aspect
public class AfterThrowingAdvice {
	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	public void allPointCut(){}
	
	
	
	@AfterThrowing(pointcut="allPointCut()", throwing="exceptObj")
	public void exceptionLog(JoinPoint jp, Exception exceptObj){
	
		String method = jp.getSignature().getName();
	
		System.out.println("[���� ó��] " + method + "() �޼��� ���� �� �߻� �� ���� �޼��� : "+ exceptObj.getMessage());
		
		if(exceptObj instanceof IllegalArgumentException){
			System.out.println("�������� �����Էµ�");
		}else if(exceptObj instanceof NumberFormatException){
			System.out.println("���� ������ ���� �ƴմϴ�");
		}else if(exceptObj instanceof Exception){
			System.out.println("������ �߻��Ͽ����ϴ�");
		}
		
	}
}