package sopo.cn.hibernate20191206.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import sopo.cn.hibernate20191205.model.Employees2;
import sopo.cn.hibernate20191205.model.Mydepartments;
import sopo.cn.hibernate20191205.model.Myemployees;
import sopo.cn.hibernate20191205.utils.HibernateUtil20191214;
import sopo.cn.hibernate20191205.utils.HibernateUtils20191206;

public class TestHibernateSession {

	@Test
	public void test1UseOldUtils() {
		Session session = HibernateUtils20191206.getSessiontory("hibernate.cfg.xml").openSession();
		// Transaction transaction = session.beginTransaction();

		String hql = "from Employees2";
		@SuppressWarnings("unchecked")
		List<Employees2> lists = session.createQuery(hql).list();
		for (Employees2 employees2 : lists) {
			System.out.println(employees2.toString());
		}
		
		System.out.println(session.isOpen());
	}

	@Test
	public void test2() {
		Session session = HibernateUtil20191214.getInstance().getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		String hql = "from Employees2";
		@SuppressWarnings("unchecked")
		List<Employees2> lists = session.createQuery(hql).list();
		for (Employees2 employees2 : lists) {
			System.out.println(employees2.toString());
		}
		transaction.commit();
		
		System.out.println(session.isOpen());
	}
	
	@Test
	public void test3() {
		Session session = HibernateUtil20191214.getInstance().getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		Mydepartments mydepartments = new Mydepartments( 3, "FN");
		
		Myemployees myemployees = new Myemployees( 3, "ly", "Manager", mydepartments);
		Myemployees myemployees2 = new Myemployees( 4, "ms", "Manager", mydepartments);
		
		session.save(mydepartments);
		session.save(myemployees);
		session.save(myemployees2);
		
		transaction.commit();
		
		//看看session是否开着
		System.out.println(session.isOpen());
	}
}
