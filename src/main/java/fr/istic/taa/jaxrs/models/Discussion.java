package fr.istic.taa.jaxrs.models;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Discussion implements Serializable {

    private Long id;

    private List<Message> messages;

    private Ticket ticket;

    public Discussion() {
    }

    public Discussion(Long id, List<Message> messages, Ticket ticket) {
        this.id = id;
        this.messages = messages;
        this.ticket = ticket;
    }


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long getId() {
        return this.id;
    }

    @OneToMany(mappedBy = "discussion")
    public List<Message> getMessages() {
        return this.messages;
    }

    @ManyToOne()
    public Ticket getTicket() {
        return this.ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void setId(Long id) {
        this.id = id;
    }

   

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }



    
}
