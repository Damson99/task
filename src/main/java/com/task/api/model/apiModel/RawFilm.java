package com.task.api.model.apiModel;

import java.util.List;

public class RawFilm
{
    private long id;

    private String title;

    private List<String> characters;

    private List<String> planets;


    public RawFilm(long id, String title, List<String> characters, List<String> planets) {
        this.id = id;
        this.title = title;
        this.characters = characters;
        this.planets = planets;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<String> getCharacters() {
        return characters;
    }

    public void setCharacters(List<String> characters) {
        this.characters = characters;
    }

    public List<String> getPlanets() {
        return planets;
    }

    public void setPlanets(List<String> planets) {
        this.planets = planets;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
