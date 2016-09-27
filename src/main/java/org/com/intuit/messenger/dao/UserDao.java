package org.com.intuit.messenger.dao;

import java.util.ArrayList;
import java.util.List;

import org.com.intuit.messenger.model.User;
import org.com.intuit.messenger.util.HibernateUtil;
import org.hibernate.FlushMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.context.internal.ManagedSessionContext;

public class UserDao {
	
	public UserDao() {

	}

	public List<User> getAllUsers() {

		List<User> userList = new ArrayList<User>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.setFlushMode(FlushMode.MANUAL);
		ManagedSessionContext.bind(session);
		Query query = session.createQuery("from User");
		List<User> list = query.list();
		User user1 = (User) list.get(0);
		User user2 = (User) list.get(1);
		userList.add(user1);
		userList.add(user2);
		session.close();

		return userList;
	}

	public long getUserId(String username) {
		Long userId = null;

		try {

			Session session = HibernateUtil.getSessionFactory().openSession();
			session.setFlushMode(FlushMode.MANUAL);
			ManagedSessionContext.bind(session);

			Query query = session.createQuery("from User where userName = '" + username + "'");

			List result = (List) query.list();
			User u = (User) result.get(0);
			userId = u.getUserId();

		} catch (Exception e) {
			System.out.println(e);
		}

		return userId;
	}

}
