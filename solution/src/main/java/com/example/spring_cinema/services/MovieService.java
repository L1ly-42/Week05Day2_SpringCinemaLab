package com.example.spring_cinema.services;

import com.example.spring_cinema.models.Movie;
import com.example.spring_cinema.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public Movie getMovieById(long id){
        return movieRepository.findById(id).get();
    }

    public Movie addNewMovie(Movie movie){
        movieRepository.save(movie);
        return movie;
    }

    public Movie updateMovie(Movie movie){
        movieRepository.save(movie);
        return movie;
    }

    public void deleteMovie(Long id){
        movieRepository.deleteById(id);
    }

    public List<Movie> filterMoviesByDuration(int maxDuration){
        List<Movie> allMovies = movieRepository.findAll();
        List<Movie> filteredMovies = new ArrayList<>();

        for (Movie movie : allMovies) {
            if (movie.getDuration() <= maxDuration){
                filteredMovies.add(movie);
            }
        }

        return filteredMovies;
    }

}
