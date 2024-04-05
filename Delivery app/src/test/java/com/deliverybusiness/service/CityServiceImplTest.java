package com.deliverybusiness.service;

import com.deliverybusiness.Dao.ICityDao;
import com.deliverybusiness.exception.WrongIdException;
import com.deliverybusiness.model.City;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@RunWith( SpringRunner.class )
@SpringBootTest
class CityServiceImplTest {

   @Autowired
   private ICityDao iCityDao;

    private CityServiceImpl cityServiceImpl;

    private City city;

    @BeforeEach
    public void setup(){
     cityServiceImpl = new CityServiceImpl(iCityDao);
     this.city = new City(20, "Kraljevo", "23321");
    }


    @Test
    void findAll() {
        List<City> listaGradova = cityServiceImpl.findAll();
        List<City> listaDaoGradova = iCityDao.findAll();
        assertNotNull(listaGradova);
        assertNotNull(listaDaoGradova);
        assertEquals(listaGradova.size(), listaDaoGradova.size());

    }

    @Test
    void findById() {
     City city = cityServiceImpl.findById(1);
     Optional<City> cityOptional = iCityDao.findById(1);
     assertNotNull(city);
     assertTrue(cityOptional.isPresent());
     assertEquals(city.getId(), cityOptional.get().getId());
    }
 @Test
 void findByWrongId() {
  Assertions.assertThrows(WrongIdException.class, () -> {
   cityServiceImpl.findById(11000);
  });

 }

    @Test
    @Disabled
    void removeCity() {
        cityServiceImpl.removeCity(this.city.getId());
        Optional<City> findCity = iCityDao.findById(this.city.getId());
        assertFalse(findCity.isPresent());
    }

    @Test
    void addCity() {
       cityServiceImpl.addCity(this.city);
       Optional<City> nadjiGrad = iCityDao.findById(this.city.getId());
       assertTrue(nadjiGrad.isPresent());
       assertEquals(this.city.getId(), nadjiGrad.get().getId());
       assertEquals(this.city.getName(), nadjiGrad.get().getName());
    }

    @Test
    void updateCity() {

        cityServiceImpl.addCity(this.city);
        this.city.setName("Zrenjanin");
        cityServiceImpl.updateCity(this.city, this.city.getId());
        Optional<City> gradic = iCityDao.findById(this.city.getId());
        assertTrue(gradic.isPresent());
        assertEquals("Zrenjanin", gradic.get().getName());
    }

    @Test
    void findByName() {
        cityServiceImpl.addCity(this.city);
        Optional<City> ciudad2 = iCityDao.findById(this.city.getId());
        assertTrue(ciudad2.isPresent());
        assertEquals(this.city.getName(), ciudad2.get().getName());


    }

    @Test
    void saveList() {
        List<City> listaGradova = new ArrayList<>();
        listaGradova.add(new City(18, "Porto", "22222"));
        listaGradova.add(new City(19, "Lisabon", "21111"));
        cityServiceImpl.saveList(listaGradova);
        Optional<City> prviGrad = iCityDao.findById(18);
        Optional<City> drugiGrad = iCityDao.findById(19);
        assertTrue(prviGrad.isPresent());
        assertTrue(drugiGrad.isPresent());
        List<City> listaGradovaIzDao = new ArrayList<>();
        listaGradovaIzDao.add(prviGrad.get());
        listaGradovaIzDao.add(drugiGrad.get());
        assertEquals(listaGradova.size(), listaGradovaIzDao.size());
        assertEquals(listaGradova.get(0).getName(), listaGradovaIzDao.get(0).getName());
    }

    @Test
    void findByNameLike() {
        List<City> patternCity = cityServiceImpl.findByNameLike("in");
        List<City> patternCity2 = iCityDao.findByNameContaining("in");
        assertNotNull(patternCity);
        assertNotNull(patternCity2);
        assertEquals(patternCity.size(), patternCity2.size());
    }
}