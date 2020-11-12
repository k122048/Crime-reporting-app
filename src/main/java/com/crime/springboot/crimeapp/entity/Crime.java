package com.crime.springboot.crimeapp.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@Table(name="crime")
public class Crime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="latitude")
    private float latitude;

    @Column(name="longitude")
    private float longitude;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="crime_date")
    private Timestamp date;

    public Crime(){

    }

    @ManyToOne
    @JoinColumn(name="category_id")
    private CrimeCategory crimeCategory;



    public Crime(float latitude,float longitude,String title,String description,Timestamp date){
        this.latitude = latitude;
        this.longitude = longitude;
        this.title = title;
        this.description = description;
        this.date = date;
    }

}
