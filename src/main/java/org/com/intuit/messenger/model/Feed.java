package org.com.intuit.messenger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Feed  implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String tweetDesc;
	private String authorName;
	private Date postedDate;
	
	public String getTweetDesc() {
		return tweetDesc;
	}
	public void setTweetDesc(String tweetDesc) {
		this.tweetDesc = tweetDesc;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public Date getPostedDate() {
		return postedDate;
	}
	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}
	
	@Override
	public String toString() {
	    return "Feed [tweetDesc" + tweetDesc + ", authorName=" + authorName
	        + ", postedDate=" + postedDate + "]";
	}	

}
