package user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import user.bean.UserDTO;

//@Component
@Repository //DB와 연결된 빈임을 나타낸다
public class UserDAOImpl extends NamedParameterJdbcDaoSupport implements UserDAO {

	@Autowired //어노테이션으로 연결된 것 중에서 빈의 아이디값과 같은 타입을 찾아서 연결
	public void setDS(DataSource dataSource) {//SpringConfiguration에서 생성한 빈의 아이디값 dataSource를 파라미터 타입 DataSource로 받는 세터 
		setDataSource(dataSource); //NamedParameterJdbcDaoSupport의 내장된 setDataSource 메소드
	}
	
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
