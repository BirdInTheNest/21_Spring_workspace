package sample05;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component //클래스 위에 지정하면, 해당 클래스를 스프링 빈으로 생성, 생성자는 자동호출
//@Scope("prototype") //싱글톤 해제한 DTO 사용하는 sungJukInput도 싱글톤 해제
public class SungJukInput implements SungJuk {
	@Autowired //@Component로 생성된 스프링 빈 중에서 자동 매핑
	private SungJukDTO2 sungJukDTO2;
	@Autowired
	@Qualifier("arrayList") //리스트의 자식클래스 중 하나를 특정하려고 사용, SpringConfiguration.java 에 생성
	private List<SungJukDTO2> list;

	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		System.out.print("이름 입력 : ");
		String name = scan.next();
		System.out.print("국어점수 입력 : ");
		int kor = scan.nextInt();
		System.out.print("영어점수 입력 : ");
		int eng = scan.nextInt();
		System.out.print("수학점수 입력 : ");
		int math = scan.nextInt();
		
		int tot = kor + eng + math;
		double avg = tot / 3.0;
		
		sungJukDTO2.setName(name);
		sungJukDTO2.setKor(kor);
		sungJukDTO2.setEng(eng);
		sungJukDTO2.setMath(math);
		sungJukDTO2.setTot(tot);
		sungJukDTO2.setAvg(avg);
		
		list.add(sungJukDTO2);
		
		System.out.println(name+"님의 데이터를 입력하였습니다");

	}

}
