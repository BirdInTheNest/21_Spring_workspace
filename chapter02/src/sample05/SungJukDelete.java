package sample05;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class SungJukDelete implements SungJuk {
	//@Setter
	private List<SungJukDTO2> list;

	public void setList(List<SungJukDTO2> list) {
		this.list = list;
	}

	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		System.out.print("\n 삭제할 이름 입력 : ");
		String name = scan.next();
		
		//리스트는 인덱스 부여하므로 삭제시 문제. for문은 인덱스로 관리하므로 못 쓰고, Iterator 필요
		Iterator<SungJukDTO2> it= list.iterator();
		while(it.hasNext()) { //hasNext() 항목이 있으면 T 없으면 F
			if(it.next().getName().equals(name)) { //next() 항목을 꺼내서 저장하고 다음 항목으로 이동
				it.remove();
				System.out.println(name+"님의 데이터를 삭제하였습니다");
				
				return; //함수를 나가라
			}//if
		}//while
		
		System.out.println("찾고자 하는 이름이 없습니다.");
	}

}
