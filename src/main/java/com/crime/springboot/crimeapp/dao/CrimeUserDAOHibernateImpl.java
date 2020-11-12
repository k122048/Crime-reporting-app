package com.crime.springboot.crimeapp.dao;

import com.crime.springboot.crimeapp.entity.CrimeUser;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CrimeUserDAOHibernateImpl implements CrimeUserDAO {

    private EntityManager entityManager;

    @Autowired
    public CrimeUserDAOHibernateImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<CrimeUser> findAll(){

        Session currentSession = entityManager.unwrap(Session.class);
        Query<CrimeUser> theQuery = currentSession.createQuery("from CrimeUser",CrimeUser.class);
        List<CrimeUser> crimeUsers = theQuery.getResultList();
        return crimeUsers;
    }

    @Override
    public CrimeUser findById(int id){
        Session currentSession = entityManager.unwrap(Session.class);

        CrimeUser crimeUser = currentSession.get(CrimeUser.class,id);

        return crimeUser;
    }

    @Override
    public void save(CrimeUser crimeUser){
        Session currentSession = entityManager.unwrap(Session.class);

       currentSession.saveOrUpdate(crimeUser);
    }

    @Override
    public void deleteById(int id){

        Session currentSession = entityManager.unwrap(Session.class);

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery(
                        "delete from CrimeUser where id=:crimeUserId");
        theQuery.setParameter("crimeUserId", id);

        theQuery.executeUpdate();
    }

}
