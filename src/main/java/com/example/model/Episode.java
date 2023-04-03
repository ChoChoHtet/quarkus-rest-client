package com.example.model;

import java.net.URL;
import java.util.Set;

public class Episode {
   private Long id;
   private URL url;
   private String name;
   private Integer season;
   private String airdate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public String getAirdate() {
        return airdate;
    }

    public void setAirdate(String airdate) {
        this.airdate = airdate;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    Rating rating;
    String summary;

}
 class Rating{
    Double average;

     public Double getAverage() {
         return average;
     }

     public void setAverage(Double average) {
         this.average = average;
     }
 }
