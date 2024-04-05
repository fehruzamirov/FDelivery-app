package com.deliverybusiness.service;

import com.deliverybusiness.exception.WrongIdException;
import com.deliverybusiness.model.Category;

import java.util.List;

public interface ICategoryService {

    List<Category> findAll();
    Category findById(int id) throws WrongIdException;
}
