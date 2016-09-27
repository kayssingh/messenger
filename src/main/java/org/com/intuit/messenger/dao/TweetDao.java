package org.com.intuit.messenger.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.com.intuit.messenger.model.Feed;
import org.com.intuit.messenger.model.Tweet;
import org.com.intuit.messenger.model.User;
import org.com.intuit.messenger.util.HibernateUtil;
import org.hibernate.FlushMode;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.context.internal.ManagedSessionContext;

public class TweetDao {
	
	public TweetDao(){
		
	}
	
	public List<Tweet> getAllTweets(Long authorId) {

		List<Tweet> tweets = new ArrayList<Tweet>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.setFlushMode(FlushMode.MANUAL);
		ManagedSessionContext.bind(session);
	/*	String q = "select t.tweet_desc, t.creation_date from tweets t where author_id = " + authorId;
		SQLQuery query = session.createSQLQuery(q);
		
		 List<Object[]> rows = query.list();
		    for(Object[] row : rows){
		    	Tweet t = new Tweet();
	        	tweets.add(t);
		    }
		session.close();  */
		
		Query query = session.createQuery("from Tweet where authorId = " + authorId);

		Iterator it = query.iterate();
		
		while(it.hasNext()){
			Tweet t = (Tweet)it.next();
			tweets.add(t);
		}
		session.close();

		return tweets;
	}
	
	public void postTweets(String userName, String tweetDesc){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.setFlushMode(FlushMode.MANUAL);
		ManagedSessionContext.bind(session);
		UserDao ud = new UserDao();
		Long authorId = ud.getUserId(userName);
		
		Transaction tx = session.beginTransaction();		
		Tweet tweet = new Tweet();
		tweet.setTweetDesc(tweetDesc);
		tweet.setAuthorId(authorId);
		tweet.setCreationDate(new  Date(System.currentTimeMillis()));
		session.save(tweet);
		tx.commit();
		
		session.close();
		
		
	}

}
