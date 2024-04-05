package com.deliverybusiness.Dao;

import com.deliverybusiness.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface IRestaurantDao extends JpaRepository<Restaurant, Integer> {
    List<Restaurant> findByName(String name);

    List<Restaurant> findByIsActiveTrue();




}
