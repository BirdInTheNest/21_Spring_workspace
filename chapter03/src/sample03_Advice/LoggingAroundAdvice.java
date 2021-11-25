package sample03_Advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggingAroundAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		//공통모듈, 부가기능
		System.out.println("Around --- 입실체크");
		long start = System.currentTimeMillis(); //현재시간을 저장하여 수행 시간 계산
		
		Object ob = invocation.proceed(); //proceed로 핵심 사항 호출
		
		//공통모듈, 부가기능
		long end = System.currentTimeMillis();
		System.out.println((end - start)/1000 + "초");
		System.out.println("Around --- 퇴실체크");
		
		return ob;
	}

}
