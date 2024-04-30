package fr.istic.taa.jaxrs.dao;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.models.Discussion;

public class DiscussionDao extends AbstractJpaDao<Long, Discussion> {

    public DiscussionDao() {
        super(Discussion.class);
    }
    
}
