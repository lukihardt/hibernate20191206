package sopo.cn.hibernate20191205.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;;

public class HibernateUtils20191206 {
	public static SessionFactory getSessiontory( String xmlDoc) {
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure(xmlDoc).build();
		SessionFactory sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		return sessionFactory;
	}
}
