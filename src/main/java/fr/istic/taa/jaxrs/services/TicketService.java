package fr.istic.taa.jaxrs.services;

import java.util.ArrayList;
import java.util.List;

import fr.istic.taa.jaxrs.dao.ProjectDao;
import fr.istic.taa.jaxrs.dao.TagDao;
import fr.istic.taa.jaxrs.dao.TicketDao;
import fr.istic.taa.jaxrs.dao.UserDao;
import fr.istic.taa.jaxrs.dtos.ticket.TicketCreateDTO;
import fr.istic.taa.jaxrs.dtos.ticket.TicketDTO;
import fr.istic.taa.jaxrs.models.Project;
import fr.istic.taa.jaxrs.models.Tag;
import fr.istic.taa.jaxrs.models.Ticket;
import fr.istic.taa.jaxrs.models.User;
import fr.istic.taa.jaxrs.models.enums.Role;
import fr.istic.taa.jaxrs.models.enums.TicketState;

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

    

    public Ticket create(TicketCreateDTO ticketDto){

        Project project = projectDao.getReference(ticketDto.getProjectId());
        List<Tag> tags = tagDao.findManyById(ticketDto.getTagIds());

        List<User> assignedUsers = userDao.findManyById(ticketDto.getAssignedUserIds());

        Ticket ticket = new Ticket();

        
        User creator = userDao.findByUsername("Admin");

        if(creator == null){
            creator = new User("Admin", "BOUKARI", "Marfourz", Role.ADMIN);
            userDao.save(creator);
        }

        ticket.setTitle(ticketDto.getTitle());
        ticket.setDescription(ticketDto.getDescription());
        ticket.setAssignedUsers(assignedUsers);
        ticket.setCreator(creator);
        ticket.setTags(tags);
        ticket.setProject(project);


        ticketDao.save(ticket);

        return ticket;
    }


    public List<TicketDTO> findByProject(Long projectId, TicketState state){
        List<Ticket> tickets = new ArrayList<Ticket>();

        if(state == null){
            tickets = ticketDao.getTicketsByProject(projectId);
        }
        else {
            tickets = ticketDao.geTicketsByProjectAndState(projectId, state);
        }
        return mapToDTOList(tickets);
    }

    public List<TicketDTO> findByProjectAndState(Long projectId, TicketState state){
        List<Ticket> tickets = ticketDao.geTicketsByProjectAndState(projectId, state);
        return mapToDTOList(tickets);
    }



    private TicketDTO mapToDTO(Ticket ticket) {
        return new TicketDTO(
            ticket.getId(), 
            ticket.getTitle(), 
            ticket.getDescription(),
            ticket.getState(),
            ticket.getCreatedAt(),
            ticket.getCreator(),
            ticket.getAssignedUsers(),
            ticket.getTags()
        );
    }

    private List<TicketDTO> mapToDTOList(List<Ticket> tickets) {
        List<TicketDTO> ticketDTOs = new ArrayList<>();
        for (Ticket ticket : tickets) {
            ticketDTOs.add(mapToDTO(ticket));
        }
        return ticketDTOs;
    }
}
