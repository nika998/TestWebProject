package it.engineering.web.dao.jdbctemplateimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import it.engineering.web.dao.UserDao;
import it.engineering.web.domain.User;

@Component(value = "userJdbcTemplate")
public class UserJDBCTemplateImpl implements UserDao {
    
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void add(User user) {
		System.out.println("Add user");
		jdbcTemplate.update("INSERT INTO user(firstname,lastname,username,password) VALUES(?,?,?,?)",
				user.getFirstname(), user.getLastname(), user.getUsername(), user.getPassword());

	}

	@Override
	public void update(User user) {
		System.out.println("Update user");
		jdbcTemplate.update(
				"UPDATE user SET firstname = '?', lastname = '?', username '?', password = '?' WHERE username = ?",
				user.getFirstname(), user.getLastname(), user.getUsername(), user.getPassword(), user.getUsername());

	}

	@Override
	public void remove(User user) {
		System.out.println("Delete user");
		jdbcTemplate.update("DELETE FROM user WHERE username = '?'", user.getUsername());

	}

	@Override
	public List<User> getAll() {
		System.out.println("Get all users");
		String query = "select * from user";
		return jdbcTemplate.query(query, new UserMapper());
	}

	class UserMapper implements RowMapper<User> {

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setFirstname(rs.getString("firstname"));
			user.setLastname(rs.getString("lastname"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			return user;
		}

	}

}
