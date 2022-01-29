package com.lc.dao;

import java.util.List;

import com.lc.entity.Packages;
import com.lc.entity.User;

public interface UserDAO {
	public int user_register(User user);
	public List<com.lc.entity.User> getCustomers();
	public int deleteCustomer(Integer id);
	public User getCustomer(Integer id);
	public User getCustomer(String emailid);
	public int editCustomer(com.lc.entity.User customer,Integer id);
	public Long getUserCount();
}
