package sample06;

import java.util.List;
import java.util.Scanner;

//@Setter
public class SalaryInput implements Salary {
	private SalaryDTO salaryDTO;
	private List<SalaryDTO> list;
	
	public void setSalaryDTO(SalaryDTO salaryDTO) {
		this.salaryDTO = salaryDTO;
	}
	public void setList(List<SalaryDTO> list) {
		this.list = list;
	}

	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		System.out.print("이름 입력 : ");
		String name = scan.next();
		System.out.print("직급 입력 : ");
		String position = scan.next();
		System.out.print("기본급 입력 : ");
		int basePay = scan.nextInt();
		System.out.print("수당 입력 : ");
		int benefit = scan.nextInt();
		
		double taxRate;
		if((basePay+benefit) <= 2000000) taxRate = 0.01;
		else if((basePay+benefit) <= 4000000) taxRate = 0.02;
		else taxRate = 0.03;
		
		int salary = (int)((basePay+benefit) - (basePay+benefit)*taxRate);
		
		salaryDTO.setName(name);
		salaryDTO.setPosition(position);
		salaryDTO.setBasePay(basePay);
		salaryDTO.setBenefit(benefit);
		salaryDTO.setTaxRate(taxRate);
		salaryDTO.setSalary(salary);
		
		list.add(salaryDTO);
		
		System.out.println(name+"님의 데이터를 입력하였습니다");
	}

}
