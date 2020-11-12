package com.crime.springboot.crimeapp.service;

import com.crime.springboot.crimeapp.dao.CrimeCategoryDAO;
import com.crime.springboot.crimeapp.entity.CrimeCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CrimeCategoryServiceImpl implements CrimeCategoryService{
    private CrimeCategoryDAO crimeCategoryDAO;

    @Autowired
    public CrimeCategoryServiceImpl(CrimeCategoryDAO theCrimeCategoryDAO) {
        crimeCategoryDAO = theCrimeCategoryDAO;
    }

    @Override
    @Transactional
    public List<CrimeCategory> findAll() {
        return crimeCategoryDAO.findAll();
    }

    @Override
    @Transactional
    public CrimeCategory findById(int theId) {
        return crimeCategoryDAO.findById(theId);
    }

    @Override
    @Transactional
    public void save(CrimeCategory crimeCategory) {
        crimeCategoryDAO.save(crimeCategory);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        crimeCategoryDAO.deleteById(theId);
    }
}
