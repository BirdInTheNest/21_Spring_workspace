package sample05;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
