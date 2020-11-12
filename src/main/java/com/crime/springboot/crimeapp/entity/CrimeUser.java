package com.crime.springboot.crimeapp.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="app_user")
public class CrimeUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="user_name")
    private String userName;

    public CrimeUser(){

    }

    @OneToMany
    @JoinColumn(name="user_id")
    private List<Crime> crimes;



    public CrimeUser(String firstName,String lastName,String userName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
    }

}
