package com.task.api.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Film")
public class Film
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    @ElementCollection(targetClass = Long.class)
    private List<Long> characters;

    @ElementCollection(targetClass = Long.class)
    private List<Long> planets;


    public Film(long id, String title, List<Long> characters, List<Long> planets) {
        this.id = id;
        this.title = title;
        this.characters = characters;
        this.planets = planets;
    }

    public Film() {
    }

    private Film(long id, String title) {
        this.id = id;
        this.title = title;
    }

    public static Film of(Report report)
    {
        return new Film(report.getFilm_id(), report.getFilm_name());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Long> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Long> characters) {
        this.characters = characters;
    }

    public List<Long> getPlanets() {
        return planets;
    }

    public void setPlanets(List<Long> planets) {
        this.planets = planets;
    }
}
