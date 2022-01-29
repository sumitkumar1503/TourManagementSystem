package com.lc.dao;



import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.lc.entity.Packages;
import com.lc.entity.User;
import com.lc.utility.HibernateUtil;

@Repository
public class UserDAOImpl implements UserDAO {

	@Override
	public int user_register(User user) {
		Integer id=null;
		Transaction tx=null;
		try {
			Session ses= HibernateUtil.getSession();
			if(!ses.getTransaction().isActive()) {
				tx=ses.beginTransaction();
			}
			Query query=ses.createQuery("from User where email=:email");
			query.setParameter("email", user.getEmail());
			User u=null;
			u=(User)query.uniqueResult();
			System.out.println(u);
			if(u!=null) {
				return 2;
			}else {
				id=(Integer) ses.save(user);
				tx.commit();
			}
				
		} 
		
		catch (HibernateException e) {
			if(id==null) {
				return 0;
			}
			
			e.printStackTrace();
		}
		return 1;
	}

	@Override
	public List<User> getCustomers() {
		Transaction tx=null;
		List<User> users=null;
		try {
			Session ses= HibernateUtil.getSession();
			if(!ses.getTransaction().isActive()) {
				tx=ses.beginTransaction();
			}
			Query query =ses.createQuery("from com.lc.entity.User u where u.role != 'ROLE_ADMIN'");
			users= query.list();
			if(users!=null) {
				ses.close();
				return users;
			}
		} 
		catch (HibernateException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public int deleteCustomer(Integer id) {
		Transaction tx=null;
		
		try {
			Session ses= HibernateUtil.getSession();
			if(!ses.getTransaction().isActive()) {
				tx=ses.beginTransaction();
			}
			User user=(User) ses.get("com.lc.entity.User", id);
			if(user!=null) {
				ses.delete("com.lc.entity.User", user);
				tx.commit();
				ses.close();
			}else {
				return 0;
			}
		} 
		catch (HibernateException e) {
			e.printStackTrace();
		}
		return 1;
	}

	@Override
	public User getCustomer(Integer id) {
		Transaction tx=null;
		User user=null;
		try {
			Session ses= HibernateUtil.getSession();
			if(!ses.getTransaction().isActive()) {
				tx=ses.beginTransaction();
			}
			user=(User) ses.get("com.lc.entity.User", id);
			if(user!=null) {
				ses.close();
				return user;
			}
		} 
		catch (HibernateException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public int editCustomer(User customer, Integer id) {
		Transaction tx=null;
		User user=null;
		try {
			Session ses= HibernateUtil.getSession();
			if(!ses.getTransaction().isActive()) {
				tx=ses.beginTransaction();
			}
			user=(User) ses.get("com.lc.entity.User", id);
			if(user!=null) {
				user.setId(id);
				user.setAddress(customer.getAddress());
				user.setEmail(customer.getEmail());
				user.setMobile(customer.getMobile());
				user.setName(customer.getName());
				if(customer.getProfileImagePath() != null) {
					user.setProfileImagePath(customer.getProfileImagePath());
				}
				
				ses.update(user);
				tx.commit();
				ses.close();
			}else {
				return 0;
			}
			
			
				
		} 
		catch (HibernateException e) {
			e.printStackTrace();
		}
		return 1;
	}

	@Override
	public User getCustomer(String emailid) {
		Transaction tx=null;
		User user=null;
		try {
			Session ses= HibernateUtil.getSession();
			if(!ses.getTransaction().isActive()) {
				tx=ses.beginTransaction();
			}
			Query query = ses.createQuery("from com.lc.entity.User u where u.email = :emailid");
			query.setParameter("emailid", emailid);
			user=(User) query.uniqueResult();
			if(user!=null) {
				ses.close();
				return user;
			}
		} 
		catch (HibernateException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public Long getUserCount() {
		Transaction tx=null;
		Long count=(long) 0;
		try {
			Session ses= HibernateUtil.getSession();
			if(!ses.getTransaction().isActive()) {
				tx=ses.beginTransaction();
			}
			Query query = ses.createQuery("select count(*) from com.lc.entity.User u where u.role != 'ROLE_ADMIN'");
			
			count=(Long) query.uniqueResult();
			if(count!=null) {
				ses.close();
				return count;
			}
		} 
		catch (HibernateException e) {
			e.printStackTrace();
		}
		return count;
	}


	
	
}
