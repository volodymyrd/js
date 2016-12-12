package com.gmail.volodymyrdotsenko.routing.backend.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Volodymyr Dotsenko on 12/12/16.
 */
@Entity
@Table(name = "HEROES")
public class Hero extends BaseEntity {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}