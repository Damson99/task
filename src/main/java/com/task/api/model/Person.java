package com.task.api.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Person")
public class Person
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    private Long homeworld;

    @ElementCollection(targetClass = Long.class)
    private List<Long> films;


    public Person(long id, String name, Long homeworld, List<Long> films) {
        this.id = id;
        this.name = name;
        this.homeworld = homeworld;
        this.films = films;
    }

    private Person(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person() {
    }

    public static Person of(Report report)
    {
        return new Person(report.getCharacter_id(), report.getCharacter_name());
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

    public Long getHomeworld() {
        return homeworld;
    }

    public void setHomeworld(Long homeworld) {
        this.homeworld = homeworld;
    }

    public List<Long> getFilms() {
        return films;
    }

    public void setFilms(List<Long> films) {
        this.films = films;
    }
}
