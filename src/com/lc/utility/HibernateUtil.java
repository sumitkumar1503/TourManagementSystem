package com.lc.utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	private static SessionFactory factory;

	static {
		Configuration cfg = null;
		
		try {
			// boot strap hibernate
			cfg = new Configuration();
			cfg.configure("com/lc/cfgs/hibernate.cfg.xml");
			factory = cfg.buildSessionFactory();
			System.out.println("session factory object created ===> "+factory);
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// static

	public static Session getSession() {
		Session ses = null;
		if (factory != null) {
			ses = factory.openSession();
			System.out.println("session created ===> "+ses);
		}
		return ses;
	}

	public static void closeSessionFactory() {
		if (factory != null)
			factory.close();
	}

}
