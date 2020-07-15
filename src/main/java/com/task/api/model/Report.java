package com.task.api.model;

import com.task.api.validator.NameValid;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Report")
public class Report
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_id")
    private long report_id;

    @NotNull
    @Column(name = "film_id")
    private long film_id;

    @NameValid
    @Size(min = 3, max = 50)
    @Column(name = "film_name")
    private String film_name;

    @NotNull
    @Column(name = "character_id")
    private long character_id;

    @NameValid
    @Size(min = 3, max = 50)
    @Column(name = "character_name")
    private String character_name;

    @NotNull
    @Column(name = "planet_id")
    private long planet_id;

    @NameValid
    @Size(min = 3, max = 50)
    @Column(name = "planet_name")
    private String planet_name;


    public Report(long film_id, String film_name, long character_id, String character_name, long planet_id, String planet_name) {
        this.film_id = film_id;
        this.film_name = film_name;
        this.character_id = character_id;
        this.character_name = character_name;
        this.planet_id = planet_id;
        this.planet_name = planet_name;
    }

    private Report(long report_id, long film_id, String film_name, long character_id, String character_name, long planet_id, String planet_name) {
        this.report_id = report_id;
        this.film_id = film_id;
        this.film_name = film_name;
        this.character_id = character_id;
        this.character_name = character_name;
        this.planet_id = planet_id;
        this.planet_name = planet_name;
    }

    public Report() {
    }

    public static class ReportBuilder
    {
        private long report_id;
        private long film_id;
        private String film_name;
        private long character_id;
        private String character_name;
        private long planet_id;
        private String planet_name;

        public ReportBuilder setReport_id(long report_id) {
            this.report_id = report_id;
            return this;
        }

        public ReportBuilder setFilm_id(long film_id) {
            this.film_id = film_id;
            return this;
        }

        public ReportBuilder setFilm_name(String film_name) {
            this.film_name = film_name;
            return this;
        }

        public ReportBuilder setCharacter_id(long character_id) {
            this.character_id = character_id;
            return this;
        }

        public ReportBuilder setCharacter_name(String character_name) {
            this.character_name = character_name;
            return this;
        }

        public ReportBuilder setPlanet_id(long planet_id) {
            this.planet_id = planet_id;
            return this;
        }

        public ReportBuilder setPlanet_name(String planet_name) {
            this.planet_name = planet_name;
            return this;
        }

        public Report build()
        {
            return new Report(report_id, film_id, film_name, character_id, character_name, planet_id, planet_name);
        }
    }

    public long getReport_id() {
        return report_id;
    }

    public void setReport_id(long report_id) {
        this.report_id = report_id;
    }

    public long getFilm_id() {
        return film_id;
    }

    public void setFilm_id(long film_id) {
        this.film_id = film_id;
    }

    public String getFilm_name() {
        return film_name;
    }

    public void setFilm_name(String film_name) {
        this.film_name = film_name;
    }

    public long getCharacter_id() {
        return character_id;
    }

    public void setCharacter_id(long character_id) {
        this.character_id = character_id;
    }

    public String getCharacter_name() {
        return character_name;
    }

    public void setCharacter_name(String character_name) {
        this.character_name = character_name;
    }

    public long getPlanet_id() {
        return planet_id;
    }

    public void setPlanet_id(long planet_id) {
        this.planet_id = planet_id;
    }

    public String getPlanet_name() {
        return planet_name;
    }

    public void setPlanet_name(String planet_name) {
        this.planet_name = planet_name;
    }

    @Override
    public String toString() {
        return "Report{" +
                "report_id=" + report_id +
                ", film_id=" + film_id +
                ", film_name='" + film_name + '\'' +
                ", character_id=" + character_id +
                ", character_name='" + character_name + '\'' +
                ", planet_id=" + planet_id +
                ", planet_name='" + planet_name + '\'' +
                '}';
    }
}
