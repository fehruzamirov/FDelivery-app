package com.deliverybusiness.service;

import com.deliverybusiness.exception.WrongIdException;
import com.deliverybusiness.model.City;

import java.util.List;

public interface ICityService {
     List<City> findAll();
     City findById(int id) throws WrongIdException;

    String removeCity(int id);

     City addCity(City city);

     City updateCity(City city, int id);

     List<City> findByName(String name);

     List<City> saveList(List<City> cityList);

    List<City> findByNameLike(String pattern);
    City findByZipCode(String zipCode);

}
