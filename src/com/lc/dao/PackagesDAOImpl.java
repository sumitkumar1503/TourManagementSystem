package com.lc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lc.entity.Booking;
import com.lc.entity.Packages;
import com.lc.entity.User;
import com.lc.utility.HibernateUtil;

@Repository
public class PackagesDAOImpl implements PackageDAO {

	private static final String GET_PACKAGES ="from com.lc.entity.Packages"; 

	@Autowired
	DataSource ds;
	
	
	@Override
	public List<Packages> getAllPackages() {
		List<Packages> listOfPackages=new ArrayList<Packages>();
		Transaction tx=null;
		Integer id=null;
		try {
			Session ses= HibernateUtil.getSession();
			if(!ses.getTransaction().isActive()) {
				tx=ses.beginTransaction();
			}
			Query query = ses.createQuery(GET_PACKAGES);
			listOfPackages =query.list();
			ses.close();
			
		} catch (HibernateException e) {
			System.out.println("PROBLEM IN FETCHING PACKAGES");
			e.printStackTrace();
		}
		
		return listOfPackages;
	}


	@Override
	public int addPackage(Packages packages) {
		Transaction tx=null;
		Integer id=null;
		try {
			Session ses= HibernateUtil.getSession();
			if(!ses.getTransaction().isActive()) {
				tx=ses.beginTransaction();
			}
			id=(Integer) ses.save(packages);
			tx.commit();
			ses.close();
				
		} 
		catch (HibernateException e) {
			e.printStackTrace();
		}
		return 1;
	}


	@Override
	public int deletePackage(Integer id) {
		Transaction tx=null;
		
		try {
			Session ses= HibernateUtil.getSession();
			if(!ses.getTransaction().isActive()) {
				tx=ses.beginTransaction();
			}
			Packages pack=(Packages) ses.get("com.lc.entity.Packages", id);
			if(pack!=null) {
				ses.delete("com.lc.entity.Packages", pack);
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
	public Packages getPackage(Integer id) {
		Transaction tx=null;
		Packages pack=null;
		try {
			Session ses= HibernateUtil.getSession();
			if(!ses.getTransaction().isActive()) {
				tx=ses.beginTransaction();
			}
			pack=(Packages) ses.get("com.lc.entity.Packages", id);
			if(pack!=null) {
				ses.close();
				return pack;
			}
		} 
		catch (HibernateException e) {
			e.printStackTrace();
		}
		return pack;
		
	}


	@Override
	public int editPackage(Packages packages, Integer id) {
		Transaction tx=null;
		Packages pack=null;
		try {
			Session ses= HibernateUtil.getSession();
			if(!ses.getTransaction().isActive()) {
				tx=ses.beginTransaction();
			}
			pack=(Packages) ses.get("com.lc.entity.Packages", id);
			if(pack!=null) {
				pack.setDescription(packages.getDescription());
				pack.setFood(packages.getFood());
				pack.setId(id);
				pack.setNumberOfDays(packages.getNumberOfDays());
				pack.setPackageName(packages.getPackageName());
				if(packages.getPosterImagePath() != null) {
					pack.setPosterImagePath(packages.getPosterImagePath());
				}
				pack.setTotalPrice(packages.getTotalPrice());
				pack.setTransportation(packages.getTransportation());
				ses.update(pack);
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
	public int bookPackage(User user, Packages pack) {
		Transaction tx=null;
		Booking booking = new Booking();
		booking.setPackages(pack);
		booking.setUser(user);
		//current date
		booking.setDate(new Date());
		try {
			Session ses= HibernateUtil.getSession();
			if(!ses.getTransaction().isActive()) {
				tx=ses.beginTransaction();
			}
			ses.save(booking);
			tx.commit();
			ses.close();
		} 
		catch (HibernateException e) {
			e.printStackTrace();
		}
		return 1;
	}


	@Override
	public List<Booking> getBooking(User user) {
		List<Booking> listOfBooking=new ArrayList<Booking>();
		Transaction tx=null;
		Integer id=null;
		try {
			Session ses= HibernateUtil.getSession();
			if(!ses.getTransaction().isActive()) {
				tx=ses.beginTransaction();
			}
			Query query = ses.createQuery("from com.lc.entity.Booking b where b.user = :user");
			query.setParameter("user", user);
			listOfBooking =query.list();
			ses.close();
			
		} catch (HibernateException e) {
			System.out.println("PROBLEM IN FETCHING booking");
			e.printStackTrace();
		}
		
		return listOfBooking;
	}


	@Override
	public List<Booking> getBookings() {
		List<Booking> listOfBooking=new ArrayList<Booking>();
		Transaction tx=null;
		Integer id=null;
		try {
			Session ses= HibernateUtil.getSession();
			if(!ses.getTransaction().isActive()) {
				tx=ses.beginTransaction();
			}
			Query query = ses.createQuery("from com.lc.entity.Booking");
			
			listOfBooking =query.list();
			ses.close();
			
		} catch (HibernateException e) {
			System.out.println("PROBLEM IN FETCHING booking");
			e.printStackTrace();
		}
		
		return listOfBooking;
	}


	@Override
	public Long getPackagesCount() {
		Transaction tx=null;
		Long count=(long) 0;
		try {
			Session ses= HibernateUtil.getSession();
			if(!ses.getTransaction().isActive()) {
				tx=ses.beginTransaction();
			}
			Query query = ses.createQuery("select count(*) from com.lc.entity.Packages");
			
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


	@Override
	public Long getBookingCount() {
		Transaction tx=null;
		Long count=(long) 0;
		try {
			Session ses= HibernateUtil.getSession();
			if(!ses.getTransaction().isActive()) {
				tx=ses.beginTransaction();
			}
			Query query = ses.createQuery("select count(*) from com.lc.entity.Booking");
			
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
