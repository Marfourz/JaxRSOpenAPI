package fr.istic.taa.jaxrs.dtos;

public class ProjectDto {
    private String name;
    private String description;


    public ProjectDto() {
    }

    public ProjectDto(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public ProjectDto name(String name) {
        setName(name);
        return this;
    }

    public ProjectDto description(String description) {
        setDescription(description);
        return this;
    }
    
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

   
