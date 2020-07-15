package com.task.api.model.apiModel;

import com.task.api.model.Person;

import java.util.List;

public class PersonList
{
    private int count;
    private String next;
    private String previous;
    private List<RawPerson> results;


    public PersonList(int count, String next, String previous, List<RawPerson> results) {
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.results = results;
    }

    public PersonList() {
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

    public List<RawPerson> getResults() {
        return results;
    }

    public void setResults(List<RawPerson> results) {
        this.results = results;
    }
}
