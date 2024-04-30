package fr.istic.taa.jaxrs.rest;


import java.util.List;

import fr.istic.taa.jaxrs.dao.DiscussionDao;
import fr.istic.taa.jaxrs.dao.TicketDao;
import fr.istic.taa.jaxrs.models.Discussion;
import fr.istic.taa.jaxrs.models.Ticket;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;

@Path("/discussion")
@Produces({"application/json"})
public class DiscussionResource {
    
    DiscussionDao discussionDao;
    TicketDao ticketDao;
    
    

    public DiscussionResource(){
        discussionDao = new DiscussionDao();
    }

    @GET
    @Path("/")
    public List<Discussion> getDiscussions(){
        
        List<Discussion> discussions = discussionDao.findAll();
        return discussions;
    }

    @GET
    @Path("/{discussionId}")
    public Discussion getDiscussionById(@PathParam("discussionId") Long discussionId)  {

        Discussion discussion = discussionDao.findOne(discussionId);
        if(discussion == null){
            throw new NotFoundException("Discussion inexistant.Reverifiez l'id");
        }
        return  discussion;
    }

    @POST
    @Path("/")
    public Discussion create(@QueryParam("ticketId") Long ticketId)
    {
        Ticket ticket = ticketDao.findOne(ticketId);
        if(ticket == null){
            throw new NotFoundException("Ticket introuvable");
        }
        Discussion discussion = new Discussion(ticket);
        discussionDao.save(discussion);
        return discussion;       
    }



    @DELETE
    @Path("/{discussionId}")
    public void delete(@PathParam("discussionId") Long discussionId)
    {
        Discussion discussion = discussionDao.findOne(discussionId);
        discussionDao.delete(discussion);
        
    }

}
