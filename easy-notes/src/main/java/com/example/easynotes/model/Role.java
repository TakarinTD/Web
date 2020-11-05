package com.example.easynotes.model;

import com.fasterxml.jackson.annotation.*;
import java.util.*;
import javax.persistence.*;
import org.springframework.data.jpa.domain.support.*;

@Entity (name = "role")
@EntityListeners (AuditingEntityListener.class)
@JsonIgnoreProperties (value = {"users"})
public class Role {
    @Column (name = "id")
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "name")
    private String name;

    @Column (name = "role")
    private String role;

    @ManyToMany (fetch = FetchType.LAZY,mappedBy = "roles")
    private Set<User> users;

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public Set<User> getUsers () {
        return users;
    }

    public void setUsers (Set<User> users) {
        this.users = users;
    }

    public String getRole () {
        return role;
    }

    public void setRole (String role) {
        this.role = role;
    }
}