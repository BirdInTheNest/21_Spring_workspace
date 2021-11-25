package sample06;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SalaryMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml"); //환경설정파일 읽는다
		SalaryMain salaryMain = (SalaryMain) context.getBean("salaryMain"); //xml로 빈 생성
		salaryMain.menu(context); //값을 전달
		System.out.println("프로그램을 종료합니다.");

	}

	private void menu(ApplicationContext context) {
		Scanner scan = new Scanner(System.in);
		int num;
		Salary salary = null; //부모
		
		while(true) {
			System.out.println();
			System.out.println("*************");
			System.out.println(" 1. 등록");
			System.out.println(" 2. 출력");
			System.out.println(" 3. 끝");
			System.out.println("*************");
			System.out.print("번호 입력 : ");
			num = scan.nextInt();
			if(num == 3) break; //반복문 나가라
			
			//bean 생성에 context가 필요하므로, main에서 menu함수 호출할 때 값을 받아온다
			if(num == 1) salary = (Salary) context.getBean("salaryInput");
			else if(num == 2) salary = (Salary) context.getBean("salaryOutput");
			
			salary.execute(); //반복되므로, if문 밖에서 호출
			
		}//while
		
	}

}
