package com.task.api.model.apiModel;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RawPlanet
{
    private long id;

    private String name;

    @JsonProperty("residents")
    private List<String> people;

    private List<String> films;


    public RawPlanet(long id, String name, List<String> people, List<String> films) {
        this.id = id;
        this.name = name;
        this.people = people;
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

    public List<String> getPeople() {
        return people;
    }

    public void setPeople(List<String> people) {
        this.people = people;
    }

    public List<String> getFilms() {
        return films;
    }

    public void setFilms(List<String> films) {
        this.films = films;
    }
}
