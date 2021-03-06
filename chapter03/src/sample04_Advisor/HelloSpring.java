package sample04_Advisor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext04.xml");
		MessageBean messageBean = context.getBean("proxy", MessageBean.class);
		messageBean.study();
		System.out.println("--------------");
		System.out.println("결과 = " + messageBean.game());
		System.out.println("--------------");
		messageBean.lesson(); //advisor에 끼지 못함
	}

}
