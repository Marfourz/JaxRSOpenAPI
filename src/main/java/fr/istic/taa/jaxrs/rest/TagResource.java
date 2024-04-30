package fr.istic.taa.jaxrs.rest;


import java.util.List;

import fr.istic.taa.jaxrs.dao.TagDao;
import fr.istic.taa.jaxrs.models.Tag;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

@Path("/tag")
@Produces({"application/json"})
public class TagResource {
    
    TagDao tagDao;
    
    

    public TagResource(){
        tagDao = new TagDao();
    }

    @GET
    @Path("/")
    public List<Tag> getTags(){
        
        List<Tag> tags = tagDao.findAll();
        return tags;
    }

    @GET
    @Path("/{tagId}")
    public Tag getTagById(@PathParam("tagId") Long tagId)  {

        Tag tag = tagDao.findOne(tagId);
        if(tag == null){
            throw new NotFoundException("Utilisateur inexistant.Reverifiez l'id");
        }
        return  tag;
    }

    @POST
    @Path("/")
    public Tag create(Tag tag)
    {
        tagDao.save(tag);
        return tag;       
    }


    @DELETE
    @Path("/{tagId}")
    public void delete(@PathParam("tagId") Long tagId)
    {
        Tag tag = tagDao.findOne(tagId);
        tagDao.delete(tag);
        
    }

}
