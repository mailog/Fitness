package main.java.database;

import javax.sql.DataSource;

public interface UserDAO {

	public void setDataSource(DataSource ds);
	
	public void createUser(User user);
	
	public User getUser(String email);
}
