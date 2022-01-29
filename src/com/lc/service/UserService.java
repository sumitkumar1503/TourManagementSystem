package com.lc.service;

import java.util.List;

import com.lc.model.User;

public interface UserService {
	public String user_register(User user);
	public List<com.lc.entity.User> getCustomers();
	public String deleteCustomer(Integer id);
	public com.lc.model.User getCustomer(Integer id);
	public String editCustomer(com.lc.model.User customer,Integer id);
}
