package com.example.Assignment1.Movies.service;

import com.example.Assignment1.Movies.model.Movie;
import com.example.Assignment1.Movies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public List<Movie> getMovieByTitle(String title) {
        return movieRepository.findByTitle(title);
    }

    public Movie addMovie(Movie movie) {
        String title = movie.getTitle();
        List<Movie> movies = new ArrayList<>();
        movies = movieRepository.findByTitle(title);
        if(!movies.isEmpty()){
            return null;
        } else {
            return movieRepository.save(movie);
        }
    }

    public List<Movie> updateMovies(String title, Movie movie) {
        List<Movie> updatedMovies = new ArrayList<>();
        List<Movie> entries = movieRepository.findByTitle(title);
        entries.forEach(entry ->{
            entry.setDescription(movie.getDescription());
            entry.setGenres(movie.getGenres());
            entry.setImdb_score(movie.getImdb_score());
            entry.setRuntime(movie.getRuntime());
            movieRepository.save(entry);
            updatedMovies.add(entry);
        });
        return updatedMovies;
    }

    public boolean deleteMovie(String title) {
        List<Movie> entities = movieRepository.findByTitle(title);
        if (!entities.isEmpty()) {
            movieRepository.deleteAll(entities);
            return true;
        }
        return false;
    }
}
