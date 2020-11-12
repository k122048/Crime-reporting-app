package com.crime.springboot.crimeapp.rest;

import com.crime.springboot.crimeapp.entity.CrimeUser;
import com.crime.springboot.crimeapp.service.CrimeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CrimeUserRestController {

    private CrimeUserService crimeUserService;

    @Autowired
    public CrimeUserRestController(CrimeUserService theCrimeUserService){
        crimeUserService = theCrimeUserService;
    }

    @GetMapping("/crimeusers")
    public List<CrimeUser> findAll(){return crimeUserService.findAll();}

    @GetMapping("/crimeusers/{crimeUserId}")
    public CrimeUser getCrimeUser(@PathVariable int crimeUserId){
        CrimeUser crimeUser = crimeUserService.findById(crimeUserId);
        if(crimeUser == null){
            throw new RuntimeException("Crime user id not found - "+crimeUserId);
        }
        return crimeUser;
    }

    @PostMapping("/crimeusers")
    public CrimeUser addCrimeUser(@RequestBody CrimeUser crimeUser){
        crimeUser.setId(0);
        crimeUserService.save(crimeUser);
        return crimeUser;

    }

    @PutMapping("/crimeusers")
    public CrimeUser updateCrimeUser(@RequestBody CrimeUser crimeUser) {

        crimeUserService.save(crimeUser);

        return crimeUser;
    }


    @DeleteMapping("/crimeusers/{crimeUserId}")
    public String deleteCrimeUser(@PathVariable int crimeUserId) {

        CrimeUser crimeUser = crimeUserService.findById(crimeUserId);

        // throw exception if null

        if (crimeUser == null) {
            throw new RuntimeException("Crime User id not found - " + crimeUserId);
        }

        crimeUserService.deleteById(crimeUserId);

        return "Deleted Crime User id - " + crimeUserId;
    }

}
