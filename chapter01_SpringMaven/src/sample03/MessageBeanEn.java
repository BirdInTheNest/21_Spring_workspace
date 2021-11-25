package sample03;

import org.springframework.stereotype.Component;

//@Component("messageBean") //메모리에 생성
public class MessageBeanEn implements MessageBean {

	@Override
	public void sayHello(String name) {
		System.out.println("Hello "+name+"!!");
	}

}
