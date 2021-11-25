package sample01;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

//@Data는 Setter, Getter, 기본생성자, toString, hashCode, equals 들어오기 때문에 기본생성자 충돌난다
@RequiredArgsConstructor //@NonNull 이 붙은 필드에 대해 생성자를 생성
public class MessageBeanImpl implements MessageBean {
	@NonNull
	private String fruit;
	
	@Setter
	private int cost, qty;
	
	//클래스에서 기본생성자는 자동 호출된다. 단, 클래스 안에 생성자가 1개도 없을 때만 호출된다
	public MessageBeanImpl() {
		System.out.println("MessageBeanImpl 기본 생성자");
	}

	/*
	//Constructor Injection 생성자를 통해서 의존 관계를 연결, <constructor-arg>를 추가
	
	public MessageBeanImpl(String fruit) {
		this.fruit = fruit;
	}
	
	//Setter Injection setter메소드를 이용하여 의존 관계를 연결
	//<property>요소의 name 속성을 이용하여 값의 의존 관계를 연결시킬 대상이 되는 필드값을 지정
	
	public void setCost(int cost) {
		this.cost = cost;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	*/

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
