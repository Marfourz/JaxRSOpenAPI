package fr.istic.taa.jaxrs.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;


@Entity
public class Ticket implements Serializable{

    private Long id;
    private String title;
    private Date createdAt;
    private String description;

    private User creator;
    private List<User> assignedUsers ;
    private List <Tag> tags;
    private Project project;
    private List<Discussion> discussions;
    
    

    public Ticket() {
    }

   

    public Ticket(String title, String description, User creator, List<User> assignedUsers, List<Tag> tags, Project project) {
        this.title = title;
        this.description = description;
        this.creator = creator;
        this.assignedUsers = assignedUsers;
        this.tags = tags;
        this.project = project;
    }


    @PrePersist
    protected void onCreate() {
        createdAt = new Date(); 
    }


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long getId() {
        return this.id;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
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

    @OneToMany(mappedBy = "ticket", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<Discussion> getDiscussions(){
        return discussions;
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

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    

    public void setDescription(String description) {
        this.description = description;
    }



    public void setDiscussions(List<Discussion> discussions){
        this.discussions = discussions;
    }

    public void addDiscussions(Discussion discussion){
        this.discussions.add(discussion);
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

