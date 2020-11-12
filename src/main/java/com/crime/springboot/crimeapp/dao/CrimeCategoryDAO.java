package com.crime.springboot.crimeapp.dao;

import com.crime.springboot.crimeapp.entity.CrimeCategory;

import java.util.List;

public interface CrimeCategoryDAO {

    public List<CrimeCategory> findAll();
    public void save(CrimeCategory crimeCategory);
    public CrimeCategory findById(int id);
    public void deleteById(int id);
}
