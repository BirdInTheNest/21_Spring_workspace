package user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import user.bean.UserDTO;

//@Transactional //클래스 위에 어노테이션 걸면 메소드마다 적을 필요 없음
public class UserDAOMybatis implements UserDAO {
	@Autowired //SqlSession 타입과 빈의 아이디명(메소드명)과 같은 것을 연결한다
	private SqlSession sqlSession;

	@Transactional //commit, close TransactionManager가 대신 한다
	@Override
	public void write(UserDTO userDTO) {
		sqlSession.insert("userSQL.write", userDTO);
		
	}

	@Transactional
	@Override
	public List<UserDTO> getUserList() {
		return sqlSession.selectList("userSQL.getUserList");
	}

	@Transactional
	@Override
	public UserDTO getUser(String id) {
		return sqlSession.selectOne("userSQL.getUser", id);
	}

	@Transactional
	@Override
	public void update(Map<String, String> map) {
		sqlSession.update("userSQL.update", map);
		
	}

	@Transactional
	@Override
	public void delete(String id) {
		sqlSession.delete("userSQL.delete", id);
		
	}

}
