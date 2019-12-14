package sopo.cn.hibernate20191205.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil20191214 {
	private HibernateUtil20191214() {}
	
	private static HibernateUtil20191214 hibernateUtil20191214 = null;
	
	public static HibernateUtil20191214 getInstance() {
		if (hibernateUtil20191214 == null) {
			return new HibernateUtil20191214();
		} else {
			return hibernateUtil20191214;
		}
	}
	
	public SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = configuration.getStandardServiceRegistryBuilder().build();
		SessionFactory sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		return sessionFactory;
	}
}
