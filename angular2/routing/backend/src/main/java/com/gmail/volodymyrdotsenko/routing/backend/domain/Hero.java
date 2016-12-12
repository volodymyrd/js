package com.gmail.volodymyrdotsenko.routing.backend.domain;

/**
 * Created by Volodymyr Dotsenko on 12/12/16.
 */
public class Hero {
    private Long id;
    private String name;

    public Hero() {
    }

    public Hero(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
