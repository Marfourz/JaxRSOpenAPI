package fr.istic.taa.jaxrs.dao;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.models.Project;

public class ProjectDao extends AbstractJpaDao<Long,Project> {

    public ProjectDao(){
        super(Project.class);
    }
}
