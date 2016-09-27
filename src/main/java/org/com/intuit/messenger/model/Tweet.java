package org.com.intuit.messenger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Tweet implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public long tweetId;
	public String tweetDesc;
	public long authorId;
	public Date creationDate;
	
	public Tweet(){
		
	}
	
	public Tweet(long tweetId, String tweetDesc, long authorId){
		this.tweetId = tweetId;
		this.tweetDesc = tweetDesc;
		this.authorId = authorId;
		this.creationDate = new Date();		
	}
	
	public long getTweetId() {
		return tweetId;
	}
	public void setTweetId(long tweetId) {
		this.tweetId = tweetId;
	}
	public String getTweetDesc() {
		return tweetDesc;
	}
	public void setTweetDesc(String tweetDesc) {
		this.tweetDesc = tweetDesc;
	}
	public long getAuthorId() {
		return authorId;
	}
	public void setAuthorId(long authorId) {
		this.authorId = authorId;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	@Override
	public String toString() {
	    return "Tweet [tweetId=" + tweetId + ", tweetDesc=" + tweetDesc
	        + ", authorId=" + authorId + ", creationDate=" + creationDate + "]";
	}	

}
