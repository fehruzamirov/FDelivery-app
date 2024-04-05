package com.deliverybusiness.controller;

import com.deliverybusiness.model.City;
import com.deliverybusiness.service.CityServiceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(CityController.class)
@AutoConfigureMockMvc
class CityControllerTest {
    @Autowired
    private MockMvc mvc;
    @MockBean
    private CityServiceImpl cityServiceImpl;

    @Autowired
    protected ObjectMapper objectMapper;

    private City city;


    @BeforeEach
    void setUp(){
        this.city = new City(20, "Kraljevo", "23321");
    }
    @Test
    void getAll() throws Exception {
        List<City> listaGradova = new ArrayList<>();
        listaGradova.add(new City(18, "Porto", "22222"));
        listaGradova.add(new City(19, "Lisabon", "21111"));
        when(cityServiceImpl.findAll()).thenReturn(listaGradova);
        MvcResult result = mvc.perform(get("/city")).andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name",is(listaGradova.get(0).getName())))
                .andExpect(jsonPath("$[1].zipCode",is(listaGradova.get(1).getZipCode()))).andReturn();
        List<City> listaRezultata = objectMapper.readValue(result.getResponse().getContentAsByteArray(), List.class);
        assertNotNull(listaRezultata);
        assertEquals(listaGradova.size(), listaRezultata.size());

    }

    @Test
    void getById() throws Exception {
        when(cityServiceImpl.findById(anyInt())).thenReturn(this.city);
       MvcResult result = mvc.perform(get("/city/1"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.name",is(this.city.getName())))
               .andExpect(jsonPath("$.zipCode",is(this.city.getZipCode())))
               .andReturn();
       City city1 = objectMapper.readValue(result.getResponse().getContentAsByteArray(), City.class);
       assertEquals(city.getName(), city1.getName());

    }
    @Test
    void deleteCity() throws Exception {
        when(cityServiceImpl.removeCity(anyInt())).thenReturn("good job");
        MvcResult result = mvc.perform(delete("/city/{id}",
                city.getId())).andExpect(status().isOk()).andReturn();
        assertEquals("good job", result.getResponse().getContentAsString());
    }

    @Test
    void addCity() throws Exception {
        when(cityServiceImpl.addCity(any())).thenReturn(this.city);
        MvcResult result = mvc.perform(post("/city").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(this.city))).andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is(this.city.getId())))
                .andExpect(jsonPath("$.name",is(this.city.getName())))
                .andExpect(jsonPath("$.zipCode",is(this.city.getZipCode()))).andReturn();
       City results = objectMapper.readValue(result.getResponse().getContentAsByteArray(), City.class);
       assertEquals(this.city.getName(),results.getName());
    }

    @Test
    void updateCity() throws Exception {
        when(cityServiceImpl.updateCity(any(),anyInt())).thenReturn(this.city);
        MvcResult result = mvc.perform(put("/city/{id}", this.city.getId()).contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(this.city))).andExpect(status().isOk()).andReturn();
        City results = objectMapper.readValue(result.getResponse().getContentAsByteArray(), City.class);
        assertEquals(this.city.getName(),results.getName());
        assertEquals(this.city.getZipCode(), results.getZipCode());
    }
    @Test
    void findByName() throws Exception {
        List<City> listaGradova = new ArrayList<>();
        listaGradova.add(new City(18, "Porto", "22222"));
        when(cityServiceImpl.findByName("Porto")).thenReturn(listaGradova);
        MvcResult result = mvc.perform(get("/city/name")
                .param("name",listaGradova.get(0).getName())).andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name",is(listaGradova.get(0).getName())))
                .andReturn();
        List<City> vracenaLista = objectMapper.readValue(result.getResponse().getContentAsByteArray(), List.class);
        assertEquals(listaGradova.size(), vracenaLista.size());
    }

    @Test
    void getByZipCode() throws Exception {
        when(cityServiceImpl.findByZipCode("23321")).thenReturn(this.city);
        MvcResult result = mvc.perform(get("/city/zipCode")
                .param("zipCode", city.getZipCode())).andExpect(status()
                .isOk())
                .andExpect(jsonPath("$.name",is(this.city.getName())))
                .andExpect(jsonPath("$.zipCode",is(this.city.getZipCode())))
                .andReturn();
        City city1 = objectMapper.readValue(result.getResponse().getContentAsByteArray(), City.class);
        assertEquals(city.getName(), city1.getName());
    }
    @Test
    void saveList() throws Exception {
        List<City> listOfCities = new ArrayList<>();
        listOfCities.add(this.city);
        when(cityServiceImpl.saveList(anyList())).thenReturn(listOfCities);
        MvcResult result = mvc.perform(post("/city/saveAll").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(listOfCities))).andExpect(status().isOk()).andReturn();
        List<City> listToCompare = objectMapper.readValue(result.getResponse().getContentAsByteArray(), List.class);
        assertEquals(listOfCities.size(),listToCompare.size());
    }
}