package fr.istic.taa.jaxrs.rest;


import java.util.List;

import fr.istic.taa.jaxrs.dao.ProjectDao;
import fr.istic.taa.jaxrs.dtos.ProjectDto;
import fr.istic.taa.jaxrs.models.Project;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

@Path("/project")
@Produces({"application/json"})
public class ProjectResource {
    
    ProjectDao projectDao;
    
    

    public ProjectResource(){
        projectDao = new ProjectDao();
    }

    @GET
    @Path("/")
    public List<Project> getProjects(){
        
        List<Project> projects = projectDao.findAll();
        return projects;
    }

    @GET
    @Path("/{projectId}")
    public Project getProjectById(@PathParam("projectId") Long projectId)  {

        Project project = projectDao.findOne(projectId);
        if(project == null){
            throw new NotFoundException("Projet inexistant.Reverifiez l'id");
        }
        return  project;
    }

    @POST
    @Path("/")
    public Project create(ProjectDto projectDto)
    {
        Project project = new Project(projectDto.getName(), projectDto.getDescription());
        projectDao.save(project);
        return project;       
    }


    @POST
    @Path("/{projectId}")
    public void updateOne(
        
        @PathParam("projectId") Long projectId,
        @FormParam("name") String name,
        @FormParam("description") String description)
    {
            Project project = projectDao.findOne(projectId);
            if(project == null){
                throw new NotFoundException("Projet inexistant.Reverifiez l'id");
            }
            else{
                project.setName(name);
                project.setDescription(description);
            }
    }

    @DELETE
    @Path("/{projectId}")
    public void delete(@PathParam("projectId") Long projectId)
    {
        Project project = projectDao.findOne(projectId);
        projectDao.delete(project);
        
    }

}
