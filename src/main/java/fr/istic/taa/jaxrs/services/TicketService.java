package fr.istic.taa.jaxrs.services;

import java.util.List;

import fr.istic.taa.jaxrs.dao.ProjectDao;
import fr.istic.taa.jaxrs.dao.TagDao;
import fr.istic.taa.jaxrs.dao.TicketDao;
import fr.istic.taa.jaxrs.dao.UserDao;
import fr.istic.taa.jaxrs.dtos.TicketDto;
import fr.istic.taa.jaxrs.models.Project;
import fr.istic.taa.jaxrs.models.Tag;
import fr.istic.taa.jaxrs.models.Ticket;
import fr.istic.taa.jaxrs.models.User;

public class TicketService {
    
    private TicketDao ticketDao;
    private ProjectDao projectDao;
    private UserDao userDao;
    private TagDao tagDao;
    
    public TicketService(){
        ticketDao = new TicketDao();
        projectDao = new ProjectDao();
        userDao = new UserDao();
        tagDao = new TagDao();
    }

    

    public Ticket create(TicketDto ticketDto){

        Project project = projectDao.getReference(ticketDto.getProjectId());
        User creator = userDao.getReference(ticketDto.getProjectId());
        List<Tag> tags = tagDao.findManyById(ticketDto.getTagIds());

        List<User> assignedUsers = userDao.findManyById(ticketDto.getAssignedUserIds());

        Ticket ticket = new Ticket();

        ticket.setTitle(ticketDto.getTitle());
        ticket.setDescription(ticketDto.getDescription());
        ticket.setAssignedUsers(assignedUsers);
        ticket.setCreator(creator);
        ticket.setTags(tags);
        ticket.setProject(project);


        ticketDao.save(ticket);

        return ticket;
    }



}
