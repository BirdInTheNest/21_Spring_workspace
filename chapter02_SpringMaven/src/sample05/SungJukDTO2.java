package sample05;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Component //클래스 위에 지정하면, 해당 클래스를 스프링 빈으로 생성, 생성자는 자동호출
//@Scope("prototype")
public class SungJukDTO2 {
	private String name;
	private int kor, eng, math, tot;
	private double avg;
	
	@Override
	public String toString() {
		return name+"\t"
			  +kor+"\t"
			  +eng+"\t"
			  +math+"\t"
			  +tot+"\t"
			  +String.format("%.2f", avg);
	}
}
