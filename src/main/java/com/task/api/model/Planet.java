package com.task.api.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Planet")
public class Planet
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @ElementCollection(targetClass = Long.class)
    private List<Long> people;

    @ElementCollection(targetClass = Long.class)
    private List<Long> films;


    public Planet(long id, String name, List<Long> people, List<Long> films) {
        this.id = id;
        this.name = name;
        this.people = people;
        this.films = films;
    }

    public Planet() {
    }

    private Planet(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Planet of(Report report)
    {
        return new Planet(report.getPlanet_id(), report.getPlanet_name());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getPeople() {
        return people;
    }

    public void setPeople(List<Long> people) {
        this.people = people;
    }

    public List<Long> getFilms() {
        return films;
    }

    public void setFilms(List<Long> films) {
        this.films = films;
    }
}
