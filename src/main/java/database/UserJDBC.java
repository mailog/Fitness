package main.java.database;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserJDBC implements UserDAO{
	
	private static DataSource datasource;
	private static JdbcTemplate jdbcTemplateObject;
	
	@Override
	public void setDataSource(DataSource ds) {
		UserJDBC.datasource = ds;
		jdbcTemplateObject = new JdbcTemplate(datasource);
	}

	public void createUser(User user)
	{
		String SQL = "insert into users (username, name, email, password, age, restingheart, pushups, situps, weight, height, bodyfat, miletime, waisthip, gender, smoking, drinking, nongymloc, equipment, intensity, motivation, determination, timeperroutine, gymdays, exercisedays, experience, injuries, goal, leanweight, fatweight, bmi, maxheart, basalmetabolic) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplateObject.update(SQL, 
								user.getName(), user.getUsername(), user.getEmail(), user.getPassword(),
									user.getAge(), user.getRestingheart(), user.getPushups(), user.getSitups(),
									user.getWeight(), user.getHeight(), user.getBodyfat(), user.getMiletime(), user.getWaisthip(),
									user.getGender(),
									user.getSmoking(), user.getDrinking(), user.getNongymloc(), user.getEquipment(), user.getIntensity(),
									user.getMotivation(), user.getDetermination(), user.getTimeperroutine(), user.getGymdays(), user.getExercisedays(),
									user.getExperience(), user.getInjuries(), user.getGoal(),
									user.getLeanweight(), user.getFatweight(), user.getBmi(), user.getMaxheart(), user.getBasalmetabolic());
	}
	
	public User getUser(String email) {
		String SQL = "select * from users where email=?";
		User user = jdbcTemplateObject.queryForObject(SQL, new Object[] {email}, new UserMapper());
		return user;
	}
	
}
