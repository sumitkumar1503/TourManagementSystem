package com.lc.controller;


import java.io.IOException;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;




@Controller
public class LoginController {
	


	@GetMapping("login")
	public String show_login_page(Model model,@ModelAttribute("msg") String msg,HttpServletResponse response) {
		// To receive data from another controller we used @ModelAttribute .. then we passed that data to user_login jsp
		model.addAttribute("msg", msg);
		
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
		
		return "login";
	}
	
}
