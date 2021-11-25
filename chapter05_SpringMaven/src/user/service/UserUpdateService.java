package user.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.bean.UserDTO;
import user.dao.UserDAO;

//@Service
public class UserUpdateService implements UserService {
	@Autowired
	private UserDAO userDAO;

	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("수정할 아이디 입력: ");
		String id = scan.next();

		UserDTO userDTO = userDAO.getUser(id);
		
		/* map에 담아서 보내는 방법
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		UserDTO userDTO = userDAO.getUser(map);
		 */
		
		if(userDTO == null) {
			System.out.println("수정할 아이디가 없습니다");
			return;
		}
		
		System.out.println();
		System.out.println(userDTO.getName() +"\t"+ userDTO.getId() +"\t"+ userDTO.getPwd());
		
		System.out.println();
		System.out.print("수정할 이름 입력: ");
		String name = scan.next();
		System.out.print("수정할 비밀번호 입력: ");
		String pwd = scan.next();
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", name);
		map.put("id", id);
		map.put("pwd", pwd);
		
		userDAO.update(map);
		
		System.out.println("데이터를 DB에서 수정하였습니다.");
		
		
	}

}
