package org.com.intuit.messenger.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.com.intuit.messenger.model.Feed;
import org.com.intuit.messenger.util.HibernateUtil;
import org.hibernate.FlushMode;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.context.internal.ManagedSessionContext;

public class FeedDao {
	
	public List<Feed> getFeeds(String username){
		
		List<Feed> feeds = new ArrayList<Feed>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.setFlushMode(FlushMode.MANUAL);
	    ManagedSessionContext.bind(session);
        String q = "select t.tweet_desc, u1.USER_NAME, t.creation_date FROM tweets t, user_follower uf, user_profile u1, user_profile u2"
        		    + " WHERE t.author_id = uf.usr_id and uf.usr_id = u1.user_id AND uf.follower_id = u2.user_id and " 
        		    + " u2.user_name = '" + username + "'";

	    SQLQuery query = session.createSQLQuery(q);
	
	    List<Object[]> rows = query.list();
	    for(Object[] row : rows){
	    	Feed f = new Feed();
	    	f.setTweetDesc(row[0].toString());
	    	f.setAuthorName(row[1].toString());
	        f.setPostedDate((Date) row[2]);
        	feeds.add(f);
	    }
        session.close();
		
		return feeds;
	}

}
