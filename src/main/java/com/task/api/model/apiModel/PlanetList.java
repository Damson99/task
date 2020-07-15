package com.task.api.model.apiModel;

import com.task.api.model.Planet;

import java.util.List;

public class PlanetList
{
    private int count;
    private String next;
    private String previous;
    private List<RawPlanet> results;


    public PlanetList(int count, String next, String previous, List<RawPlanet> results) {
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.results = results;
    }

    public PlanetList() {
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<RawPlanet> getResults() {
        return results;
    }

    public void setResults(List<RawPlanet> results) {
        this.results = results;
    }
}
