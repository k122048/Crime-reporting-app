package com.crime.springboot.crimeapp.service;

import com.crime.springboot.crimeapp.dao.CrimeDAO;
import com.crime.springboot.crimeapp.entity.Crime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CrimeServiceImpl implements CrimeService {
    private CrimeDAO crimeDAO;

    @Autowired
    public CrimeServiceImpl(CrimeDAO theCrimeDAO) {
        crimeDAO = theCrimeDAO;
    }

    @Override
    @Transactional
    public List<Crime> findAll() {
        return crimeDAO.findAll();
    }

    @Override
    @Transactional
    public Crime findById(int theId) {
        return crimeDAO.findById(theId);
    }

    @Override
    @Transactional
    public void save(Crime crime) {
        crimeDAO.save(crime);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        crimeDAO.deleteById(theId);
    }
}
