package com.deliverybusiness.controller;

import com.deliverybusiness.model.City;
import com.deliverybusiness.model.Customer;
import com.deliverybusiness.service.CustomerServiceImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
@AutoConfigureMockMvc
class CustomerControllerTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    protected ObjectMapper objectMapper;

    @MockBean
    private CustomerServiceImpl customerServiceImpl;


    private Customer customer;

    private Customer customer2;
    private City city;

    @BeforeEach
    void setUp() {
        this.city = new City(1, "Kikinda", "21000");
        this.customer = new Customer(1, "Dragana Pavlovic", "ne znam gde zivis", this.city);
        this.customer2 = new Customer(2, "Nemanja Milanovic", "ne znam gde zivis", this.city);
    }

    @Test
    void getAll() throws Exception {
        List<Customer> listaMusterija = new ArrayList<>();
        listaMusterija.add(customer);
        listaMusterija.add(customer2);
        Pageable pageable = PageRequest.of(0, 5, Sort.by(Sort.Direction.DESC, "fullName"));
        Page<Customer> expectedPage = new PageImpl<>(listaMusterija, pageable, listaMusterija.size());
        when(customerServiceImpl.findAll(any())).thenReturn(expectedPage);

        MvcResult result = mvc.perform(get("/customer/all")
                .param("size","5").param("page","0").param("sort", "fullName,desc"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size").exists())
                .andExpect(jsonPath("$.totalElements").exists())
                .andExpect(jsonPath("$.numberOfElements").exists())
                .andExpect(jsonPath("$.totalPages").exists())
                .andExpect(jsonPath("$.sort").exists())
                .andExpect(jsonPath("$.numberOfElements", is(2)))
                .andExpect(jsonPath("totalElements", is(2)))
                .andExpect(jsonPath("size", is(5)))
                .andExpect(jsonPath("$.number").exists())
                .andExpect(jsonPath("$.number",is(0)))
                .andExpect(jsonPath("$.content[0].id",is(customer.getId())))
                .andExpect(jsonPath("$.content[0].fullName", is(customer.getFullName())))
                .andExpect(jsonPath("$.content[0].city.name", is(customer.getCity().getName())))
                .andExpect(jsonPath("$.content[0].city.zipCode", is(customer.getCity().getZipCode())))
                .andExpect(jsonPath("$.content[1].fullName", is(customer2.getFullName())))
                .andExpect(jsonPath("$.content[1].address", is(customer2.getAddress())))
                .andExpect(jsonPath("$.content[1].city.name", is(customer2.getCity().getName())))
                .andReturn();
    }
    @Test
    void findByCityAndAddress() throws Exception {
        List<Customer> listaMusterija = new ArrayList<>();
        listaMusterija.add(customer);
        listaMusterija.add(customer2);
        Pageable pageable = PageRequest.of(0, 5, Sort.by(Sort.Direction.DESC, "fullName"));
        Page<Customer> expectedPage = new PageImpl<>(listaMusterija, pageable, listaMusterija.size());
        when(customerServiceImpl.findByCityAndAddress(any(), any(), any())).thenReturn(expectedPage);

        MvcResult result = mvc.perform(get("/customer/address")
                .param("size", "5").param("page", "0").param("sort", "fullName, desc")
                .param("address", "1300 Kaplara").param("name", "Novi Sad"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size").exists())
                .andExpect(jsonPath("$.totalElements").exists())
                .andExpect(jsonPath("$.numberOfElements").exists())
                .andExpect(jsonPath("$.totalPages").exists())
                .andExpect(jsonPath("$.sort").exists())
                .andExpect(jsonPath("$.numberOfElements", is(2)))
                .andExpect(jsonPath("totalElements", is(2)))
                .andExpect(jsonPath("size",is(5)))
                .andExpect(jsonPath("number").exists())
                .andExpect(jsonPath("$.content[0].id", is(customer.getId())))
                .andExpect(jsonPath("$.content[0].fullName", is(customer.getFullName())))
                .andExpect(jsonPath("$.content[0].city.name", is(customer.getCity().getName())))
                .andExpect(jsonPath("$.content[0].city.zipCode", is(customer.getCity().getZipCode())))
                .andExpect(jsonPath("$.content[1].fullName", is(customer2.getFullName())))
                .andExpect(jsonPath("$.content[1].address", is(customer2.getAddress())))
                .andExpect(jsonPath("$.content[1].city.name", is(customer2.getCity().getName())))
                .andReturn();
    }
}