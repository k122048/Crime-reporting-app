package com.crime.springboot.crimeapp.service;

import com.crime.springboot.crimeapp.dao.CrimeUserDAO;
import com.crime.springboot.crimeapp.entity.CrimeUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CrimeUserServiceImpl implements CrimeUserService {
    private CrimeUserDAO crimeUserDAO;

    @Autowired
    public CrimeUserServiceImpl(CrimeUserDAO theCrimeUserDAO) {
        crimeUserDAO = theCrimeUserDAO;
    }

    @Override
    @Transactional
    public List<CrimeUser> findAll() {
        return crimeUserDAO.findAll();
    }

    @Override
    @Transactional
    public CrimeUser findById(int theId) {
        return crimeUserDAO.findById(theId);
    }

    @Override
    @Transactional
    public void save(CrimeUser crimeUser) {
        crimeUserDAO.save(crimeUser);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        crimeUserDAO.deleteById(theId);
    }

}
