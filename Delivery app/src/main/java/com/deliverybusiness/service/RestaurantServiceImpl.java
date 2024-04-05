package com.deliverybusiness.service;

import com.deliverybusiness.Dao.IRestaurantDao;
import com.deliverybusiness.exception.WrongIdException;
import com.deliverybusiness.model.City;
import com.deliverybusiness.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements  IRestaurantService{
    private IRestaurantDao iRestaurantDao;

    public RestaurantServiceImpl() {
    }
    @Autowired
    public RestaurantServiceImpl(IRestaurantDao iRestaurantDao) {
        this.iRestaurantDao = iRestaurantDao;
    }

    @Override
    public List<Restaurant> findAll() {
        return this.iRestaurantDao.findAll();
    }

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
        return this.iRestaurantDao.save(restaurant);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Restaurant> findByName(String name) {
        return this.iRestaurantDao.findByName(name);
    }

    @Override
    public String removeRestaurant(int id) {
        Restaurant restaurant = findById(id);
        this.iRestaurantDao.delete(restaurant);
        return "restaurant removed";
    }

    @Override
    public Restaurant findById(int id) throws WrongIdException{
        Optional<Restaurant> optional = this.iRestaurantDao.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        else {
            throw new WrongIdException("Id doesnt exist");
        }

    }

    @Override
    public Restaurant updateRestaurant(Restaurant restaurant, int id) {
        Restaurant restaurant1 = findById(id);
        restaurant1.setActive(true);
        restaurant1.setDescription(restaurant.getDescription());
        restaurant1.setCity(new City());
        return  restaurant1;
    }

    @Override
    public List<Restaurant> findByIsActiveTrue() {
        return this.iRestaurantDao.findByIsActiveTrue();
    }
}
