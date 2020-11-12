package com.crime.springboot.crimeapp.service;


import com.crime.springboot.crimeapp.entity.CrimeCategory;

import java.util.List;

public interface CrimeCategoryService {
    public List<CrimeCategory> findAll();

    public CrimeCategory findById(int theId);

    public void save(CrimeCategory crimeCategory);

    public void deleteById(int theId);
}
