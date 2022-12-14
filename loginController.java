package com.in28minutes.springboot.web.springbootfirstwebapplication.loginController;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.in28minutes.springboot.web.springbootfirstwebapplication.list.ListShow;
import com.in28minutes.springboot.web.springbootfirstwebapplication.loginService.LoginService;

// </login =>> "Welcome to login Page"

//It spring boot will pick the class to send request or get request
@Controller
@SessionAttributes("name")
public class loginController {
	//autoInjection using spring dependency
	@Autowired
	LoginService LoginSer;
	
	

	
	//when we write this annotation it will map with url like[ https:localhost/8089/login/ ]
	@RequestMapping(value="/login", method = RequestMethod.GET)
	//@ResponseBody // this will load the return data
	public String getlogin(ModelMap model){ 
		return "hello";
	}
	
	
	//so to put the individual method on the method we write the parameter method=RequestMethod.GET,POST whatever you want
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public String showlogin(ModelMap model,@RequestParam String name,@RequestParam String password) throws SQLException {
		
		boolean b =  LoginSer.Validation(name, password);
		System.out.println(b);
		if(b==false) {
			model.put("message","Invalid User!!!");
			return "hello";
		}
		
		
		model.put("name",name);
		model.put("password", password);
		return "welcome";
		//return "welcome";
	}
	
	
	
	

}
