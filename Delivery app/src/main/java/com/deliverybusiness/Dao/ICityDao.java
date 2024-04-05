package com.deliverybusiness.Dao;

import com.deliverybusiness.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICityDao extends JpaRepository<City, Integer> {
    List<City> findByName(String name);

    List<City> findByNameContaining(String pattern);

    City findByZipCode(String zipCode);







}
