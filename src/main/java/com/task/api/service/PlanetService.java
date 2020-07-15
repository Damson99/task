package com.task.api.service;

import com.task.api.model.Planet;
import com.task.api.model.apiModel.RawPlanet;
import com.task.api.repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlanetService
{
    @Autowired
    private PlanetRepository planetRepository;

    private List<Long> planetsIdList = new ArrayList<>();


    public List<Planet> getPlanets() {
        return planetRepository.findAll();
    }

    public boolean planetExists(Planet planet)
    {
        return planetRepository.existsById(planet.getId());
    }

    public List<Planet> saveAll(List<Planet> planets)
    {
        return planetRepository.saveAll(planets);
    }

    public List<Planet> transformAndSave(List<RawPlanet> rawPlanets)
    {
        List<Planet> planets = new ArrayList<>();
        for(RawPlanet rp : rawPlanets)
            planets.add(new Planet(rp.getId(), rp.getName(), getIdFromLink(rp.getPeople()), getIdFromLink(rp.getFilms())));
        return saveAll(planets);
    }

    private List<Long> getIdFromLink(List<String> links)
    {
        planetsIdList.clear();
        for(String s : links)
            planetsIdList.add(cutString(s));
        return planetsIdList;
    }

    private Long cutString(String s)
    {
        return Long.parseLong(s.substring(s.length() - 2, s.length() - 1));
    }
}
