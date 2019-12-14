package sopo.cn.hibernate20191206.test;

import java.util.Arrays;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.junit.Test;

import sopo.cn.hibernate20191205.model.Employees2;
import sopo.cn.hibernate20191205.utils.HibernateUtils20191206;

public class Test20191212 {

	@Test
	public void testQBC() {
		Session session = HibernateUtils20191206.getSessiontory("hibernate.cfg.xml").openSession();
		// 1.获取到CriteriaBuilder对象
		CriteriaBuilder builder = session.getCriteriaBuilder();
		// 2.获取CriteriaQuery
		CriteriaQuery<Employees2> criteriaQuery = builder.createQuery(Employees2.class);
		// 3.获取到根对象, 构造各种各样的查询条件
		Root<Employees2> root = criteriaQuery.from(Employees2.class);

		Predicate predicate = builder.like(root.get("first_name"), "%hy%");
		Predicate predicate2 = builder.equal(root.get("job_id"), "IT_PROG");
		// Predicate predicate3 = builder.and(predicate, predicate2);
		
		criteriaQuery.where(predicate,predicate2);
		// criteriaQuery.where(predicate3);

		// 4.获取到Query对象
		Query<Employees2> query = session.createQuery(criteriaQuery);
		for (Employees2 iterable_element : query.list()) {
			System.out.println(iterable_element.toString());
		}
	}
	
	@Test
	public void testNativeSQL() {
		String sql = "select * from employees";
		Session session = HibernateUtils20191206.getSessiontory("hibernate.cfg.xml").openSession();
		@SuppressWarnings("unchecked")
		NativeQuery<Object[]> query = session.createNativeQuery(sql);
		
		List<Object[]> lists = query.list();
		for (Object[] object : lists) {
			System.out.println(Arrays.toString(object));
		}
		
		System.out.println("------------------------");
		
		for (Object[] object : lists) {
			for (int i = 0; i < object.length; i++) {
				System.out.print(object[i]);
			}
			System.out.println("");
		}
	}
	
	@Test
	public void testNativeSQL2() {
		String sql = "INSERT INTO `mydepartments` VALUES(?, \"AD\");";
		Session session = HibernateUtils20191206.getSessiontory("hibernate.cfg.xml").openSession();
		Transaction transaction = session.beginTransaction();
//		Query query = session.createQuery(sql);
//		query.setParameter(1, 2);
		int result = session.createNativeQuery(sql).setParameter(1, 2).executeUpdate();
		transaction.commit();
		System.out.println(result);
	}
}
