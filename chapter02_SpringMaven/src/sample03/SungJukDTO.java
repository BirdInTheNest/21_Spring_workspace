package sample03;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter 
@Component //클래스 위에 지정하면, 해당 클래스를 스프링 빈으로 생성
public class SungJukDTO {
	private String name="홍길동";
	private int kor=97;
	private int eng=100;
	private int math=95;
	private int tot;
	private double avg;
	
	/*
	public void setName(@Value("민들레") String name) {
		this.name = name;
	}
	public void setKor(@Value("97") int kor) {
		this.kor = kor;
	}
	public void setEng(@Value("95") int eng) {
		this.eng = eng;
	}
	public void setMath(@Value("98") int math) {
		this.math = math;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	*/
	
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
