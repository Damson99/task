package com.task.api.model.apiModel;

import java.util.List;

public class RawPerson
{
    private long id;

    private String name;

    private String homeworld;

    private List<String> films;


    public RawPerson(long id, String name, String homeworld, List<String> films) {
        this.id = id;
        this.name = name;
        this.homeworld = homeworld;
        this.films = films;
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

    public String getHomeworld() {
        return homeworld;
    }

    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }

    public List<String> getFilms() {
        return films;
    }

    public void setFilms(List<String> films) {
        this.films = films;
    }
}
