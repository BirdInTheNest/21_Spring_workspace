package sample02;

import lombok.Setter;

/*
public class CalcMul implements Calc {
	private int x, y;

	public void setX(int x) { //세터
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public void calculate() {
		System.out.println(x + " * " + y + " = " + (x * y));
		
	}

}
*/

public class CalcMul implements Calc {
	@Setter //롬복 세터
	private int x, y;


	@Override
	public void calculate() {
		System.out.println(x + " * " + y + " = " + (x * y));
		
	}

}