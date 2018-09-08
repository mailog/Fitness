package main.java.Fitness.Controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import main.java.database.User;
import main.java.database.UserJDBC;

@Controller
public class WebController extends WebMvcConfigurerAdapter {

	public static ApplicationContext context = new ClassPathXmlApplicationContext("main/Beans.xml");
	public static UserJDBC userJDBC = (UserJDBC) context.getBean("userJDBCTemplate");
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	ModelAndView getHome(@CookieValue(value = "USER", defaultValue = "null") String currentuser)
	{
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("loggedIn", !currentuser.equals("null"));
		if(!currentuser.equals("null"))
		{
			modelAndView.addObject("currentUser", userJDBC.getUser(currentuser));
		}
		modelAndView.addObject("user", new User());  
		return modelAndView;
	}
	
	@RequestMapping(value ="/", method = RequestMethod.POST)
	String getPostHome(@ModelAttribute("user") User user, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response)
	{
		user.setFatweight(user.getWeight() * user.getBodyfat());
		user.setLeanweight(user.getWeight() * (1-user.getBodyfat()));
		user.setBmi(user.getWeight()/(user.getHeight()*user.getHeight()));		//need to change units
		user.setMaxheart(1);													//need to figure out equation
		user.setBasalmetabolic(1); 												//need to figure out equation
		
		userJDBC.createUser(user);
		response.addCookie(new Cookie("USER", user.getEmail()));
		return "redirect:/";
	}
}