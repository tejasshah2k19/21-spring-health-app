package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.UserBean;

@Repository
public class UserDao {

	@Autowired
	JdbcTemplate stmt;

	public void saveUser(UserBean user) {
		stmt.update("insert into user (firstName,email,password,role) values (?,?,?,?) ", user.getFirstName(),
				user.getEmail(), user.getPassword(), user.getRole());
	}

	public UserBean authenticate(String email, String password) {
		try {
		UserBean user = stmt.queryForObject("select * from user where email = ? and password = ?", new Object[] { email, password },
				new BeanPropertyRowMapper<UserBean>(UserBean.class));
		
			return user;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
