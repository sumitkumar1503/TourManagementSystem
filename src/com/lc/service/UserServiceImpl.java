package com.lc.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lc.dao.UserDAO;
import com.lc.entity.Packages;
import com.lc.entity.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDAO userdao;
	
	@Autowired
	ServletContext sc;

	@Override
	public String user_register(com.lc.model.User u) {
		
		String filename= u.getProfileimg().getOriginalFilename();
		String path="/resources/images/"+filename;
		
		//converting model to entity type
		//business logic
		User user  = new User();
		user.setName(u.getName());
		user.setAddress(u.getAddress());
		user.setMobile(u.getMobile());
		user.setEmail(u.getEmail());
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		 String hashedPassword = passwordEncoder.encode(u.getPassword());
		user.setPassword(hashedPassword);
		user.setProfileImagePath(path);
		user.setRole("ROLE_CUSTOMER");
		user.setEnabled(1);

		int result=userdao.user_register(user);
		if(result==2) {
			return "user_already_registered";
		}
		return result==1?"user registered successfully":"user registration failed";
	}
	
	//for creating admin account when server will start
	@PostConstruct
    private void postConstruct() {
		User admin  = new User();
		admin.setName("Sumit");
		admin.setAddress("Muzaffarpur");
		admin.setMobile("9572181024");
		admin.setEmail("wapka1503@gmail.com");
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode("admin");
		admin.setPassword(hashedPassword);
		admin.setProfileImagePath("");
		admin.setRole("ROLE_ADMIN");
		admin.setEnabled(1);
		userdao.user_register(admin);
    }

	@Override
	public List<User> getCustomers() {
		return userdao.getCustomers();
	}

	@Override
	public String deleteCustomer(Integer id) {
		int result = userdao.deleteCustomer(id);
		if(result==1) {
			return "Customer Deleted successfully";
		}else {
			return "Customer Not Deleted";
		}
	}

	@Override
	public com.lc.model.User getCustomer(Integer id) {
		
		User entityuser=userdao.getCustomer(id);
		com.lc.model.User modeluser=null;
		if(entityuser != null) {
			//converting entity to model
			modeluser = new com.lc.model.User();
			modeluser.setName(entityuser.getName());
			modeluser.setAddress(entityuser.getAddress());
			modeluser.setEmail(entityuser.getEmail());
			modeluser.setMobile(entityuser.getMobile());
			
			
			return modeluser;
		}else {
			System.out.println("no customer found with this id");
			return modeluser;
		}
	}

	@Override
	public String editCustomer(com.lc.model.User customer, Integer id) {
		User user= new User();
		
		// required is equal to false for image while editing.. so if someone does not choosen any pic then we will not update image
		//we will use existing one
		MultipartFile file= customer.getProfileimg();
		if(file.getSize() > 0) {
		String filename= customer.getProfileimg().getOriginalFilename();
		String path="/resources/images/"+filename;
		user.setProfileImagePath(path);
		}
		
		user.setId(id);
		user.setAddress(customer.getAddress());
		user.setEmail(customer.getEmail());
		user.setMobile(customer.getMobile());
		user.setName(customer.getName());
		
		
		
		
		int result = userdao.editCustomer(user,id);
		if(result==1) {
			return "Customer updated successfully ! ";
		}else {
			return "Customer Not Found";
		}
	}
	


}
