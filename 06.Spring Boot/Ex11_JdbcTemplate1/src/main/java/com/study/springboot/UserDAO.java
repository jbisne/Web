package com.study.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO 
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<UserDTO> listForBeanPropertyRowMapper()
	{
		String query = "select * from myuser";
		List<UserDTO> list = jdbcTemplate.query(
				query, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
		
//		 for(UserDTO my : list)
//		{
//			System.out.println(my);
//		}
		
		return list;
	}
	
//	public int insert(UserDTO user) 
//	{
//		String query="insert into myuser(id, name) values(?, ?)";
//		return jdbcTemplate.update(query, user.getId(), user.getName());
//	}
//	insert 관련문 이 예제에서 아직 안만들어놈. 나중에 만들면 주석해제.
	
/*	DAO는 @Repository라는 어노테이션을 적어 Bean으로 등록한다. 
	Repository는 stereo type의 일종으로 Bean을 좀 더 목적에 맞도록 사용할 수 있게 해준다. 
	@Repository를 적어놓으면 Classpath Scanning 때 Bean Container에 등록된다.
*/
}
