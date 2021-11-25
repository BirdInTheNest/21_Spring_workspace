package sample06;

import java.util.List;

public class SalaryOutput implements Salary {
	private List<SalaryDTO> list;

	public void setList(List<SalaryDTO> list) {
		this.list = list;
	}

	@Override
	public void execute() {
		System.out.println();
		for(SalaryDTO salaryDTO : list) {
			System.out.println("이름\t직급\t기본급\t수당\t세율\t월급");
			System.out.println(salaryDTO);
		}

	}

}
