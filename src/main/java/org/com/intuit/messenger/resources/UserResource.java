package org.com.intuit.messenger.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.com.intuit.messenger.dao.UserDao;
import org.com.intuit.messenger.model.User;


@Path("users")
public class UserResource {	

	@GET
	@Produces({MediaType.APPLICATION_JSON})
    public Response getUsers() {
		UserDao ud = new UserDao();
		List <User>users = ud.getAllUsers();
		
		GenericEntity<List<User>> list = new GenericEntity<List<User>>(users) {};
		
		return Response.ok(list).build();
    }

}
