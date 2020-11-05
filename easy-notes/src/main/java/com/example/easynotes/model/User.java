package com.example.easynotes.model;

import com.fasterxml.jackson.annotation.*;
import java.util.*;
import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Transient;
import org.springframework.data.annotation.*;
import org.springframework.data.jpa.domain.support.*;
import org.springframework.stereotype.*;

@Entity (name = "user")
@EntityListeners (AuditingEntityListener.class)
@JsonIgnoreProperties (value = {"createdAt", "updatedAt", "roles", "passwordConfirm" })
public class User {
    @Column (name = "id")
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "username")
    private String userName;

    @Column (name = "password")
    private String password;

    @Column (name = "fullname")
    private String fullName;

    @Column (name = "active")
    private int status;

    @Column (nullable = false, updatable = false)
    @Temporal (TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column (nullable = false)
    @Temporal (TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    @Transient
    private String passwordConfirm;

    @ManyToMany (fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable (name = "user_role", joinColumns = @JoinColumn (name = "user_id"), inverseJoinColumns = @JoinColumn (name = "role_id"))
    private Set<Role> roles;

    @Column (name = "roleName")
    private String roleName;


//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "nUsers",cascade = CascadeType.ALL)
//    private List<Note> notes;

    public User () {
    }

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getUserName () {
        return userName;
    }

    public void setUserName (String username) {
        this.userName = username;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    public String getPasswordConfirm () {
        return passwordConfirm;
    }

    public void setPasswordConfirm (String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public Set<Role> getRoles () {
        return roles;
    }

    public void setRoles (Set<Role> roles) {
        this.roles = roles;
    }

    public int getStatus () {
        return status;
    }

    public void setStatus (int status) {
        this.status = status;
    }

    public Date getCreatedAt () {
        return createdAt;
    }

    public void setCreatedAt (Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt () {
        return updatedAt;
    }

    public void setUpdatedAt (Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getFullName () {
        return fullName;
    }

    public void setFullName (String fullName) {
        this.fullName = fullName;
    }

    public String getRoleName () {
        return roleName;
    }

    public void setRoleName (String roleName) {
        this.roleName = roleName;
    }

    //    public List<Note> getNotes () {
//        return notes;
//    }
//
//    public void setNotes (List<Note> notes) {
//        this.notes = notes;
//    }
}