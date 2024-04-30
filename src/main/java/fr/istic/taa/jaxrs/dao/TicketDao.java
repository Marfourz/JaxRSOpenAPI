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

        String query = "select t from Ticket t where t.project.id = :projectId ORDER BY t.createdAt DESC";

        List<Ticket> tickets = this.entityManager
                                .createQuery(query, Ticket.class)
                                .setParameter("projectId", projectId)
                                .getResultList();
        System.out.println(tickets);
        return tickets;
    }



    public List<Ticket> geTicketsByProjectAndState(Long projectId,TicketState state){
        String query = "select t from Ticket t where t.project.id = :projectId and t.state = :state ORDER BY t.createdAt DESC";

        List<Ticket> tickets = this.entityManager
                                .createQuery(query, Ticket.class)
                                .setParameter("projectId", projectId)
                                .setParameter("state", state)
                                .getResultList();
        System.out.println(tickets);
        return tickets;

    }
    
}
