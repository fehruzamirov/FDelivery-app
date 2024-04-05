package com.deliverybusiness.service;

import com.deliverybusiness.Dao.ICustomerDao;
import com.deliverybusiness.Dao.IOrderDao;
import com.deliverybusiness.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@RunWith( SpringRunner.class )
@SpringBootTest
class CustomerServiceImplTest {

    @Autowired
    private ICustomerDao iCustomerDao;
    @Autowired
    private IOrderDao iOrderDao;

    private CustomerServiceImpl customerServiceImpl;

    @BeforeEach
    public void setup(){
        customerServiceImpl = new CustomerServiceImpl(iCustomerDao, iOrderDao);
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
       Customer customer = customerServiceImpl.findById(2);
       Optional<Customer> customer1 = iCustomerDao.findById(2);
       assertNotNull(customer);
       assertTrue(customer1.isPresent());
       assertEquals(customer.getFullName(), customer1.get().getFullName());


    }

    @Test
    void addCustomer() {
        Customer jovana = new Customer
                (232, "jovana", "1100 kaplara",
                        new City(1, "Novi Sad", "21000"));
        customerServiceImpl.addCustomer(jovana);
        Optional<Customer> nadjiJovanu = iCustomerDao.findById(232);
        assertTrue(nadjiJovanu.isPresent());
        assertEquals(jovana.getId(), nadjiJovanu.get().getId());
        assertEquals(jovana.getFullName(), nadjiJovanu.get().getFullName());
    }


    @Test
    void updateCustomer() {
        Customer customer = new Customer(234, "Ana Ivanovic", "23rd street",
                new City(1, "Novi Sad", "21000"));
        customerServiceImpl.addCustomer(customer);
        customer.setFullName("Angelina Jolie");
        customerServiceImpl.updateCustomer(customer, 234);
        Optional<Customer> findCustomer = iCustomerDao.findById(customer.getId());
        assertTrue(findCustomer.isPresent());
        assertEquals(customer.getFullName(), findCustomer.get().getFullName());

    }
    @Test
    void findByCityAndAddress() {
        Page<Customer> musterijeIzIstogGrada =
                customerServiceImpl.findByCityAndAddress
                        ("1300 kaplara", "Novi Sad", PageRequest.of(0,5, Sort.by(Sort.Direction.ASC,"address")));
        Page<Customer> musterijeIzGrada =
                iCustomerDao.findByCityAndAddress("1300 kaplara", "Novi Sad",PageRequest.of(0,5, Sort.by(Sort.Direction.ASC,"address")));
        assertNotNull(musterijeIzIstogGrada);
        assertNotNull(musterijeIzGrada);
        assertEquals(musterijeIzIstogGrada.getContent().size(), musterijeIzGrada.getContent().size());
    }

    @Test
    void updateCustomerName() {
        Customer customer = new Customer(232, "Emilia Clarke", "Petra Drapsina",
                new City(1, "Novi Sad", "21000"));
        customerServiceImpl.addCustomer(customer);
        customer.setFullName("Olivia Bensona");
        customerServiceImpl.updateCustomer(customer, 232);
        Optional<Customer> optionalCustomer = iCustomerDao.findById(232);
        assertTrue(optionalCustomer.isPresent());
        assertEquals(customer.getFullName(), optionalCustomer.get().getFullName());
        assertEquals(customer.getCity().getName(), optionalCustomer.get().getCity().getName());
    }

    @Test
    void findCustomerByOrder() {

        List<Customer> customers = customerServiceImpl.findCustomerByOrder(22.99);
        List<Customer> customerList = iOrderDao.findCustomerByOrder(22.99);
        assertEquals(customers.size(), customerList.size());
    }
}