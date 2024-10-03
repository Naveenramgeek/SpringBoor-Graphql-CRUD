package com.example.Assignment1.Movies.resolver;

import com.example.Assignment1.Movies.model.Movie;
import com.example.Assignment1.Movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class MovieResolver {

    @Autowired
    private MovieService movieService;

    @QueryMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @QueryMapping
    public List<Movie> getMovieByTitle(@Argument String title) {
        return movieService.getMovieByTitle(title);
    }

    @MutationMapping
    public Movie addMovie(@Argument String age_certification, @Argument String description, @Argument List<String> genres,
                          @Argument Double imdb_score, @Argument List<String> production_countries, @Argument Integer release_year,
                          @Argument Double runtime, @Argument String title, @Argument String type) {
        Movie movie = new Movie();
        movie.setAge_certification(age_certification);
        movie.setDescription(description);
        movie.setGenres(genres);
        movie.setImdb_score(imdb_score);
        movie.setProduction_countries(production_countries);
        movie.setRelease_year(release_year);
        movie.setRuntime(runtime);
        movie.setTitle(title);
        movie.setType(type);
        return movieService.addMovie(movie);
    }

    @MutationMapping
    public List<Movie> updateMovies(@Argument String description, @Argument List<String> genres, @Argument Double imdb_score,
                             @Argument Double runtime, @Argument String title) {
        Movie movie = new Movie();
        movie.setDescription(description);
        movie.setGenres(genres);
        movie.setImdb_score(imdb_score);
        movie.setRuntime(runtime);
        movie.setTitle(title);
        return movieService.updateMovies(title, movie);
    }

    @MutationMapping
    public String deleteMovie(@Argument String title) {
        if(movieService.deleteMovie(title)){
            return title+" deleted successfully from the database";
        } else {
            return "Failed to delete "+title+" from the database, possibly no movie or show with the title "+ title;
        }
    }
}
