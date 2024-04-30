package fr.istic.taa.jaxrs.rest;


import java.util.List;

import fr.istic.taa.jaxrs.dao.UserDao;
import fr.istic.taa.jaxrs.dtos.user.UserDTO;
import fr.istic.taa.jaxrs.models.User;
import fr.istic.taa.jaxrs.services.UserService;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

@Path("/user")
@Produces({"application/json"})
public class UserResource {
    
    UserDao userDao;
    UserService userService;
    
    

    public UserResource(){
        userDao = new UserDao();
        userService = new UserService();
    }

    @GET
    @Path("/")
    public List<UserDTO> getUsers(){
        List<UserDTO> users = userService.findAll();
        return users;
    }

    @GET
    @Path("/{userId}")
    public User getUserById(@PathParam("userId") Long userId)  {
        return userService.findOne(userId);
    }

    @POST
    @Path("/")
    public User create(User user)
    {
        return userService.create(user);   
    }


    @DELETE
    @Path("/{userId}")
    public void delete(@PathParam("userId") Long userId)
    {
        User user = userDao.findOne(userId);
        userDao.delete(user);
        
    }

}
