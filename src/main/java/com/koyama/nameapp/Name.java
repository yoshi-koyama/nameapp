package com.koyama.nameapp;

public class Name {

    private Integer id;

    private String name;

    public Name(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
