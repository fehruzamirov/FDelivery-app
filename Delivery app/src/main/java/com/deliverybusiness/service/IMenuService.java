package com.deliverybusiness.service;

import com.deliverybusiness.exception.WrongIdException;
import com.deliverybusiness.model.Category;
import com.deliverybusiness.model.Menu;

import java.util.List;

public interface IMenuService {
    List<Menu> findAll();

    Menu findById(int id) throws WrongIdException;
}
