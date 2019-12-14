package sopo.cn.hibernate20191206.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;

import sopo.cn.hibernate20191205.model.Employees;
import sopo.cn.hibernate20191205.utils.DBUtils20191210;
import sopo.cn.hibernate20191205.utils.HibernateUtils20191206;

public class TestHql {

	@Test
	public void testHql() {
		Session session = HibernateUtils20191206.getSessiontory("hibernate.cfg.xml").openSession();
		String sql = "from Employees";
		@SuppressWarnings("unchecked")
		Query<Employees> query = session.createQuery(sql);
		// List<Animal> list = session.createQuery(sql).getResultList();
		// TypedQuery<Animal> query = session.createQuery(sql);
		List<Employees> emplys = query.list();
		// System.out.println(lists.size());
		for (Employees employee : emplys) {
			System.out.println(employee.toString());
			;
		}

		session.close();
	}

	@Test
	public void testHql2() {
		Session session = HibernateUtils20191206.getSessiontory("hibernate.cfg.xml").openSession();
		String sql = "from Employees where id>?1 and name like ?2";
		@SuppressWarnings("unchecked")
		Query<Employees> query = session.createQuery(sql);
		query.setParameter(1, 2);
		query.setParameter(2, "%u%");
		List<Employees> lists = query.list();

		for (Employees employee : lists) {
			System.out.println(employee.toString());
			;
		}
	}

	@Test
	// 动态参数绑定
	public void testHql3() {
		Session session = HibernateUtils20191206.getSessiontory("hibernate.cfg.xml").openSession();
		String sql = "from Employees where id>:tid and name like :ts";
		@SuppressWarnings("unchecked")
		Query<Employees> query = session.createQuery(sql);
		query.setParameter("tid", 2);
		query.setParameter("ts", "%u%");
		List<Employees> lists = query.list();

		for (Employees employee : lists) {
			System.out.println(employee.toString());
			;
		}
	}

	// 动态参数绑定（对象）
	@Test
	public void testHql4() {
		Session session = HibernateUtils20191206.getSessiontory("hibernate.cfg.xml").openSession();
		String sql = "from Employees where id=?1";
		@SuppressWarnings("unchecked")
		Query<Employees> query = session.createQuery(sql);
		Integer integer = 2;
		query.setParameter(1, integer);

		List<Employees> lists = query.list();
		for (Employees emplye : lists) {
			System.out.println(emplye.toString());
		}
	}

//	@Test
//	public void testSingleTable() {
//		Session session = HibernateUtils20191206.getSessiontory("hibernate.cfg.xml").openSession();
//		String sql = "from singletable";
//		Query<Object> query = session.createQuery(sql);
//		List<Object> lists = query.list();
//		
//		for (Object object : lists) {
//			System.out.println(object.toString());
//		}
//	}

	@Test
	public void insertBat() throws SQLException {
		Connection connection = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO `employees` VALUES( ?, ?);";
		try {
			connection = DBUtils20191210.getConnection();
			ps = connection.prepareStatement(sql);
			for (int i = 10; i <= 500; i++) {
				ps.setInt(1, i);
				ps.setString(2, "user" + i);
				ps.addBatch();

				if (i % 50 == 0) {
					ps.executeBatch();
					ps.clearBatch();
				}
			}

			ps.executeBatch();
			ps.clearBatch();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ps.close();
			connection.close();
		}
	}

	@Test
	public void pageQuery() {
		Session session = HibernateUtils20191206.getSessiontory("hibernate.cfg.xml").openSession();
		String hql = "from Employees";
		@SuppressWarnings("unchecked")
		Query<Employees> query = session.createQuery(hql);

		int pageNo = 2;
		int pageSize = 10;
		query.setFirstResult((pageNo - 1) * pageSize);
		query.setMaxResults(pageSize);

		List<Employees> lists = query.list();
		for (Employees employee : lists) {
			System.out.println(employee);
		}
	}
	
	@Test
	public void testMapQuery() {
		Session session = HibernateUtils20191206.getSessiontory("hibernate.cfg.xml").openSession();
		@SuppressWarnings("unchecked")
		List<Employees> lists = session.createNamedQuery("selectTest").setParameter(0, 492).list();
		for (Employees employee : lists) {
			System.out.println(employee);
		}
	}
	
	@Test
	public void testProjectionQuery1() {
		Session session = HibernateUtils20191206.getSessiontory("hibernate.cfg.xml").openSession();
		String hql = "SELECT e.name, e.pwd FROM Employees e where e.id < 19";
		@SuppressWarnings("unchecked")
		Query<Object[]> query = session.createQuery(hql);
		List<Object[]> lists = query.list();
		for (Object[] object : lists) {
			System.out.println(Arrays.toString(object));;
		}
	}
	
	@Test
	public void testProjectionQuery2() {
		Session session = HibernateUtils20191206.getSessiontory("hibernate.cfg.xml").openSession();
		String hql = "select new Employees(e.name, e.pwd) from Employees e where e.id < 19";
		@SuppressWarnings("unchecked")
		Query<Employees> query = session.createQuery(hql);
		List<Employees> lists = query.list();
		
		for (Employees employee : lists) {
			System.out.println(employee.toString());
		}
	}
	
	@Test
	public void testPolymericQuery() {
		Session session = HibernateUtils20191206.getSessiontory("hibernate.cfg.xml").openSession();
		String hql = "select avg(e.id), sum(e.id) from Employees e";
		@SuppressWarnings("unchecked")
		Query<Object[]> query = session.createQuery(hql);
		List<Object[]> lists = query.list();
		
		for (Object[] objects : lists) {
			for (int i = 0; i < objects.length; i++) {
				System.out.println(objects[i]);
			}
		}
	}
}
