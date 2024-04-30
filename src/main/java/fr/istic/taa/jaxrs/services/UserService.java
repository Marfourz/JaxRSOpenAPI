package fr.istic.taa.jaxrs.services;
import java.util.ArrayList;
import java.util.List;

import fr.istic.taa.jaxrs.dao.UserDao;
import fr.istic.taa.jaxrs.dtos.user.UserDTO;
import fr.istic.taa.jaxrs.models.User;
import jakarta.ws.rs.NotFoundException;

public class UserService {

    private UserDao userDao;


    public UserService(){
        userDao = new UserDao();
    }

    public List<UserDTO>findAll(){
        List<User> users = userDao.findAll();
        return mapToDTOList(users);
    }

    public User findOne(Long userId)  {
        User user = userDao.findOne(userId);
        if(user == null){
            throw new NotFoundException("Utilisateur inexistant.Reverifiez l'id");
        }
        return  user;
    }

    public User create(User user)
    {
        userDao.save(user);
        return user;       
    }
    
    private UserDTO mapToDTO(User user) {
        return new UserDTO(user.getId(), 
        user.getUsername(), 
        user.getFirstname(),
        user.getLastname(),
        user.getRole());
    }

    private List<UserDTO> mapToDTOList(List<User> users) {
        List<UserDTO> userDTOs = new ArrayList<>();
        for (User user : users) {
            userDTOs.add(mapToDTO(user));
        }
        return userDTOs;
    }
}
