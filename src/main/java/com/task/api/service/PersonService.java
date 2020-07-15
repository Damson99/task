package com.task.api.service;

import com.task.api.model.Person;
import com.task.api.model.apiModel.RawPerson;
import com.task.api.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService
{
    @Autowired
    private PersonRepository personRepository;

    private List<Long> peopleIdList = new ArrayList<>();


    public List<Person> getPeople() {
        return personRepository.findAll();
    }

    public boolean personExists(Person person)
    {
        return personRepository.existsById(person.getId());
    }

    public List<Person> saveAll(List<Person> people)
    {
        return personRepository.saveAll(people);
    }

    public List<Person> transformAndSave(List<RawPerson> rawPeople)
    {
        List<Person> people = new ArrayList<>();
        for(RawPerson rp : rawPeople)
            people.add(new Person(rp.getId(), rp.getName(), cutString(rp.getHomeworld()), getIdFromLink(rp.getFilms())));
        return saveAll(people);
    }

    private List<Long> getIdFromLink(List<String> links)
    {
        peopleIdList.clear();
        for(String s : links)
            peopleIdList.add(cutString(s));
        return peopleIdList;
    }

    private Long cutString(String s)
    {
        return Long.parseLong(s.substring(s.length() - 2, s.length() - 1));
    }
}
