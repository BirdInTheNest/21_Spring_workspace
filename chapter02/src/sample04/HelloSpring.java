package sample04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		System.out.println("*** Life Cycle ***"); //생성자 먼저 처리, ref 처리, 세터 순서대로 처리
		System.out.println();
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//MessageBean messageBean = context.getBean("messageBeanImpl2", MessageBean.class);
		MessageBean messageBean = (MessageBean) context.getBean("messageBeanImpl2");
		messageBean.helloCall();
	}

}
