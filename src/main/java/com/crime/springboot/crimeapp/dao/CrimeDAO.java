package com.crime.springboot.crimeapp.dao;

import com.crime.springboot.crimeapp.entity.Crime;

import java.util.List;

public interface CrimeDAO {

    public List<Crime> findAll();
    public void save(Crime crimeCategory);
    public Crime findById(int id);
    public void deleteById(int id);
}
