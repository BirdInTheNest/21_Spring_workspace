package user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import user.bean.UserDTO;
import user.dao.UserDAO;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;

	@Override
	public String checkId(String id) {
		UserDTO userDTO = userDAO.checkId(id);
		
		if(userDTO == null)
			return "non_exist"; //아이디로 사용 가능
		else
			return "exist"; //아이디로 사용 불가능
		
	}

	@Override
	public void write(UserDTO userDTO) {
		userDAO.write(userDTO);
		
	}

	/*
	@Override
	public JSONObject getUserList() {
		List<UserDTO> list = userDAO.getUserList();
		
		JSONObject json = new JSONObject();
		if(list != null) {
			JSONArray array = new JSONArray();
			
			for(UserDTO userDTO : list) {
				JSONObject temp = new JSONObject();
				temp.put("name", userDTO.getName());
				temp.put("id", userDTO.getId());
				temp.put("pwd", userDTO.getPwd());
				
				array.add(temp);
			}//for
			
			json.put("list", array);

		}//if

		return json;
	}
	*/
	
	public List<UserDTO> getUserList(){
		return userDAO.getUserList();
	}

	@Override
	public UserDTO getUser(String searchId) {
		return userDAO.getUser(searchId);
	}

	@Override
	public void modify(UserDTO userDTO) {
		userDAO.modify(userDTO);
	}

	@Override
	public void delete(String searchId) {
		userDAO.delete(searchId);
	}

}
