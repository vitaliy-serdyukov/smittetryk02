package com.example.xsmittetryk02.config;

import com.example.xsmittetryk02.model.County;
import com.example.xsmittetryk02.repository.CountyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    CountyRepository countyRepository;

    @Override
    public void run(String... args) throws Exception {
        County roskilde = new County();
        roskilde.setName("Roskilde");
        roskilde.setCountyCode("0265");
        roskilde.setHref("http://localhost:8080/county/0265");
        countyRepository.save(roskilde);

        roskilde.setName("Køgexx");
        roskilde.setCountyCode("0259");
        roskilde.setHref("http://localhost:8080/county/0259");
        countyRepository.save(roskilde);


    }
}


