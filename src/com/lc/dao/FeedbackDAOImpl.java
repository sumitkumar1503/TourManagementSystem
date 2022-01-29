package com.lc.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.lc.entity.Feedback;
import com.lc.entity.Packages;
import com.lc.entity.User;
import com.lc.utility.HibernateUtil;
@Repository
public class FeedbackDAOImpl implements FeedbackDAO {

	@Override
	public int addFeedback(User user, String feedback) {
		Transaction tx=null;
		Feedback feed= new Feedback();
		feed.setDate(new Date());
		feed.setFeedback(feedback);
		feed.setUser(user);
		
		try {
			Session ses= HibernateUtil.getSession();
			if(!ses.getTransaction().isActive()) {
				tx=ses.beginTransaction();
			}
			ses.save(feed);
			tx.commit();
			ses.close();
		} 
		catch (HibernateException e) {
			e.printStackTrace();
		}
		return 1;
	}

	@Override
	public List<Feedback> getFeedback() {
		List<Feedback> listOfFeedback=new ArrayList<Feedback>();
		Transaction tx=null;
		Integer id=null;
		try {
			Session ses= HibernateUtil.getSession();
			if(!ses.getTransaction().isActive()) {
				tx=ses.beginTransaction();
			}
			Query query = ses.createQuery("from com.lc.entity.Feedback");
			listOfFeedback =query.list();
			ses.close();
			
		} catch (HibernateException e) {
			System.out.println("PROBLEM IN FETCHING feedback");
			e.printStackTrace();
		}
		
		return listOfFeedback;
	}

}
