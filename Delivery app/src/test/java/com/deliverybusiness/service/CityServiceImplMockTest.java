package com.deliverybusiness.service;

import com.deliverybusiness.Dao.ICityDao;
import com.deliverybusiness.model.City;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;

import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith( SpringRunner.class )
@SpringBootTest
class CityServiceImplMockTest {

    private ICityDao iCityDao;

    private CityServiceImpl cityServiceImpl;

    private City city;

    @BeforeEach
    void setUp(){
        iCityDao = Mockito.mock(ICityDao.class);
        cityServiceImpl = new CityServiceImpl(iCityDao);
        this.city = new City(20, "Kraljevo", "23321");
    }


    @Test
    void findAll() {
        List<City> lista = new ArrayList<>();
        lista.add(this.city);
        when(iCityDao.findAll()).thenReturn(lista);
        List<City> cityList = cityServiceImpl.findAll();
        assertEquals(cityList.size(), lista.size());
    }
    @Test
    void findById() {
        when(iCityDao.findById(this.city.getId())).thenReturn(Optional.of(this.city));
        City gradPoServisu = cityServiceImpl.findById(this.city.getId());
        assertEquals(this.city.getName(),gradPoServisu.getName());
    }

    @Test
    void removeCity() {
        when(iCityDao.findById(this.city.getId())).thenReturn(Optional.of(this.city));
        String result = cityServiceImpl.removeCity(this.city.getId());
        assertEquals("good job", result);
    }

    @Test
    void addCity() {
        when(iCityDao.save(any())).thenReturn(this.city);
        City grad1 = cityServiceImpl.addCity(this.city);
        assertEquals(this.city.getName(), grad1.getName());
        verify(iCityDao, times(1)).save(this.city);
    }

    @Test
    void updateCity() {
        when(iCityDao.findById(this.city.getId())).thenReturn(Optional.of(this.city));
        this.city.setName("Pancevo");
        when(iCityDao.save(any())).thenReturn(this.city);
        City gradic = cityServiceImpl.updateCity(this.city, this.city.getId());
        assertEquals(this.city.getName(), gradic.getName(), "Values for name of the cities do not match.");//msg only shows when test fails.
        assertEquals(this.city.getZipCode(), gradic.getZipCode());
    }
    @Test
    void saveList() {
        List<City> listaGradova = new ArrayList<>();
        listaGradova.add(new City(18, "Porto", "22222"));
        listaGradova.add(new City(19, "Lisabon", "21111"));
        when(iCityDao.saveAll(listaGradova)).thenReturn(listaGradova);
        List<City> lista = cityServiceImpl.saveList(listaGradova);
        assertEquals(listaGradova.size(),lista.size());
    }
}