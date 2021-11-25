package sample03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		//스프링 환경설정파일을 읽어야 한다
		//ApplicationContext context = new FileSystemXmlApplicationContext("src/applicationContext.xml");
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		MessageBean messageBean = (MessageBean) context.getBean("messageBean"); //부모=자식
		messageBean.sayHello("Spring");
		System.out.println();
		
		MessageBean messageBean2 = context.getBean("messageBean", MessageBean.class); //bean 아이디값으로 가져옴
		messageBean.sayHello("Spring");
		System.out.println();
	
		MessageBean messageBean3 = context.getBean("messageBean", MessageBean.class);
		messageBean.sayHello("Spring");
		System.out.println();
	}

}
