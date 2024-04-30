package fr.istic.taa.jaxrs.dtos.ticket;

import fr.istic.taa.jaxrs.models.User;
import fr.istic.taa.jaxrs.models.Tag;
import java.util.List;
import java.util.Date;

public class TicketDTO {

    private Long id;
    private String title;
    private Date createdAt;
    private String description;

    private User creator;
    private List<User> assignedUsers ;
    private List <Tag> tags;


    public TicketDTO(){}

    public TicketDTO(Long id, String title, String description, Date createdAt, User creator, List<User> assignedUsers, List<Tag> tags) {
        this.id = id;
        this.title = title;
        this.createdAt = createdAt;
        this.description = description;
        this.creator = creator;
        this.assignedUsers = assignedUsers;
        this.tags = tags;
    }
   


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getCreator() {
        return this.creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public List<User> getAssignedUsers() {
        return this.assignedUsers;
    }

    public void setAssignedUsers(List<User> assignedUsers) {
        this.assignedUsers = assignedUsers;
    }

    public List<Tag> getTags() {
        return this.tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    
   
    
}
