package sample01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component //new 클래스하면 생성자 호출한다
//@ComponentScan("spring.conf")
public class MessageBeanImpl implements MessageBean {
	private String fruit;
	private int cost, qty;
	
	//클래스에서 기본생성자는 자동 호출된다. 단, 클래스 안에 생성자가 1개도 없을 때만 호출된다
	//public MessageBeanImpl() {
	//	System.out.println("MessageBeanImpl 기본 생성자");
	//}

	//Constructor Injection
	public MessageBeanImpl(@Value("딸기") String fruit) {
		this.fruit = fruit;
	}
	
	//Setter Injection
	@Autowired //세터는 강제 호출이 안되므로, @Component로 설정된 클래스 안에서 자동으로 세터 매핑
	public void setCost(@Value("12000") int cost) {
		this.cost = cost;
	}
	@Autowired
	public void setQty(@Value("5") int qty) {
		this.qty = qty;
	}

	@Override
	public void sayHello() {
		System.out.println(fruit +"\t"+ cost +"\t"+ qty);
	}

	@Override
	public void sayHello(String fruit, int cost) {
		System.out.println(fruit +"\t"+ cost +"\t"+ qty);
	}

	@Override
	public void sayHello(String fruit, int cost, int qty) {
		System.out.println(fruit +"\t"+ cost +"\t"+ qty);
	}

}
