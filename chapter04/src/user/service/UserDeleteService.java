package user.service;

import java.util.Scanner;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserDeleteService implements UserService {
	@Setter
	private UserDAO userDAO;

	@Override
	public void execute() {
Scanner scan = new Scanner(System.in);
		
		System.out.print("삭제할 아이디 입력: ");
		String id = scan.next();

		UserDTO userDTO = userDAO.getUser(id);
		
		/*
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		UserDTO userDTO = userDAO.getUser(map);
		 */
		
		if(userDTO == null) {
			System.out.println("삭제할 아이디가 없습니다");
			return;
		}
		
		userDAO.delete(id);
		
		System.out.println("데이터를 DB에서 삭제하였습니다");

	}

}
