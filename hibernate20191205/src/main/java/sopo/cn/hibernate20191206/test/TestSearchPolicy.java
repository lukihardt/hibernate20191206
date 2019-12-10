package sopo.cn.hibernate20191206.test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;

import sopo.cn.hibernate20191205.model.Computer;
import sopo.cn.hibernate20191205.model.SoftWare;
import sopo.cn.hibernate20191205.model.Teacher;
import sopo.cn.hibernate20191205.utils.HibernateUtils20191206;

public class TestSearchPolicy {
	@Test
	public void test1() {
		Session session = HibernateUtils20191206.getSessiontory("hibernate.cfg.xml").openSession();
		Transaction transaction = session.beginTransaction();

		Teacher teacher = new Teacher();
		teacher.setTname(""); // 乱码了，删除了内容

		session.save(teacher);
		transaction.commit();
	}

	@Test
	public void test2() {
		Session session = HibernateUtils20191206.getSessiontory("hibernate.cfg.xml").openSession();
		Transaction transaction = session.beginTransaction();

		Teacher teacher = new Teacher();
		teacher.setTname(""); // 乱码了，删除了内容

		session.save(teacher);
		transaction.commit();
	}

	@Test
	public void test3() {
		Session session = HibernateUtils20191206.getSessiontory("hibernate.cfg.xml").openSession();
		Transaction transaction = session.beginTransaction();

		Teacher teacher = session.load(Teacher.class, 2);
		Hibernate.initialize(teacher); // 使懒加载也初始化
		// System.out.println(teacher);

		transaction.commit();
		session.close();
	}

	@Test
	public void test4() {
		Session session = HibernateUtils20191206.getSessiontory("hibernate.cfg.xml").openSession();
		Transaction transaction = session.beginTransaction();

		Computer computer = new Computer();
		computer.setCpu("intel7700HQ");
		computer.setGpu("nVidia1080");

		SoftWare software1 = new SoftWare();
		software1.setBrowser("chrome");
		software1.setOs("win10");
		software1.setComputer(computer);

		SoftWare software2 = new SoftWare();
		software2.setBrowser("fireFox");
		software2.setOs("linux");
		software2.setComputer(computer);

		Set<SoftWare> set = new HashSet<>();
		set.add(software1);
		set.add(software2);
		computer.setSet(set);

		session.save(computer);
		session.save(software1);
		session.save(software2);

		transaction.commit();
	}

	@Test
	public void testBatchSize() {
//		Session session = HibernateUtils20191206.getSessiontory("hibernate.cfg.xml").openSession();
//		String hql = "from Computer";
//		@SuppressWarnings("unchecked")
//		List<Computer> clist = session.createQuery(hql).list();
//		for (Computer computer : clist) {
//			System.out.println(computer.toString());;
//			if (computer.getSet() != null) {
//				System.out.println(computer.getSet().size());
//			}
//		}
//		// System.out.println(clist.size());

		Session session = HibernateUtils20191206.getSessiontory("hibernate.cfg.xml").openSession();
		String hql = "from Computer s where s.id in (:ids)";
		@SuppressWarnings("unchecked")
		List<Computer> computer = session.createQuery(hql).setParameterList( "ids", new Object[]{ "95051341-d2e2-48dd-8b09-d9644d24eec5"}).list();
		Iterator<Computer> iterator = computer.iterator();
//		for (SoftWare softWare : softWares) {
//			System.out.println(softWare.toString());
//		}
		while (iterator.hasNext()) {
			Computer cp = iterator.next();
			System.out.println("id: " + cp.getId() + " cpu: " + cp.getCpu() + " gpu: " + cp.getGpu());
			System.out.println(cp.getSet().toString());;
		}
	}
}
