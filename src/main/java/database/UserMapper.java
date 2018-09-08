package main.java.database;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException{
        User user = new User();
        user.setName(rs.getString("name"));
        user.setUsername(rs.getString("username"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        
        user.setAge(rs.getInt("age"));
        user.setHeight(rs.getDouble("height"));
        user.setWeight(rs.getDouble("weight"));
        user.setBodyfat(rs.getDouble("bodyfat"));
        user.setMiletime(rs.getDouble("miletime"));
        user.setWaisthip(rs.getDouble("waisthip"));
        
        user.setGender(rs.getInt("gender"));
        
        user.setSmoking(rs.getInt("smoking"));
        user.setDrinking(rs.getInt("drinking"));
        user.setNongymloc(rs.getInt("nongymloc"));
        user.setEquipment(rs.getInt("equipment"));
        user.setIntensity(rs.getInt("intensity"));
        user.setMotivation(rs.getInt("motivation"));
        user.setDetermination(rs.getInt("determination"));
        user.setTimeperroutine(rs.getInt("timeperroutine"));
        user.setGymdays(rs.getInt("gymdays"));
        user.setExercisedays(rs.getInt("exercisedays"));
        user.setExperience(rs.getInt("experience"));
        user.setInjuries(rs.getInt("injuries"));
        user.setGoal(rs.getInt("goal"));
        
        user.setLeanweight(rs.getDouble("leanweight"));
        user.setFatweight(rs.getDouble("fatweight"));
        user.setBmi(rs.getDouble("bmi"));
        user.setMaxheart(rs.getInt("maxheart"));
        user.setBasalmetabolic(rs.getDouble("basalmetabolic"));
        
        return user;
    }
}
