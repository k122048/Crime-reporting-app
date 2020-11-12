package com.crime.springboot.crimeapp.service;

import com.crime.springboot.crimeapp.entity.Crime;

import java.util.List;

public interface CrimeService {
    public List<Crime> findAll();

    public Crime findById(int theId);

    public void save(Crime crime);

    public void deleteById(int theId);
}
