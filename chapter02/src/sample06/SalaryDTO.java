package sample06;

import java.text.DecimalFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalaryDTO {
	private String name;
	private String position;
	private int basePay;
	private int benefit;
	private double taxRate;
	private int salary;
	private DecimalFormat df = new DecimalFormat();
	
	@Override
	public String toString() {
		return name+"\t"
			  +position+"\t"
			  +df.format(basePay)+"\t"
			  +df.format(benefit)+"\t"
			  +taxRate+"\t"
			  +df.format(salary);
	}
}
