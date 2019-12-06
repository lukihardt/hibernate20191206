package sopo.cn.hibernate20191206.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;

import sopo.cn.hibernate20191205.model.Teacher;
import sopo.cn.hibernate20191205.utils.HibernateUtils20191206;

public class TestSearchPolicy {
	@Test
	public void test1() {
		Session session = HibernateUtils20191206.getSessiontory("hibernate.cfg.xml").openSession();
		Transaction transaction = session.beginTransaction();
		
		Teacher teacher = new Teacher();
		teacher.setTname("¿º");
		
		session.save(teacher);
		transaction.commit();
	}
	
	@Test
	public void test2() {
		Session session = HibernateUtils20191206.getSessiontory("hibernate.cfg.xml").openSession();
		Transaction transaction = session.beginTransaction();
		
		Teacher teacher = new Teacher();
		teacher.setTname("ÀπŒ÷Ãÿ");
		
		session.save(teacher);
		transaction.commit();
	}
	
	@Test
	public void test3() {
		Session session = HibernateUtils20191206.getSessiontory("hibernate.cfg.xml").openSession();
		Transaction transaction = session.beginTransaction();
		
		Teacher teacher = session.load(Teacher.class, 2);
		System.out.println(teacher);
		
		transaction.commit();
		session.close();
	}
}
