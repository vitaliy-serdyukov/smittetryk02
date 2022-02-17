package com.example.xsmittetryk02.controller;

import com.example.xsmittetryk02.model.County;
import com.example.xsmittetryk02.repository.CountyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CountyRESTController {

    @Autowired
    CountyRepository countyRepository;

    @GetMapping("/counties")
    public List<County> getAllCounties() {
        return countyRepository.findAll();
    }

    @GetMapping("/")
    public String hej() {
        return "Hello World";
    }

    @GetMapping("/county/{id}")
    public County findCountyById(@PathVariable String id) {
        Optional<County> county = countyRepository.findById(id);
        if (county.isPresent()) {
            return county.get();
        } else {
            return null;
        }
    }

    @GetMapping("/countyx/{id}")
    public ResponseEntity<County> findCountyByIdx(@PathVariable String id) {
        Optional<County> county = countyRepository.findById(id);
        if (county.isPresent()) {
            return new ResponseEntity<>(county.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/countyz/{id}")
    public ResponseEntity<County> findCountyById2(@PathVariable String id) {
        Optional<County> county = countyRepository.findById(id);
        if (county.isPresent()) {
            return new ResponseEntity<>(county.get(), HttpStatus.OK);
        } else {
            //throw new Exception("kunne ikke finde den skide kommune");
            //var obj = ResponseEntity.notFound("jeg kunne ikke finde den kommune");
            //return new ResponseEntity<County>.notFound("jerere");
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        }
    }

    @GetMapping("/countyzz/{id}")
    public ResponseEntity<County> findCountyById22(@PathVariable String id) throws Exception {
        Optional<County> county = Optional.ofNullable(countyRepository.findById(id).orElseThrow(
                () -> new Exception("jeg kunne ikke finde den kommune")
        ));
        return new ResponseEntity<>(county.get(), HttpStatus.OK);
    }

    @PostMapping(value="/county", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public County postCounty(@RequestBody County county) {
        System.out.println(county);
        return countyRepository.save(county);
    }

    @DeleteMapping("/xxx/{id}")
    public void deleteAppliance(@PathVariable String id) {
        countyRepository.deleteById(id);
    }

    @DeleteMapping("/county")
    public void deleteApplianceBody(@RequestBody County county) {
        countyRepository.delete(county);
    }

    @PutMapping("/county/{id}")
    public ResponseEntity<County> updateCounty(@PathVariable String id, @RequestBody County county) {
        Optional<County> optCounty = countyRepository.findById(id);
        if (optCounty.isPresent()) {
            County updCounty = countyRepository.save(county);
            return new ResponseEntity<>(updCounty, HttpStatus.OK);
        } else {
            County notfound = new County();
            notfound.setName("not found");
            return new ResponseEntity<>(notfound, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/countyxx/{id}")
    public ResponseEntity<?> saveResource(@RequestBody County county,
                                          @PathVariable("id") String id) {
        countyRepository.save(county);
        return ResponseEntity.ok("resource saved");
    }


}



