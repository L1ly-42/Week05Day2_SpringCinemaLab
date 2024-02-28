package com.example.cinema.controllers;


import com.example.cinema.models.Movie;
import com.example.cinema.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;

import java.util.Optional;

@RestController
@RequestMapping(value = "/movies")
public MovieController{

    @Autowired
    MovieService movieService;


    @PostMapping
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
       // do something to add movie to database
        return new ResponseEntity(result, HttpStatus.CREATED);

//    }




}