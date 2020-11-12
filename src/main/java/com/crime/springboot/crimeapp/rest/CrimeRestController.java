package com.crime.springboot.crimeapp.rest;

import com.crime.springboot.crimeapp.entity.Crime;
import com.crime.springboot.crimeapp.service.CrimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CrimeRestController {

    private CrimeService crimeService;

    @Autowired
    public CrimeRestController(CrimeService theCrimeService){
        crimeService = theCrimeService;
    }

    @GetMapping("/crimes")
    public List<Crime> findAll(){return crimeService.findAll();}

    @GetMapping("/crimes/{crimeId}")
    public Crime getCrimeUser(@PathVariable int crimeId){
        Crime crime = crimeService.findById(crimeId);
        if(crime == null){
            throw new RuntimeException("Crime id not found - "+crimeId);
        }
        return crime;
    }

    @PostMapping("/crimes")
    public Crime addCrimeUser(@RequestBody Crime crime){
        crime.setId(0);
        Date date = new Date();
        Timestamp timeStamp = new Timestamp(date.getTime());
        crime.setDate(timeStamp);
        crimeService.save(crime);
        return crime;

    }

    @PutMapping("/crimes")
    public Crime updateCrimeUser(@RequestBody Crime crime) {

        crimeService.save(crime);

        return crime;
    }


    @DeleteMapping("/crimes/{crimeId}")
    public String deleteCrimeUser(@PathVariable int crimeId) {

        Crime crime = crimeService.findById(crimeId);

        // throw exception if null

        if (crime == null) {
            throw new RuntimeException("Crime id not found - " + crimeId);
        }

        crimeService.deleteById(crimeId);

        return "Deleted Crime id - " + crimeId;
    }

}

