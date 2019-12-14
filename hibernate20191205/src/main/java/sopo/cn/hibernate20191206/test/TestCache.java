package sopo.cn.hibernate20191206.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;

import sopo.cn.hibernate20191205.model.Computer;
import sopo.cn.hibernate20191205.model.Employees2;
import sopo.cn.hibernate20191205.utils.HibernateUtils20191206;

public class TestCache {
	@Test
	public void testCacheLevelClass() {
		SessionFactory sessionFactory = HibernateUtils20191206.getSessiontory("hibernate.cfg.xml");
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Employees2 employees2 = session.get(Employees2.class, 101);
		transaction.commit();
		System.out.println(employees2.toString());
		session.close();

		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		Employees2 employees22 = session.get(Employees2.class, 101);
		transaction.commit();
		System.out.println(employees22.toString());
		
		session.close();
		sessionFactory.close();
	}
	
	@Test
	public void testCacheLevelSet() {
		SessionFactory sessionFactory = HibernateUtils20191206.getSessiontory("hibernate.cfg.xml");
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Computer computer = session.get(Computer.class, "95051341-d2e2-48dd-8b09-d9644d24eec5");
		System.out.println(computer.getSet().toString());
		transaction.commit();
		session.close();
		
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		Computer computer2 = session.get(Computer.class, "95051341-d2e2-48dd-8b09-d9644d24eec5");
		System.out.println(computer2.getSet().toString());
		transaction.commit();
		sessionFactory.close();
		session.close();
	}
	
	@Test
	public void testCacheQuery() {
		SessionFactory sessionFactory = HibernateUtils20191206.getSessiontory("hibernate.cfg.xml");
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		@SuppressWarnings("unchecked")
		Query<Employees2> query = session.createQuery("from Employees2");
		query.setCacheable(true);
		List<Employees2> lists = query.list();
		System.out.println(lists.size());
		transaction.commit();
		session.close();
		
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		@SuppressWarnings("unchecked")
		Query<Employees2> query2 = session.createQuery("from Employees2");
		query2.setCacheable(true);
		List<Employees2> lists2 = query2.list();
		System.out.println(lists2.size());
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	@Test
	public void testCacheQueryTimeStamp() {
		SessionFactory sessionFactory = HibernateUtils20191206.getSessiontory("hibernate.cfg.xml");
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		@SuppressWarnings("unchecked")
		Query<Employees2> query = session.createQuery("from Employees2");
		query.setCacheable(true);
		List<Employees2> lists = query.list();
		System.out.println(lists.size());
		// transaction.commit();
		
		// 改变缓存数据
		Employees2 employees2 = session.get(Employees2.class, 99);
		System.out.println(employees2);
		employees2.setLast_name("hkhp");
		
		// transaction = session.beginTransaction();
		// @SuppressWarnings("unchecked")
		// Query<Employees2> query2 = session.createQuery("from Employees2");
		// query.setCacheable(true);
		List<Employees2> lists2 = query.list();
		System.out.println(lists2.size());
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
}
