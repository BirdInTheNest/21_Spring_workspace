package sample02;

public class HelloSpring {

	public static void main(String[] args) {
		//MessageBeanEn messageBeanEn = new MessageBeanEn(); //결합도 100%, 1:1관계
		MessageBean messageBean = new MessageBeanKo(); //결합도 낮추기, 부모=자식
		messageBean.sayHello("Spring");
		
	}

}
