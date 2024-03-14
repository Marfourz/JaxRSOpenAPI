package fr.istic.taa.jaxrs.dao;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.models.Message;

public class MessageDao extends AbstractJpaDao<Long, Message> {

    public MessageDao() {
        super(Message.class);
    }
    
}
