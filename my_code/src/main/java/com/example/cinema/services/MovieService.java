package com.example.cinema.services;

import com.example.cinema.models.Movie;
import com.example.cinema.models.MovieDTO;
import com.example.cinema.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService{

    @Autowired
    MovieRepository movieRepository;

    public MovieService(){}

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(long id){
        Optional<Movie> movie = movieRepository.findById(id);
        return movie;
    }

    public void addMovie(Movie movie){
        movieRepository.save(movie);
    }

    public void updateMovie(MovieDTO movieDTO, long movieId){

        Movie targetMovie = movieRepository.findById(movieId).get();
        targetMovie.setTitle(movieDTO.getTitle());
        targetMovie.setRating(movieDTO.getRating());
        targetMovie.setDuration(movieDTO.getDuration());

        movieRepository.save(targetMovie);
    }

    public void deleteMovie(long id){
        movieRepository.deleteById(id);
    }

    public List<Movie> getMoviesOfMaxDuration(int duration){
        List<Movie> movies = new ArrayList<>();
        for(Movie movie: movieRepository.findAll()){
            if (movie.getDuration() <= duration){
                movies.add(movie);
            }
        }
        return movies;
    }







}