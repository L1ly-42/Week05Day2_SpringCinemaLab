package com.example.cinema.controllers;

import com.example.cinema.models.Movie;
import com.example.cinema.models.MovieDTO;
import com.example.cinema.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping
    public List<Movie> getAllMovies(){
    List<Movie> movies = movieService.getAllMovies();
    return movies;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Movie>> getMovieById(@PathVariable Long id) {
        Optional<Movie> newMovie = movieService.getMovieById(id);
        if(newMovie.isPresent()){ return new ResponseEntity<>(newMovie, HttpStatus.OK);}
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
        @PostMapping
        public ResponseEntity<Movie> addNewMovie(@RequestBody Movie movie){
            movieService.addMovie(movie);
            return new ResponseEntity<>(movie, HttpStatus.CREATED);
        }

        @PutMapping(value = "/{id}")
        public ResponseEntity<Movie> updateMovie(@RequestBody MovieDTO movieDTO, @PathVariable long id){
        movieService.updateMovie(movieDTO,id);

        return new ResponseEntity<>(movieService.getMovieById(id).get(), HttpStatus.OK);
        }

        @DeleteMapping(value = "/{id}")
        public ResponseEntity<Long> deleteMovie(@PathVariable long id){
        movieService.deleteMovie(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
        }




}

