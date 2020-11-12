package com.crime.springboot.crimeapp.dao;

import com.crime.springboot.crimeapp.entity.CrimeUser;

import java.util.List;

public interface CrimeUserDAO {

    public List<CrimeUser> findAll();

    public CrimeUser findById(int id);

    public void save(CrimeUser user);

    public void deleteById(int id);
}
