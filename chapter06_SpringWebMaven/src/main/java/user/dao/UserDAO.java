package user.dao;

import java.util.List;

import user.bean.UserDTO;

public interface UserDAO {

	public UserDTO checkId(String id);

	public void write(UserDTO userDTO);

	public List<UserDTO> getUserList();

	public UserDTO getUser(String searchId);

	public void modify(UserDTO userDTO);

	public void delete(String searchId);

}
