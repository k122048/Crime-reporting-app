package com.crime.springboot.crimeapp.rest;

import com.crime.springboot.crimeapp.entity.CrimeCategory;
import com.crime.springboot.crimeapp.service.CrimeCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CrimeCategoryRestController {

    private CrimeCategoryService crimeCategoryService;

    @Autowired
    public CrimeCategoryRestController(CrimeCategoryService theCrimeCategoryService){
        crimeCategoryService = theCrimeCategoryService;
    }

    @GetMapping("/crimecategory")
    public List<CrimeCategory> findAll(){return crimeCategoryService.findAll();}

    @PostMapping("/crimecategory")
    public CrimeCategory addCrimeUser(@RequestBody CrimeCategory crimeCategory){
        crimeCategory.setId(0);
        crimeCategoryService.save(crimeCategory);
        return crimeCategory;
    }

    @PutMapping("/crimecategory")
    public CrimeCategory updateCrimeUser(@RequestBody CrimeCategory crimeCategory) {

        crimeCategoryService.save(crimeCategory);

        return crimeCategory;
    }

    @DeleteMapping("/crimecategory/{crimeCategoryId}")
    public String deleteCrimeUser(@PathVariable int crimeCategoryId) {

        CrimeCategory crimeCategory = crimeCategoryService.findById(crimeCategoryId);

        // throw exception if null

        if (crimeCategory == null) {
            throw new RuntimeException("Crime Category id not found - " + crimeCategoryId);
        }

        crimeCategoryService.deleteById(crimeCategoryId);

        return "Deleted Crime Category id - " + crimeCategoryId;
    }

}
