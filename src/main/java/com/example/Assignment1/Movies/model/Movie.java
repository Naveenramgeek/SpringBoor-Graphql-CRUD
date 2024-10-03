package com.example.Assignment1.Movies.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "netflixes")
public class Movie {

    @Id
    private String id;
    private String age_certification;
    private String description;
    private List<String> genres;
    private Double imdb_score;
    private List<String> production_countries;
    private Integer release_year;
    private Double runtime;
    private String title;
    private String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAge_certification() {
        return age_certification;
    }

    public void setAge_certification(String age_certification) {
        this.age_certification = age_certification;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public Double getImdb_score() {
        return imdb_score;
    }

    public void setImdb_score(Double imdb_score) {
        this.imdb_score = imdb_score;
    }

    public List<String> getProduction_countries() {
        return production_countries;
    }

    public void setProduction_countries(List<String> production_countries) {
        this.production_countries = production_countries;
    }

    public Integer getRelease_year() {
        return release_year;
    }

    public void setRelease_year(Integer release_year) {
        this.release_year = release_year;
    }

    public Double getRuntime() {
        return runtime;
    }

    public void setRuntime(Double runtime) {
        this.runtime = runtime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

