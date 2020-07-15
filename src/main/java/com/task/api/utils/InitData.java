package com.task.api.utils;

import com.task.api.model.Film;
import com.task.api.model.Person;
import com.task.api.model.Planet;
import com.task.api.model.apiModel.FilmList;
import com.task.api.model.apiModel.PersonList;
import com.task.api.model.apiModel.PlanetList;
import com.task.api.service.FilmService;
import com.task.api.service.PersonService;
import com.task.api.service.PlanetService;
import com.task.api.service.ReportService;
import com.task.api.validator.exceptions.NoDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Component
public class InitData
{
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private FilmService filmService;

    @Autowired
    private PlanetService planetService;

    @Autowired
    private PersonService peopleService;

    @Autowired
    private ReportService reportService;

    private HttpServletRequest request;

    private static final String FILMS_API = "http://192.168.99.100:8080/api/films";
    private static final String PEOPLE_API = "http://192.168.99.100:8080/api/people";
    private static final String PLANETS_API = "http://192.168.99.100:8080/api/planets";

    private FilmList films = new FilmList();
    private PersonList people = new PersonList();
    private PlanetList planets = new PlanetList();

    private List<Film> savedFilms = new ArrayList<>();
    private List<Person> savedPeople = new ArrayList<>();
    private List<Planet> savedPlanets = new ArrayList<>();


    @Bean
    public void init()
    {
        films = restTemplate.getForObject(FILMS_API, FilmList.class);
        people = restTemplate.getForObject(PEOPLE_API, PersonList.class);
        planets = restTemplate.getForObject(PLANETS_API, PlanetList.class);

        saveData(films);
        saveData(people);
        saveData(planets);
        reportService.createReports(savedFilms, savedPeople, savedPlanets);
    }

    public <T> void saveData(T list)
    {
        if(list instanceof FilmList)
        {
            if(films.getResults().isEmpty())
                throw new NoDataException("Invalid films data");
            else savedFilms = filmService.transformAndSave(films.getResults());
        }

        if(list instanceof PersonList)
        {
            if(people.getResults().isEmpty())
                throw new NoDataException("Invalid people data");
            else savedPeople = peopleService.transformAndSave(people.getResults());
        }

        if(list instanceof PlanetList)
        {
            if(planets.getResults().isEmpty())
                throw new NoDataException("Invalid planets data");
            else savedPlanets = planetService.transformAndSave(planets.getResults());
        }
    }
}
