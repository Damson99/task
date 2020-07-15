package com.task.api.service;

import com.task.api.model.Film;
import com.task.api.model.apiModel.RawFilm;
import com.task.api.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilmService
{
    @Autowired
    private FilmRepository filmRepository;

    private List<Long> filmsIdList = new ArrayList<>();


    public List<Film> getFilms() {
        return filmRepository.findAll();
    }

    public boolean filmExists(Film film)
    {
        return filmRepository.existsById(film.getId());
    }

    public List<Film> saveAll(List<Film> films)
    {
        return filmRepository.saveAll(films);
    }

    public List<Film> transformAndSave(List<RawFilm> rawFilms)
    {
        List<Film> films = new ArrayList<>();
        for(RawFilm rf : rawFilms)
            films.add(new Film(rf.getId(), rf.getTitle(), getIdFromLink(rf.getCharacters()), getIdFromLink(rf.getPlanets())));
        return saveAll(films);
    }

    private List<Long> getIdFromLink(List<String> links)
    {
        filmsIdList.clear();
        for(String s : links)
            filmsIdList.add(cutString(s));
        return filmsIdList;
    }

    private Long cutString(String s)
    {
        return Long.parseLong(s.substring(s.length() - 2, s.length() - 1));
    }
}
