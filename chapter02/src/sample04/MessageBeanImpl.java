package sample04;

public class MessageBeanImpl implements MessageBean {
	private String name;
	private String phone;
	private Outputter outputter; //부모=자식, 부모로 접근
	
	public MessageBeanImpl() {
		System.out.println("MessageBeanImpl 기본 생성자");
	}
	
	public MessageBeanImpl(String name) { //생성자
		System.out.println("1. MessageBeanImpl(String name) 생성자");
		this.name = name;
	}
	
	public void setPhone(String phone) { //세터
		System.out.println("4. setPhone(String phone) 세터");
		this.phone = phone;
	}

	public void setOutputter(Outputter outputter) {
		System.out.println("5. setOutputter(Outputter outputter) 세터");
		this.outputter = outputter;
	}

	@Override
	public void helloCall() {
		outputter.output("이름 = "+name+", 핸드폰 = "+phone);
	}

}
