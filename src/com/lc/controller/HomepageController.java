package com.lc.controller;

import java.io.IOException;
import java.lang.System.Logger;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomepageController {

	@GetMapping
	public String show_homepage(ModelMap map, HttpServletResponse response) {
		
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
		return "homepage";
	}

	@GetMapping("homepage")
	public String show_homepage_1(ModelMap map, HttpServletResponse response) {
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
		return "homepage";
	}

	@GetMapping("header")
	public String show_header() {
		return "header";
	}

	@GetMapping("footer")
	public String show_footer() {
		return "footer";
	}
	
	@GetMapping("aboutus")
	public String aboutUs(ModelMap map, HttpServletResponse response) {
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
		return "aboutus";
	}

}
