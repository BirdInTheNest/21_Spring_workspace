package sample02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component //어노테이션으로 빈 생성, 클래스명과 객체명이 다르면 표시해야 한다 @Component("add")
public class CalcAdd implements Calc {
	private int x, y;
	
	public CalcAdd(@Value("25")int x, @Value("36")int y) { //생성자
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void calculate() {
		System.out.println(x + " + " + y + " = " + (x + y));
		
	}

}