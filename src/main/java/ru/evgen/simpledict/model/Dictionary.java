package ru.evgen.simpledict.model;

import jakarta.persistence.*;

@Entity
@Table(name = "dictionary")
public class Dictionary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    public Dictionary() {
    }

    public Dictionary(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}