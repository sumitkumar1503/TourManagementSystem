package com.lc.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lc.model.User;
import com.lc.service.UserService;

@Controller
public class UserRegistrationController {

	@Autowired
	UserService userservice;
	
	@GetMapping("user_register")
	public String user_register_get(ModelMap map,@ModelAttribute("msg") String msg,HttpServletResponse response) {
		//we have to send user object for form modelAttribute
		User user = new User();
		map.put("user",user);
		map.put("msg", msg);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Set<String> roles = AuthorityUtils.authorityListToSet(auth.getAuthorities());
		try {
			if (roles.contains("ROLE_ADMIN")) {
				response.sendRedirect("admin/admindashboard");
			}
			if (roles.contains("ROLE_CUSTOMER")) {
				response.sendRedirect("customer/customerdashboard");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "user_register";
	}
	
	@PostMapping("user_register")
	public String user_register_post(@ModelAttribute("user") User user,HttpSession session,RedirectAttributes redirectAttributes) {
		try {
			  	String path=session.getServletContext().getRealPath("/WEB-INF/resources/images/");  
		        String filename=user.getProfileimg().getOriginalFilename();  
		          
		        //System.out.println(path+" "+filename);  
		       
		        byte barr[]=user.getProfileimg().getBytes();  
		          
		        BufferedOutputStream bout=new BufferedOutputStream(new FileOutputStream(path+"/"+filename));  
		        bout.write(barr);  
		        bout.flush();  
		        bout.close();  

			
		} catch (IOException e) {
			e.printStackTrace();
		}
		String result=userservice.user_register(user);
		System.out.println(result);
		if(result.equalsIgnoreCase("user_already_registered")) {
			redirectAttributes.addAttribute("msg", "Customer Already Created With This Email ID");
			return "redirect:user_register";
		}
		return "redirect:login";
	}
	
	
	
	
}
