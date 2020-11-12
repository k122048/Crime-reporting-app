package com.crime.springboot.crimeapp.dao;

import com.crime.springboot.crimeapp.entity.CrimeCategory;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CrimeCategoryDAOHibernateImpl implements CrimeCategoryDAO{

    private EntityManager entityManager;

    @Autowired
    public CrimeCategoryDAOHibernateImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<CrimeCategory> findAll(){

        Session currentSession = entityManager.unwrap(Session.class);
        Query<CrimeCategory> theQuery = currentSession.createQuery("from CrimeCategory",CrimeCategory.class);
        List<CrimeCategory> crimeCategories = theQuery.getResultList();
        return crimeCategories;
    }

    @Override
    public CrimeCategory findById(int id){
        Session currentSession = entityManager.unwrap(Session.class);

        CrimeCategory crimeCategory = currentSession.get(CrimeCategory.class,id);

        return crimeCategory;
    }

    @Override
    public void save(CrimeCategory crimeCategory){
        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(crimeCategory);
    }

    @Override
    public void deleteById(int id){

        Session currentSession = entityManager.unwrap(Session.class);

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery(
                        "delete from CrimeCategory where id=:crimeCategoryId");
        theQuery.setParameter("crimeCategoryId", id);

        theQuery.executeUpdate();
    }


}
