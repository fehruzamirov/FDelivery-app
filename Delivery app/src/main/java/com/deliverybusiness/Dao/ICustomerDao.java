package com.deliverybusiness.Dao;
import com.deliverybusiness.model.City;
import com.deliverybusiness.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ICustomerDao extends JpaRepository<Customer, Integer> {
    List<Customer> findByFullName(String name);

    List<Customer> findByFullNameStartingWith(String prefix);

    List<Customer> findByFullNameIsNotNull();

    List<Customer> findByFullNameIsNot(String name);


    @Query("Select c from Customer c WHERE (:address is null or c.address = :address) and (:cityName is null or c.city.name = :cityName)")
    Page<Customer> findByCityAndAddress(String address, String cityName, Pageable pageable);

    @Query("Select count (c.id) from Customer c where c.city.name = :name")
    Integer findNumberOfCustomersPerCity(String name);

    @Query("Select count (c.address) from Customer c where c.address = :address")
    Integer findNumberOfCustomersWhoLiveAtTheSameAddress(String address);









}
