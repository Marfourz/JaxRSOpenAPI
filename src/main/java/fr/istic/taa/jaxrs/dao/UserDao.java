package fr.istic.taa.jaxrs.dao;
import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.models.User;

public class UserDao extends AbstractJpaDao<Long,User> {

    public UserDao() {
        super(User.class);
    }}
