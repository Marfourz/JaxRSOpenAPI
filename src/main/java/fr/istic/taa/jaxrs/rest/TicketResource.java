package fr.istic.taa.jaxrs.rest;


import java.util.List;

import fr.istic.taa.jaxrs.dao.ProjectDao;
import fr.istic.taa.jaxrs.dao.TicketDao;
import fr.istic.taa.jaxrs.dtos.TicketDto;
import fr.istic.taa.jaxrs.models.Project;
import fr.istic.taa.jaxrs.models.Ticket;
import fr.istic.taa.jaxrs.services.TicketService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;

@Path("/ticket")
@Produces({"application/json"})
@Consumes({"application/json"})
public class TicketResource {
    
    TicketDao ticketDao;
    ProjectDao projectDao;
    TicketService ticketService;
    
    public TicketResource(){
        ticketDao = new TicketDao();
        projectDao = new ProjectDao();
        ticketService = new TicketService();
    }

    @GET
    @Path("/")
    public List<Ticket> getTickets(@QueryParam("projectId") Long projectId){
        List<Ticket> tickets = ticketDao.getTicketsByProject(projectId);
        return tickets;
    }

    @GET
    @Path("/{ticketId}")
    public Ticket getProjectById(@PathParam("ticketId") Long ticketId)  {

        Ticket ticket = ticketDao.findOne(ticketId);
        if(ticket == null){
            throw new NotFoundException("Ticket inexistant.Reverifiez l'id");
        }
        return  ticket;
    }

    @POST
    @Path("/")
    public Ticket create(TicketDto ticketDto)
    {
        return ticketService.create(ticketDto);
    }


    @POST
    @Path("/{projectId}")
    public void updateOne(
        
        @PathParam("projectId") Long projectId,
        @FormParam("name") String name,
        @FormParam("description") String description)
    {
            Project project = projectDao.findOne(projectId);
            if(project == null){
                throw new NotFoundException("Projet inexistant.Reverifiez l'id");
            }
            else{
                project.setName(name);
                project.setDescription(description);
            }
    }

    @DELETE
    @Path("/{projectId}")
    public void delete(@PathParam("projectId") Long projectId)
    {
        Project project = projectDao.findOne(projectId);
        projectDao.delete(project);
        
    }

}
