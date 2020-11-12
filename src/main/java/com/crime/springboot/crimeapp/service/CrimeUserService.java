package com.crime.springboot.crimeapp.service;

import com.crime.springboot.crimeapp.entity.CrimeUser;

import java.util.List;

public interface CrimeUserService {


    public List<CrimeUser> findAll();

    public CrimeUser findById(int theId);

    public void save(CrimeUser crimeUser);

    public void deleteById(int theId);
}
