package sample03_Advice;

public class MessageBeanImpl implements MessageBean {

	@Override
	public void study() {
		System.out.println("집중해서 공부합시다!");
		
	}

	@Override
	public String game() {
		System.out.println("수업시간에 몰래 게임한다..");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "야 바보얌";
	}
}
