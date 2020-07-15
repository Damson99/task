package com.task.api.controller;


import com.querydsl.core.types.Predicate;
import com.task.api.model.*;
import com.task.api.service.FilmService;
import com.task.api.service.PersonService;
import com.task.api.service.PlanetService;
import com.task.api.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

@RestController
@RequestMapping(value = "/api/reports")
public class ReportRestApiController
{
    @Autowired
    private ReportService reportService;

    @Autowired
    private FilmService filmService;

    @Autowired
    private PersonService peopleService;

    @Autowired
    private PlanetService planetService;


    @GetMapping(params = "query")
    public ResponseEntity<Resource<Report>> findReportByPredicate(@QuerydslPredicate(root = Report.class) Predicate predicate)
    {
        return reportService.findByPredicate(predicate).map(this::resourceFromReport).map(this::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(value = "/{report_id}")
    public ResponseEntity<Resource<Report>> getReport(@PathVariable("report_id") long id)
    {
        return reportService.getReportById(id).map(this::resourceFromReport).map(this::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<Resources<Resource<Report>>> getAllReports()
    {
        Resources<Resource<Report>> resources = new Resources<>(reportService.getAllReports().map(this::resourceFromReport).collect(Collectors.toList()));
        resources.add(linkTo(this.getClass()).withSelfRel());
        return ResponseEntity.ok().body(resources);
    }

    @PutMapping(value = "/{report_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateReport(@PathVariable("report_id") long report_id, @RequestBody Report report)
    {
        if(reportService.isReportExists(report_id))
                reportService.updateReport(report_id, report);
        else reportService.saveReport(report);
    }

    @DeleteMapping
    public void deleteAllReports()
    {
        reportService.deleteAll();
    }

    @DeleteMapping("/{report_id}")
    public void deleteReport(@PathVariable("report_id") long id)
    {
        reportService.deleteReport(id);
    }

    private <T> ResponseEntity<T> ok(T reportResource)
    {
        return ResponseEntity.ok().body(reportResource);
    }

    private Resource<Report> resourceFromReport(Report report)
    {
        Resource<Report> reportResource = new Resource<>(report);
        reportResource.add(linkTo(methodOn(this.getClass()).getReport(report.getReport_id())).withSelfRel());
        return reportResource;
    }
}
