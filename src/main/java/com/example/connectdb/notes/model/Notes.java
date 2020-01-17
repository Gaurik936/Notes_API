package com.example.connectdb.notes.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.sun.javafx.beans.IDProperty;
//import jdk.internal.vm.annotation.Stable;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Notes")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties( value =  {"Created_at" , "Updated_at"}, allowGetters = true)
public class Notes implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Title")
    @NotBlank
    private String title;

    @Column(name = "Content")
    @NotBlank
    private String content;

   /* @Column(nullable = false, name = "Created_at")
    @CreatedDate
    @Temporal(TemporalType.DATE)
    private Date Created_at;

    @Column(nullable = false, updatable = true, name = "Updated_at")
    @LastModifiedDate
    @Temporal(TemporalType.DATE)
    private Date Updated_at;*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    /*public Date getCreated_at() {
        return Created_at;
    }

    public void setCreated_at(Date created_at) {
        Created_at = created_at;
    }

    public Date getUpdated_at() {
        return Updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        Updated_at = updated_at;
    }*/


}