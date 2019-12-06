package sopo.cn.hibernate20191206.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;

import sopo.cn.hibernate20191205.model.Bird;
import sopo.cn.hibernate20191205.model.Bird2;
import sopo.cn.hibernate20191205.model.Pig;
import sopo.cn.hibernate20191205.model.Pig2;
import sopo.cn.hibernate20191205.utils.HibernateUtils20191206;

public class TestSubMapping {

	@Test
	public void testTwo() {
		Session session = HibernateUtils20191206.getSessiontory("hibernate.cfg.xml").openSession();
		Transaction transaction = session.beginTransaction();

		Bird bird = new Bird();
		bird.setName("yoy");
		bird.setHeight(101.1);

		Pig pig = new Pig();
		pig.setName("lil");
		pig.setWeight(56.6);

		session.save(bird);
		session.save(pig);
		transaction.commit();
	}

	@Test
	public void testThree() {
		Session session = HibernateUtils20191206.getSessiontory("hibernate.cfg.xml").openSession();
		Transaction transaction = session.beginTransaction();

		Bird2 bird = new Bird2();
		bird.setName("yoy2");
		bird.setHeight(102.1);

		Pig2 pig = new Pig2();
		pig.setName("lil2");
		pig.setWeight(57.6);

		session.save(bird);
		session.save(pig);
		transaction.commit();
	}
}
