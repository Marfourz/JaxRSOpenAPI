package fr.istic.taa.jaxrs.dao;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.models.Ticket;

public class TicketDao extends AbstractJpaDao<Long,Ticket> {

    public TicketDao() {
        super(Ticket.class);
        //TODO Auto-generated constructor stub
    }
    
}
