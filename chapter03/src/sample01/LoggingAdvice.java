package sample01;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

//Aspect 공통관심사항(부가기능) - 중복되는 코드는 추출하여 따로 메소드를 만듭니다
public class LoggingAdvice { 
	public void beforeTrace() {
		System.out.println("beforeTrace");
	}
	
	public void afterTrace() {
		System.out.println("afterTrace");
	}
	
	public void trace(ProceedingJoinPoint joinPoint) {
		//삽입
		//System.out.println("beforeTrace");
		String methodName = joinPoint.getSignature().toShortString(); //호출된 메소드 이름
		System.out.println("메소드 = " + methodName);
		
		StopWatch sw = new StopWatch();
		sw.start(methodName);
		
		//핵심사항 호출, 핵심 코드가 언제 끝나는 지 알 수 없으므로 호출한다
		try {
			Object ob = joinPoint.proceed();
			System.out.println("핵심 코드 처리결과 = " + ob);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		sw.stop();
		System.out.println("핵심 코드 처리시간 = " + sw.getTotalTimeMillis()/1000 + "초");
		
		//삽입
		//System.out.println("afterTrace");
	}
	
}
