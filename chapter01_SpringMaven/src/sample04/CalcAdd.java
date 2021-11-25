package sample04;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component //클래스명과 똑같은 객체명은 굳이 써주지 않아도 된다. 
public class CalcAdd implements Calc {

	@Override
	public void calculate(int x, int y) {
		System.out.println(x + " + " + y + " = " + (x + y));

	}

}
