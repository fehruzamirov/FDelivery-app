package com.deliverybusiness.service;

import com.deliverybusiness.exception.WrongIdException;
import com.deliverybusiness.model.MenuItem;

import java.util.List;

public interface IMenuItemService {

    List<MenuItem> findAll();
    MenuItem findById(int id) throws WrongIdException;

}
