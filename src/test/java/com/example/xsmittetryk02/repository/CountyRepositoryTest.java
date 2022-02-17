package com.example.xsmittetryk02.repository;

import com.example.xsmittetryk02.model.County;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CountyRepositoryTest {

    @Autowired
    CountyRepository countyRepository;

    @BeforeEach
    void setUp() {
        County county = new County();
        county.setCountyCode("1111");
        county.setName("Hej");
        county.setHref("httplocalhost");
        countyRepository.save(county);
    }

    @Test
    void testCounty1() {
        List<County> lst = countyRepository.findAll();
        assertEquals(true, lst.size() > 0);
    }

}