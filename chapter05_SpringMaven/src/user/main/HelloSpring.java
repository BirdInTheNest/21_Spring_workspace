package user.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import spring.conf.SpringConfiguration;
import user.service.UserService;

//@ComponentScan
//@ComponentScan(basePackageClasses = SpringConfiguration.class)
public class HelloSpring {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		//ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml"); //src까지 이동하므로 그 이후 경로는 적어줘야 함
		
		HelloSpring helloSpring = (HelloSpring) context.getBean("helloSpring"); //xml로 빈 생성
		helloSpring.menu(context); //값을 전달
		System.out.println("프로그램을 종료합니다.");
	}
	
	public void menu(ApplicationContext context) {
		Scanner scan = new Scanner(System.in);
		int num;
		UserService userService = null; //부모
		
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
			if(num == 1) 
				userService = (UserService) context.getBean("userInsertService");
			
			else if(num == 2) 
				userService = context.getBean("userSelectService", UserService.class);
			
			else if(num == 3) 
				userService = context.getBean("userUpdateService", UserService.class);
			
			else if(num == 4) 
				userService = context.getBean("userDeleteService", UserService.class);

			userService.execute(); //호출
		}//while
	}

}
