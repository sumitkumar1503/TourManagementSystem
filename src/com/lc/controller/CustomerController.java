package com.lc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lc.dao.FeedbackDAO;
import com.lc.dao.PackageDAO;
import com.lc.dao.UserDAO;
import com.lc.entity.User;
import com.lc.entity.Booking;
import com.lc.entity.Feedback;
import com.lc.entity.Packages;
import com.lc.service.PackageService;
import com.lc.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	PackageService packageService;
	
	@Autowired
	PackageDAO packdao;
	
	@Autowired
	UserDAO userdao;
	
	@Autowired
	FeedbackDAO feeddao;
	
	@GetMapping("customerdashboard")
	public String customerDashboard(ModelMap map) {
		
		Long packagecount=packdao.getPackagesCount();
		Authentication  auth = SecurityContextHolder.getContext().getAuthentication();
		// we get username by auth.getName() .. in our case it is email id
		User user=userdao.getCustomer(auth.getName());
		List<Booking> bookings= packdao.getBooking(user);
		
		Integer bookingcount=bookings.size();
		map.put("bookingcount", bookingcount);
		map.put("packagecount", packagecount);
		
		return "customer/customer_dashboard";
	}
	
	@GetMapping("customer-view-packages")
	public String show_package(Model model) {
		model.addAttribute("packages",packageService.getAllPackages());
		return "customer/customer-view-packages";
	}

	@GetMapping("customer-book-package")
	public String customerBookPackage(ModelMap map, @RequestParam Integer id) {
		
		Packages pack=packdao.getPackage(id);
		map.put("pack", pack);
		return "customer/customer-payment";
	}

	@GetMapping("payment-sucess")
	public String customerBookPackagePamentSuccess(ModelMap map, @RequestParam Integer id) {
		
		Packages pack=packdao.getPackage(id);
		map.put("pack", pack);
		Authentication  auth = SecurityContextHolder.getContext().getAuthentication();
		User user=userdao.getCustomer(auth.getName());
		//System.out.println("user obj======"+user);
		packdao.bookPackage(user, pack);
		return "redirect:customer-view-booking";
	}
	@GetMapping("customer-view-booking")
	public String customerViewBooking(ModelMap map) {
		
		Authentication  auth = SecurityContextHolder.getContext().getAuthentication();
		// we get username by auth.getName() .. in our case it is email id
		User user=userdao.getCustomer(auth.getName());
		List<Booking> bookings= packdao.getBooking(user);
		map.put("bookings", bookings);
		
		return "customer/customer-view-booking";
	}
	@GetMapping("customer-send-feedback")
	public String sendFeedback(Model model) {
		model.addAttribute("feed",new Feedback());
		System.out.println("enter");
		return "customer/customer-send-feedback";
	}
	
	@PostMapping("customer-send-feedback")
	public String sendFeedbackPost(Model model,@ModelAttribute("feed") Feedback feed) {
		Authentication  auth = SecurityContextHolder.getContext().getAuthentication();
		// we get username by auth.getName() .. in our case it is email id
		User user=userdao.getCustomer(auth.getName());
		feeddao.addFeedback(user, feed.getFeedback());
		return "customer/feedback-sent";
	}
}
