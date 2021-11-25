package sample04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Calc calc;
		calc = context.getBean("calcAdd", Calc.class);
		calc.calculate(12,36);
		System.out.println();
		
		calc = context.getBean("calcMul", Calc.class);
		calc.calculate(12,36);
		System.out.println();
		
	}

}
