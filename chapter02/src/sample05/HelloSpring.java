package sample05;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml"); //환경설정파일 읽는다
		HelloSpring helloSpring = (HelloSpring) context.getBean("helloSpring"); //xml로 빈 생성
		helloSpring.menu(context); //값을 전달
		System.out.println("프로그램을 종료합니다.");
	}

	private void menu(ApplicationContext context) {
		Scanner scan = new Scanner(System.in);
		int num;
		SungJuk sungJuk = null; //부모
		
		while(true) {
			System.out.println();
			System.out.println("*************");
			System.out.println(" 1. 입력");
			System.out.println(" 2. 출력");
			System.out.println(" 3. 수정");
			System.out.println(" 4. 삭제");
			System.out.println(" 5. 끝");
			System.out.println("*************");
			System.out.print("입력 : ");
			num = scan.nextInt();
			if(num == 5) break;
			
			//bean 생성에 context가 필요하므로, main에서 menu함수 호출할 때 값을 받아온다
			if(num == 1) sungJuk = (SungJuk) context.getBean("sungJukInput");
			else if(num == 2) sungJuk = (SungJuk) context.getBean("sungJukOutput");
			else if(num == 3) sungJuk = (SungJuk) context.getBean("sungJukModify");
			else if(num == 4) sungJuk = (SungJuk) context.getBean("sungJukDelete");

			sungJuk.execute(); //반복되므로, if문 밖에서 호출
			
		}//while
		
	}
}
