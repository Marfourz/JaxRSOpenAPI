package fr.istic.taa.jaxrs.dao;

import java.util.List;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.models.Ticket;
import fr.istic.taa.jaxrs.models.enums.TicketState;

public class TicketDao extends AbstractJpaDao<Long,Ticket> {

    public TicketDao() {
        super(Ticket.class);
       
    }

    public List<Ticket> getTicketsByProject(Long projectId){

        String query = "select t from Ticket as t where t.projectId = :projectId";

        List<Ticket> tickets = this.entityManager
                                .createQuery(query, Ticket.class)
                                .setParameter("projectId", projectId)
                                .getResultList();
        return tickets;
    }



    public List<Ticket> geTicketsByStatus(TicketState state){
        String query = "select t from Ticket as t where t.state = :state";

        List<Ticket> tickets = this.entityManager
                                    .createQuery(query, Ticket.class)
                                    .setParameter("state", state)
                                    .getResultList();
        return tickets;

    }
    
}
