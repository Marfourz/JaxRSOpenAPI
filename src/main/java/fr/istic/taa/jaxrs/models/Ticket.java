package fr.istic.taa.jaxrs.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;


@Entity
public class Ticket implements Serializable{

    private Long id;
    private String title;
    private LocalDateTime createdAt;
    private String description;
    private User creator;
    private List<User> assignedUsers ;
    private List <Tag> tags;
    private Project project;
    

    public Ticket() {
    }

    public Ticket(Long id, String title, LocalDateTime createdAt, String description) {
        this.id = id;
        this.title = title;
        this.createdAt = createdAt;
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long getId() {
        return this.id;
    }

    @ManyToOne
    public User getCreator() {
        return this.creator;
    }

    @ManyToMany
    public List<User> getAssignedUsers() {
        return this.assignedUsers;
    }

    @ManyToMany
    public List<Tag> getTags() {
        return this.tags;
    }


    @ManyToOne
    public Project getProject() {
        return this.project;
    }

    public void setProject(Project project) {
        this.project = project;
    }


    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    
    public void setAssignedUsers(List<User> assignedUsers) {
        this.assignedUsers = assignedUsers;
    }

    

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    

    public void setDescription(String description) {
        this.description = description;
    }
   
    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", title='" + getTitle() + "'" +
            ", createdAt='" + getCreatedAt() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }
    
     


}   

