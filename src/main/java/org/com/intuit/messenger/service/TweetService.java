package org.com.intuit.messenger.service;

import java.util.ArrayList;
import java.util.List;

import org.com.intuit.messenger.model.Tweet;


public class TweetService {
	
	public TweetService(){
		
	}
	
	public List<Tweet> getAllTweets(String uName){
		
		List<Tweet> tweetList = new ArrayList<Tweet>();
		
		Tweet t1 = new Tweet(1L, "tweet t1", 45L);
		Tweet t2 = new Tweet(2L, "tweet t2", 56L);
		
		tweetList.add(t1);
		tweetList.add(t2);
		
		return tweetList;
	}

}
