package com.task.api.model.apiModel;

import java.util.List;

public class FilmList
{
    private int count;
    private String next;
    private String previous;
    private List<RawFilm> results;


    public FilmList(int count, String next, String previous, List<RawFilm> results) {
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.results = results;
    }

    public FilmList() {
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

    public List<RawFilm> getResults() {
        return results;
    }

    public void setResults(List<RawFilm> results) {
        this.results = results;
    }
}
