package com.example.cinema.models;

public class MovieDTO {

    private long id;

    private String title;

    private String rating;

    private int duration;

    public MovieDTO(){}

    public MovieDTO(long id,String title, String rating, int duration){
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.duration = duration;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRating() {
        return this.rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
