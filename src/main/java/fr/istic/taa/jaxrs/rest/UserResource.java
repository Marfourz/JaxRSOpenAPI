package fr.istic.taa.jaxrs.rest;


import java.util.List;

import fr.istic.taa.jaxrs.dao.UserDao;
import fr.istic.taa.jaxrs.models.User;
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
    
    

    public UserResource(){
        userDao = new UserDao();
    }

    @GET
    @Path("/")
    public List<User> getUsers(){
        
        List<User> users = userDao.findAll();
        return users;
    }

    @GET
    @Path("/{userId}")
    public User getUserById(@PathParam("userId") Long userId)  {

        User user = userDao.findOne(userId);
        if(user == null){
            throw new NotFoundException("Utilisateur inexistant.Reverifiez l'id");
        }
        return  user;
    }

    @POST
    @Path("/")
    public User create(User user)
    {
        userDao.save(user);
        return user;       
    }


    @DELETE
    @Path("/{userId}")
    public void delete(@PathParam("userId") Long userId)
    {
        User user = userDao.findOne(userId);
        userDao.delete(user);
        
    }

}
