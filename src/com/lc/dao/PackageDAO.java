package com.lc.dao;

import java.util.List;

import com.lc.entity.Packages;
import com.lc.entity.User;

public interface PackageDAO {
	public List<Packages> getAllPackages();
	public int addPackage(com.lc.entity.Packages Packages);
	public int editPackage(com.lc.entity.Packages Packages,Integer id);
	public int deletePackage(Integer id);
	public Packages getPackage(Integer id);
	public Long getPackagesCount();
	
	public int bookPackage(User user,Packages pack);
	public List<com.lc.entity.Booking> getBooking(User user);  
	public List<com.lc.entity.Booking> getBookings();  
	public Long getBookingCount();
}
