package spring.conf;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import user.bean.UserDTO;
import user.dao.UserDAO;
import user.dao.UserDAOMybatis;
import user.main.HelloSpring;
import user.service.UserDeleteService;
import user.service.UserInsertService;
import user.service.UserSelectService;
import user.service.UserUpdateService;

@Configuration //환경설정파일임을 나타낸다
@EnableTransactionManagement //@Transactional 어노테이션 사용가능
@PropertySource("classpath:spring/db.properties")
public class SpringConfiguration {
	@Value("${jdbc.driver}")
	private String driver;
	
	@Value("${jdbc.url}")
	private String url;
	
	@Value("${jdbc.username}")
	private String username;
	
	@Value("${jdbc.password}")
	private String password;
	
	//Connection Pool, db.properties 이용
	@Bean
	public BasicDataSource dataSource(){//리턴타입 BasicDataSource 메소드명 dataSource
		BasicDataSource basicDataSource = new BasicDataSource();
		
		basicDataSource.setDriverClassName(driver);
		basicDataSource.setUrl(url);
		basicDataSource.setUsername(username);
		basicDataSource.setPassword(password);
		basicDataSource.setMaxTotal(20);
		basicDataSource.setMaxIdle(3);
		
		return basicDataSource;
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Throwable { //SqlSessionFactory 리턴타입, sqlSessionFactory 메소드명은 빈의 아이디값과 같다
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		
		//setConfigLocation는 String이 아니라 Resource를 원하므로, ClassPathResource 메소드를 통해 Resource를 load한다
		sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("spring/mybatis-config.xml"));
		sqlSessionFactoryBean.setDataSource(dataSource()); //위의 dataSource() 메소드 호출
		sqlSessionFactoryBean.setMapperLocations(new ClassPathResource("user/dao/userMapper.xml"));
	
		return sqlSessionFactoryBean.getObject(); //getObject() 메소드를 이용하여, sqlSessionFactoryBean이 아닌 SqlSessionFactory 리턴
	}
	
	@Bean
	public SqlSessionTemplate sqlSession() throws Throwable {
		return new SqlSessionTemplate(sqlSessionFactory()); //위의 sqlSessionFactory() 메소드 호출
	}
	
	@Bean
	public DataSourceTransactionManager transactionManager(){
		return new DataSourceTransactionManager(dataSource()); //위의 dataSource() 메소드 호출	
	}
	
	//------------------------------
	
	@Bean
	public HelloSpring helloSpring(){
		return new HelloSpring();
	}
	
	@Bean
	public UserInsertService userInsertService(){
		return new UserInsertService();
	}
	
	@Bean
	public UserSelectService userSelectService(){
		return new UserSelectService();
	}
	
	@Bean
	public UserUpdateService userUpdateService(){
		return new UserUpdateService();
	}
	
	@Bean
	public UserDeleteService userDeleteService(){
		return new UserDeleteService();
	}
	
	@Bean
	public UserDTO userDTO() {
		return new UserDTO();
	}
	
	@Bean
	public UserDAO userDAO() {
		return new UserDAOMybatis();
	}
	
}
