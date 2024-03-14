package fr.istic.taa.jaxrs.models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Message implements Serializable{

    private Long id;
    private String message;
    private Discussion discussion;
    private User user;


    public Message() {
    }

    public Message(Long id, Discussion discussion, User user) {
        this.id = id;
        this.discussion = discussion;
        this.user = user;
    }


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long getId() {
        return this.id;
    }

    @ManyToOne()
    public Discussion getDiscussion() {
        return this.discussion;
    }

    @ManyToOne()
    public User getUser() {
        return this.user;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public void setDiscussion(Discussion discussion) {
        this.discussion = discussion;
    }
   
    public void setUser(User user) {
        this.user = user;
    }
    


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", message='" + getMessage() + "'" +
            ", discussion='" + getDiscussion() + "'" +
            ", user='" + getUser() + "'" +
            "}";
    }



}
