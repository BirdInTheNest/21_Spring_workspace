package sample02;

import lombok.AllArgsConstructor;

/*
public class CalcAdd implements Calc {
	private int x, y;

	public CalcAdd(int x, int y) { //생성자
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void calculate() {
		System.out.println(x + " + " + y + " = " + (x + y));
		
	}

}
*/

@AllArgsConstructor //롬복 생성자
public class CalcAdd implements Calc {
	private int x, y;
	
	@Override
	public void calculate() {
		System.out.println(x + " + " + y + " = " + (x + y));
		
	}

}