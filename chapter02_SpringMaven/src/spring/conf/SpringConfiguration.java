package spring.conf;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import sample01.MessageBeanImpl;
import sample02.CalcAdd;
import sample02.CalcMul;
import sample05.HelloSpring;
import sample05.SungJukDTO2;
import sample05.SungJukDelete;
import sample05.SungJukInput;
import sample05.SungJukModify;
import sample05.SungJukOutput;

@Configuration //환경설정 파일
public class SpringConfiguration {
	//sample01
	@Bean //일반 자바 클래스가 아니라, 스프링의 bean임을 알린다
	public MessageBeanImpl messageBeanImpl(){ //메소드명은 클래스의 객체/bean명 사용
		return new MessageBeanImpl("딸기");
	}
	
	//sample02
	@Bean //리턴되는 클래스를 스프링 빈으로 생성, 메소드명은 빈의 id명(스프링 문법)
	public CalcAdd calcAdd() {
		//return new CalcAdd(); //0 + 0 = 0
		return new CalcAdd(25, 36); 
	}
	
	@Bean(name="calcMul") //빈의 id명은 따로 정해주고, 
	public CalcMul getCalcMul() { //메소드명을 따로 사용
		return new CalcMul();
	}
	
	//sample05
	@Bean
	public HelloSpring helloSpring() {
		return new HelloSpring();
	}
	
	@Bean
	@Scope("prototype")
	public SungJukInput sungJukInput() {
		return new SungJukInput();
	}
	
	@Bean
	public SungJukOutput sungJukOutput() {
		return new SungJukOutput();
	}
	
	@Bean
	public SungJukModify sungJukModify() {
		return new SungJukModify();
	}
	
	@Bean
	public SungJukDelete sungJukDelete() {
		return new SungJukDelete();
	}
	
	@Bean
	@Scope("prototype")
	public SungJukDTO2 sungJukDTO2() {
		return new SungJukDTO2();
	}

	@Bean
	public List<SungJukDTO2> arrayList(){
		return new ArrayList<SungJukDTO2>();
	}
}
