package com.lc.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lc.dao.FeedbackDAO;
import com.lc.dao.PackageDAO;
import com.lc.dao.UserDAO;
import com.lc.entity.Booking;
import com.lc.entity.Feedback;
import com.lc.model.Packages;
import com.lc.model.User;
import com.lc.service.PackageService;
import com.lc.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	PackageService packageservice;
	
	@Autowired
	UserService userService;
	
	@Autowired
	PackageDAO packdao;
	
	@Autowired
	UserDAO userdao;

	@GetMapping("admindashboard")
	public String adminDashboard(ModelMap map) {
		Long customercount=userdao.getUserCount();
		Long packagecount=packdao.getPackagesCount();
		Long bookingcount=packdao.getBookingCount();
		map.put("bookingcount", bookingcount);
		map.put("packagecount", packagecount);
		map.put("customercount", customercount);
		return "admin/admin_dashboard";
	}

	@GetMapping("admin-packages")
	public String adminPackages(ModelMap map) {
		return "admin/admin_packages";
	}

	@GetMapping("admin-add-package")
	public String adminAddPackageGet(ModelMap map, @ModelAttribute("msg") String msg) {
		Packages packages = new Packages();
		map.put("packages", packages);
		map.put("msg", msg);
		return "admin/admin_add_package";
	}

	@PostMapping("admin-add-package")
	public String adminAddPackagePost(ModelMap map, @ModelAttribute("packages") Packages packages, HttpSession session,
			RedirectAttributes redirectAttributes) {

		String path = session.getServletContext().getRealPath("/WEB-INF/resources/images/");
		String filename = packages.getPosterImage().getOriginalFilename();

		System.out.println(path + " " + filename);
		try {
			byte barr[] = packages.getPosterImage().getBytes();

			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(path + "/" + filename));
			bout.write(barr);
			bout.flush();
			bout.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		String result = packageservice.addPackages(packages);
		System.out.println(result);
		redirectAttributes.addAttribute("msg", result);
		return "redirect:admin-add-package";
	}

	@GetMapping("admin-view-package")
	public String adminViewPackage(ModelMap map, @ModelAttribute("msg") String msg) {

		map.put("packages", packageservice.getAllPackages());
		map.put("msg", msg);
		return "admin/admin_view_package";
	}
	@GetMapping("admin-view-customer")
	public String adminViewCustomer(ModelMap map, @ModelAttribute("msg") String msg) {

		map.put("customers", userService.getCustomers());
		map.put("msg", msg);
		return "admin/admin_view_customer";
	}

	@GetMapping("admin-delete-customer")
	public String adminDeleteCustomer(ModelMap map, @RequestParam Integer id) {
		userService.deleteCustomer(id);
		return "redirect:admin-view-customer";
	}

	@GetMapping("admin-edit-customer")
	public String adminEditCustomer(ModelMap map, @RequestParam Integer id, HttpSession session) {
		session.setAttribute("customerid", id);
		User user = userService.getCustomer(id);
		map.put("customer", user);
		map.put("msg", "");
		return "admin/admin-edit-customer";
	}
	

	@PostMapping("admin-edit-customer")
	public String adminEditCustomerPost(ModelMap map, @ModelAttribute("customer") User customer, HttpSession session,
			RedirectAttributes redirectAttributes) {
		// required is equal to false for image while editing package.. so if someone does not choosen any pic then we will not update image
		//we will use existing one
		MultipartFile file = customer.getProfileimg();
		if (file.getSize() > 0) {
			String path = session.getServletContext().getRealPath("/WEB-INF/resources/images/");
			String filename = customer.getProfileimg().getOriginalFilename();

			try {
				byte barr[] = customer.getProfileimg().getBytes();
				BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(path + "/" + filename));
				bout.write(barr);
				bout.flush();
				bout.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		Integer id = (Integer) session.getAttribute("customerid");
		String result = userService.editCustomer(customer, id);
		System.out.println(result);
		redirectAttributes.addAttribute("msg", result);
		return "redirect:admin-view-customer";
	}
	
	
	
	
	
	
	
	
	

	@GetMapping("admin-edit-package")
	public String adminEditPackage(ModelMap map, @RequestParam Integer id, HttpSession session) {
		session.setAttribute("packageid", id);
		Packages pack1 = packageservice.getPackage(id);
		map.put("packages", pack1);
		map.put("msg", "");
		return "admin/admin-edit-package";
	}
	

	@PostMapping("admin-edit-package")
	public String adminEditPackagePost(ModelMap map, @ModelAttribute("packages") Packages packages, HttpSession session,
			RedirectAttributes redirectAttributes) {
		// required is equal to false for image while editing package.. so if someone does not choosen any pic then we will not update image
		//we will use existing one
		MultipartFile file = packages.getPosterImage();
		if (file.getSize() > 0) {
			String path = session.getServletContext().getRealPath("/WEB-INF/resources/images/");
			String filename = packages.getPosterImage().getOriginalFilename();

			try {
				byte barr[] = packages.getPosterImage().getBytes();
				BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(path + "/" + filename));
				bout.write(barr);
				bout.flush();
				bout.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		Integer id = (Integer) session.getAttribute("packageid");
		String result = packageservice.editPackage(packages, id);
		System.out.println(result);
		redirectAttributes.addAttribute("msg", result);
		return "redirect:admin-view-package";
	}

	@GetMapping("admin-delete-package")
	public String adminDeletePackage(ModelMap map, @RequestParam Integer id) {
		packageservice.deletePackage(id);
		return "redirect:admin-view-package";
	}
	
	@GetMapping("admin-view-booking")
	public String adminViewBooking(ModelMap map) {
		
		
		List<Booking> bookings= packdao.getBookings();
		map.put("bookings", bookings);
		
		return "admin/admin-view-booking";
	}
	
	@Autowired
	FeedbackDAO feeddao;
	
	@GetMapping("admin-view-feedback")
	public String adminViewFeedback(ModelMap map) {
		List<Feedback> feeds= feeddao.getFeedback();
		map.put("feeds", feeds);
		return "admin/admin-view-feedback";
	}
	
	
	
}
