package com.task.api.service;

import com.querydsl.core.types.Predicate;
import com.task.api.model.Film;
import com.task.api.model.Person;
import com.task.api.model.Planet;
import com.task.api.model.Report;
import com.task.api.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class ReportService
{
    @Autowired
    private ReportRepository reportRepository;

    private List<Report> createdReports = new ArrayList<>();


    public Optional<Report> getReportById(long id)
    {
        return reportRepository.findById(id);
    }

    public Stream<Report> getAllReports()
    {
        return reportRepository.findAll().stream();
    }

    public Report saveReport(Report report)
    {
        return reportRepository.save(report);
    }

    public boolean isReportExists(long report_id)
    {
        return reportRepository.findById(report_id).isPresent();
    }

    public void updateReport(long report_id, Report report)
    {
        report.setReport_id(report_id);
        reportRepository.save(report);
    }

    public void deleteReport(long id)
    {
        reportRepository.deleteById(id);
    }

    public Optional<Report> findByPredicate(Predicate predicate)
    {
        return reportRepository.findOne(predicate);
    }

    public void deleteAll()
    {
        reportRepository.deleteAll();
    }

    public void saveReports(List<Report> reportList)
    {
        reportRepository.saveAll(reportList);
    }

    public void createReports(List<Film> films, List<Person> people, List<Planet> planets)
    {
        for(Film film : films)
            for(Person person : people)
                for(Planet planet : planets)
                    if(film.getPlanets().contains(planet.getId()) && film.getCharacters().contains(person.getId()))
                        createdReports.add(new Report.ReportBuilder()
                                .setFilm_id(film.getId())
                                .setFilm_name(film.getTitle())
                                .setCharacter_id(person.getId())
                                .setCharacter_name(person.getName())
                                .setPlanet_id(planet.getId())
                                .setPlanet_name(planet.getName()).build());

        reportRepository.saveAll(createdReports);
    }
}
