package fr.istic.taa.jaxrs.models;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;

@Entity()
public class Project implements Serializable {
    
    private Long id;

    private String name;

    private String description;
    private List<Ticket> tickets;


    public Project() {
    }

    public Project(String name, String description) {
        this.name = name;
        this.description = description;
    }


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long getId() {
        return this.id;
    }

    @OneToMany(mappedBy="project")
    public List<Ticket> getTickets() {
        return this.tickets;
    }
 
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Lob 
    @Column(name="description", length=512)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

  

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", tickets='" + getTickets() + "'" +
            "}";
    }

    
    
}
