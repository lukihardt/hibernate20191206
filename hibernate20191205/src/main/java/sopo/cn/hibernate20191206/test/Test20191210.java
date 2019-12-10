package sopo.cn.hibernate20191206.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;

import sopo.cn.hibernate20191205.model.Employees;
import sopo.cn.hibernate20191205.utils.HibernateUtils20191206;

public class Test20191210 {

	@Test
	public void test191210() {
		Session session = HibernateUtils20191206.getSessiontory("hibernate.cfg.xml").openSession();
		Transaction transaction = session.beginTransaction();
		
		Employees employees = new Employees();
		employees.setName("clark");
		session.save(employees);
		
		transaction.commit();
	}
}
