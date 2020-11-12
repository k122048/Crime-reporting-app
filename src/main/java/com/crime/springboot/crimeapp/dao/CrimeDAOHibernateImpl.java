package com.crime.springboot.crimeapp.dao;

import com.crime.springboot.crimeapp.entity.Crime;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CrimeDAOHibernateImpl implements CrimeDAO {

    private EntityManager entityManager;

    @Autowired
    public CrimeDAOHibernateImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Crime> findAll(){

        Session currentSession = entityManager.unwrap(Session.class);
        Query<Crime> theQuery = currentSession.createQuery("from Crime",Crime.class);
        List<Crime> crimes = theQuery.getResultList();
        return crimes;
    }

    @Override
    public Crime findById(int id){
        Session currentSession = entityManager.unwrap(Session.class);

        Crime crime = currentSession.get(Crime.class,id);

        return crime;
    }

    @Override
    public void save(Crime crime){
        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(crime);
    }

    @Override
    public void deleteById(int id){

        Session currentSession = entityManager.unwrap(Session.class);

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery(
                        "delete from Crime where id=:crimeId");
        theQuery.setParameter("crimeId", id);

        theQuery.executeUpdate();
    }
}
