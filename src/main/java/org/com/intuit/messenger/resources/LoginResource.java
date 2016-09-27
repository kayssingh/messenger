package org.com.intuit.messenger.resources;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.com.intuit.messenger.dao.FeedDao;
import org.com.intuit.messenger.dao.LoginDao;
import org.com.intuit.messenger.dao.TweetDao;
import org.com.intuit.messenger.model.Feed;

@Path("twitter")
public class LoginResource {
	
	public String uName = null;

	@POST
	@Path("/feeds")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML })
	public Response login(@FormParam("username") String username, @FormParam("userpass") String password) {
		uName = username;
		try {
			if(LoginDao.validate(username, password)){
				
				FeedDao fd = new FeedDao();
				List <Feed> feeds = fd.getFeeds(username);				
				GenericEntity<List<Feed>> list = new GenericEntity<List<Feed>>(feeds) {};
				
				return Response.ok(list).build();
		    }
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
		return Response.ok("You are not a Valid User").build();
	}
	
	public String getUserName(){
		return uName;
	}
	
}
