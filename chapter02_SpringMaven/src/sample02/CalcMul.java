package sample02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
public class CalcMul implements Calc {
	private int x, y;

	@Autowired //세터는 강제 호출이 안되므로, 자동으로 세터 매핑
	public void setX(@Value("25")int x) { //세터
		this.x = x;
	}
	
	@Autowired
	public void setY(@Value("36")int y) {
		this.y = y;
	}

	@Override
	public void calculate() {
		System.out.println(x + " * " + y + " = " + (x * y));
		
	}

}