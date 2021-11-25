package user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserSearchService implements UserService {
	@Setter
	private UserDAO userDAO;

	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);

		System.out.println();
		System.out.println("1. 이름 검색");
		System.out.println("2. 아이디 검색");
		System.out.print("번호 입력 : ");
		int num = scan.nextInt();
		
		//select * from usertable where columnName like '%value%';
		
		String columnName = null;
		String value = null;			
		
		if(num==1) {
			columnName = "name";
			System.out.print("이름 입력 : ");
			value = scan.next();
			
		}else if(num==2) {
			columnName = "id";
			System.out.print("아이디 입력 : ");
			value = scan.next();
			
		}
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("columnName", columnName);
		map.put("value", value);
		
		List<UserDTO> list = userDAO.search(map);

		System.out.println("이름\t아이디\t비밀번호");
		for(UserDTO userDTO : list) {
			System.out.println(userDTO.getName() + "\t"
							 + userDTO.getId() + "\t"
							 + userDTO.getPwd());
		}

	}

}
