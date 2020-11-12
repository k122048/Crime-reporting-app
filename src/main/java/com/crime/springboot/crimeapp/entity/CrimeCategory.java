package com.crime.springboot.crimeapp.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="crime_category")
public class CrimeCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="category_name")
    private String categoryName;

    public CrimeCategory(){

    }

    public CrimeCategory(String categoryName){
        this.categoryName = categoryName;
    }

}
