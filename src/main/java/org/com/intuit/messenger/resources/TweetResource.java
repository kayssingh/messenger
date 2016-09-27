package org.com.intuit.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.com.intuit.messenger.dao.FeedDao;
import org.com.intuit.messenger.dao.LoginDao;
import org.com.intuit.messenger.dao.TweetDao;
import org.com.intuit.messenger.dao.UserDao;
import org.com.intuit.messenger.model.Feed;
import org.com.intuit.messenger.model.Tweet;
import org.com.intuit.messenger.service.TweetService;

@Path("tweets")
public class TweetResource {
	
	@GET
	@Path("/getTweets")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getTweets(@PathParam("username")String username) {
		UserDao ud = new UserDao();
		Long userId = ud.getUserId(username);	
		TweetDao td = new TweetDao();
		List <Tweet>tweets = td.getAllTweets(userId);
          
	    GenericEntity<List<Tweet>> entity
	        = new GenericEntity<List<Tweet>>(tweets) {};

	    return Response.ok(entity).build();
		
    }
	
}
