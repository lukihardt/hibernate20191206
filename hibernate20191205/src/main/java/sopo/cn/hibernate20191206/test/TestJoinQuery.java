package sopo.cn.hibernate20191206.test;

import java.util.List;

import org.hibernate.Session;
import org.junit.Test;

import sopo.cn.hibernate20191205.model.Departments;
import sopo.cn.hibernate20191205.model.Employees2;
import sopo.cn.hibernate20191205.utils.HibernateUtils20191206;

public class TestJoinQuery {
	@Test
	public void testSelectEmployees2() {
		String hql = "from Employees2";
		Session session = HibernateUtils20191206.getSessiontory("hibernate.cfg.xml").openSession();
		@SuppressWarnings("unchecked")
		List<Employees2> lists = session.createQuery(hql).list();
		for (Employees2 empl2 : lists) {
			System.out.println(empl2.toString());
		}
	}
	
	@Test
	public void testSelectDepartments() {
		String hql = "from Departments";
		Session session = HibernateUtils20191206.getSessiontory("hibernate.cfg.xml").openSession();
		@SuppressWarnings("unchecked")
		List<Departments> lists = session.createQuery(hql).list();
		for (Departments dptm : lists) {
			System.out.println(dptm.toString());
		}
	}
	
	@Test
	public void testNoFetch() {
		String hql = "from Employees2 e inner join Departments d on e.department_id=d.department_id where e.employee_id>:teid and d.department_id>:tdid";
		Session session = HibernateUtils20191206.getSessiontory("hibernate.cfg.xml").openSession();
		@SuppressWarnings("unchecked")
		List<Object[]> lists = session.createQuery(hql).setParameter("teid", 150).setParameter("tdid", 60).list();
		for (Object[] obj : lists) {
			for (int i = 0; i < obj.length; i++) {
				System.out.print(obj[i] + " ");
			}
			System.out.println("");
		}
		
//		for (Object[] objects : lists) {
//			System.out.println(objects[0]);;
//		}
	}
	
	@Test
	public void testFetch() {
		String hql = "select e from Employees2 e inner join fetch Departments d on e.department_id=d.department_id where e.employee_id>:teid and d.department_id>:tdid";
		Session session = HibernateUtils20191206.getSessiontory("hibernate.cfg.xml").openSession();
		@SuppressWarnings("unchecked")
		List<Employees2> lists = session.createQuery(hql).setParameter("teid", 150).setParameter("tdid", 60).list();
		for (Employees2 empl : lists) {
			System.out.println(empl.toString());
		}
		
//		for (Object[] objects : lists) {
//			System.out.println(objects[0]);;
//		}
	}
}
