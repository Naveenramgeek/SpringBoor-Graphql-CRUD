package com.example.Assignment1.Movies.repository;

import com.example.Assignment1.Movies.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {
    List<Movie> findByTitle(String title);
}
