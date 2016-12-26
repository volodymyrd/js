package com.gmail.volodymyrdotsenko.routing.backend.domain.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gmail.volodymyrdotsenko.routing.backend.domain.BaseEntity;

import javax.persistence.*;

/**
 * Created by Volodymyr Dotsenko on 12/26/16.
 */
@Entity
@Table(name = "USR_PROFILES")
public class UserProfile extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REF_USER_ID")
    @JsonIgnore
    private User user;

    @Column(name = "NAME", nullable = false, length = 100)
    private String name;

    @Column(name = "DESCRIPTION", length = 400)
    private String description;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}