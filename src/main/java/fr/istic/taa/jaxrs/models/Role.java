package fr.istic.taa.jaxrs.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Role implements Serializable {

    private Long id;
    private String libelle;
    private String code;
    private List<User> users = new ArrayList<User>();

    public Role() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public String getCode() {
        return code;
    }

    @OneToMany(mappedBy = "role")
    public List<User> getUsers() {
        return users;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}