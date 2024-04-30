package fr.istic.taa.jaxrs.dtos.ticket;

import java.util.List;

public class TicketCreateDTO {
    private String title;
    private String description;
    private Long projectId;
    private Long userId;
    private List<Long> assignedUserIds ;
    private List <Long> tagIds;


    public TicketCreateDTO(){}
    
    public TicketCreateDTO(String title, String description, Long projectId, Long userId, List<Long> assignedUserIds, List<Long> tagIds) {
        this.title = title;
        this.description = description;
        this.projectId = projectId;
        this.userId = userId;
        this.assignedUserIds = assignedUserIds;
        this.tagIds = tagIds;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getProjectId() {
        return this.projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Long> getAssignedUserIds() {
        return this.assignedUserIds;
    }

    public void setAssignedUserIds(List<Long> assignedUserIds) {
        this.assignedUserIds = assignedUserIds;
    }

    public List<Long> getTagIds() {
        return this.tagIds;
    }

    public void setTagIds(List<Long> tagIds) {
        this.tagIds = tagIds;
    }

    
    
}
