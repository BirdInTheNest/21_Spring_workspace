package user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import user.bean.UserDTO;

/*
public class UserDAOImpl implements UserDAO {
	//@Setter
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void write(UserDTO userDTO) {
		String sql = "insert into usertable values(?,?,?)";
		jdbcTemplate.update(sql, userDTO.getName(), userDTO.getId(), userDTO.getPwd());
		
	}

}
*/

public class UserDAOImpl extends NamedParameterJdbcDaoSupport implements UserDAO {
//extends NamedParameterJdbcDaoSupport 상속받았기 때문에, sql에서 ?를 써도 되고, :name을 써도 된다
	
	
	@Override
	public void write(UserDTO userDTO) {
		//NamedParameterJdbcDaoSupport는 sql에서 ? 대신 name을 주고, map만 담을 수 있다
		String sql = "insert into usertable values(:name, :id, :pwd)";
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", userDTO.getName());
		map.put("id", userDTO.getId());
		map.put("pwd", userDTO.getPwd());
		
		//NamedParameterJdbcTemplate 객체 생성, insert와 update, delete 모두 update 메소드 사용
		getNamedParameterJdbcTemplate().update(sql, map);
	}

	@Override
	public List<UserDTO> getUserList() {
		String sql = "select * from usertable";
		
		//JdbcTemplate 객체 생성, select는 query 메소드 이용
		//BeanPropertyRowMapper 클래스는 rs값을 DTO에 매핑해서 list에 담아준다
		//query()는 Multi row를 리턴할때 사용
		return getJdbcTemplate().query( 
				sql, 
				new BeanPropertyRowMapper<UserDTO>(UserDTO.class)); 
	}

	@Override
	public UserDTO getUser(String id) {
		String sql = "select * from usertable where id = :id";
		try {
			//queryForObject()는 Single row를 리턴할 때 사용
			//getJdbcTemplate()로 query메소드를 부르면 sql, RowMapper, Object
			//Object 형태이기 때문에 Stirng 값도 넘길 수 있습니다. 
			return getJdbcTemplate().queryForObject(
					sql, 
					new BeanPropertyRowMapper<UserDTO>(UserDTO.class), 
					id);
			
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	/* UserUpdateService에서 map에 담아서 보냈을 때
	@Override
	public UserDTO getUser(Map<String, String> map) {
		String sql = "select * from usertable where id = :id";		
		try {
			//getNamedParameterJdbcTemplate()로 query메소드를 부르면 sql, map, RowMapper
			return getNamedParameterJdbcTemplate().queryForObject(
					sql, 
					map, 
					new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
			
		}catch(EmptyResultDataAccessException e){
			return null;			
		}
	}
	 */

	@Override
	public void update(Map<String, String> map) {
		String sql = "update usertable set name=:name, pwd=:pwd where id=:id";
		getNamedParameterJdbcTemplate().update(sql, map);
		
	}

	@Override
	public void delete(String id) {
		String sql = "delete usertable where id=:id";
		getJdbcTemplate().update(sql, id); //insert, update, delete 모두 update 메소드 이용
		
	}

}
