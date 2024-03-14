package fr.istic.taa.jaxrs.rest;

import java.util.List;

import fr.istic.taa.jaxrs.dao.UserDao;
import fr.istic.taa.jaxrs.models.User;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/user")
public class UserResource {
    
    private UserDao userDao = new UserDao();

    @GET
    @Path("/") 
    List<User> getUsers(){
        List<User> users = userDao.findAll();
        return users;
    }


    @GET
    @Path("/{userId}")
    public User getUserById(@PathParam("userId") Long userId)  {
        User user = userDao.findOne(userId);
        return  user;
    }


}
