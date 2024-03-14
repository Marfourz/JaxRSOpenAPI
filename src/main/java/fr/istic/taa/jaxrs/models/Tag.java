package fr.istic.taa.jaxrs.models;

import java.io.Serializable;

import javax.annotation.processing.Generated;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tag implements Serializable {

    private Long id;
    private String code;
    private String label;


    public Tag() {
    }

    public Tag(Long id, String code, String label) {
        this.id = id;
        this.code = code;
        this.label = label;
    }


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }



}
