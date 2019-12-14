package sopo.cn.hibernate20191206.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import sopo.cn.hibernate20191205.model.Mydepartments;
import sopo.cn.hibernate20191205.model.Myemployees_copy;
import sopo.cn.hibernate20191205.utils.HibernateUtils20191206;

public class TestBatch {
	
	@Test
	public void testInsertEntityForDown() {
		Session session = HibernateUtils20191206.getSessiontory("hibernate.cfg.xml").openSession();
		Transaction transaction = session.beginTransaction();
		
		Mydepartments mydepartments =new Mydepartments( 1, "IT");
		Myemployees_copy myemployees_copy = new Myemployees_copy( 1, "sss", "programmer", mydepartments);
		
		session.save(mydepartments);
		session.save(myemployees_copy);
		transaction.commit();
	}
	
	@Test
	public void testInsert() {
		String hql = "insert into Myemployees(id,name,occupation,mydepartments) select id,name,occupation,mydepartments from Myemployees_copy";
		Session session = HibernateUtils20191206.getSessiontory("hibernate.cfg.xml").openSession();
		Transaction transaction = session.beginTransaction();
		Integer result = session.createQuery(hql).executeUpdate();
		
		System.out.println(result);
		transaction.commit();
	}
	
	@Test
	public void testDelete() {
		String hql = "delete from Myemployees_copy me where me.id > 0";
		Session session = HibernateUtils20191206.getSessiontory("hibernate.cfg.xml").openSession();
		Transaction transaction = session.beginTransaction();
		Integer result = session.createQuery(hql).executeUpdate();
		transaction.commit();
		System.out.println("result: " + result);
	}
	
	@Test
	public void testUpdate() {
		String hql = "update Myemployees set name = ?0";
		Session session = HibernateUtils20191206.getSessiontory("hibernate.cfg.xml").openSession();
		Transaction transaction = session.beginTransaction();
		Integer result = session.createQuery(hql).setParameter(0, "shil").executeUpdate();
		transaction.commit();
		System.out.println("result: " + result);
	}
}