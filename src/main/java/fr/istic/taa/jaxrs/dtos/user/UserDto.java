package fr.istic.taa.jaxrs.dtos.user;

import fr.istic.taa.jaxrs.models.enums.Role;

public class UserDTO {
    private Long id;
    private String username;
    private String firstname;
    private String lastname;
    private Role role;


    public UserDTO(Long id, String username, String firstname, String lastname, Role role) {
        this.id = id;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.role = role;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    
    
}
