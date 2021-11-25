package sample01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;

//Target 중복 코드가 삽입되는 클래스, 핵심 기능이 담긴 클래스
//@Component
public class MessageBeanImpl implements MessageBean {
	private String str;
	
	@Autowired
	public void setStr(@Value("It gets better!!") String str) {
		this.str = str;
	}

	@Override
	public void showPrintBefore() { //Joinpoint 부가기능 적용 가능, Pointcut 실제로 부가기능을 적용
		System.out.println("showPrintBefore = " + str);
	}

	@Override
	public void viewPrintBefore() { //Joinpoint, Pointcut 
		try {
			Thread.sleep(1000); //단위 1/1000초, CPU 쉬어라
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("viewPrintBefore = " + str);
	}

	@Override
	public void showPrintAfter() { //Joinpoint, Pointcut
		System.out.println("showPrintAfter = " + str);
		
	}

	@Override
	public void viewPrintAfter() { //Joinpoint, Pointcut
		try {
			Thread.sleep(1000); //단위 1/1000초, CPU 쉬어라
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("viewPrintAfter = " + str);
		
	}

	@Override
	public String showPrint() { //Joinpoint, Pointcut
		System.out.println("showPrint = " + str);
		return "어제보다 나은 오늘, 오늘보다 나은 내일!";
		
	}

	@Override
	public void viewPrint() { //Joinpoint, Pointcut
		try {
			Thread.sleep(1000); //단위 1/1000초, CPU 쉬어라
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("viewPrint = " + str);
		
	}
	
	@Override
	public void display() { //Joinpoint 
		System.out.println("display = " + str);
	}

}
