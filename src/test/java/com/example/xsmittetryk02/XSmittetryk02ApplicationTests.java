package com.example.xsmittetryk02;

import com.example.xsmittetryk02.model.County;
import com.example.xsmittetryk02.repository.CountyRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class XSmittetryk02ApplicationTests {

    @Autowired
    CountyRepository countyRepository;

    @Test
    void testFunc() {
        List<County> counties = countyRepository.findAll();
        Assertions.assertEquals(34, counties.size());

    }

}
