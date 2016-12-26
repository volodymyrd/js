package com.gmail.volodymyrdotsenko.routing.backend.domain.users;

import com.gmail.volodymyrdotsenko.routing.backend.domain.BaseEntity;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Volodymyr Dotsenko on 11/27/16.
 */
@Entity
@Table(name = "USR_ROLES")
public class UserRole extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @NotBlank
    @Column(name = "NAME", length = 100)
    private String name;

    @Column(name = "DESCRIPTION", length = 400)
    private String description;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private Set<User> users;

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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
