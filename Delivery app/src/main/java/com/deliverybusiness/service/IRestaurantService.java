package com.deliverybusiness.service;

import com.deliverybusiness.exception.WrongIdException;
import com.deliverybusiness.model.Restaurant;

import java.util.List;

public interface IRestaurantService {
    List<Restaurant> findAll();
    Restaurant addRestaurant(Restaurant restaurant);

    List<Restaurant> findByName(String name);

    String removeRestaurant(int id);

    Restaurant findById(int id) throws WrongIdException;

    Restaurant updateRestaurant(Restaurant restaurant, int id);

    List<Restaurant> findByIsActiveTrue();
}
