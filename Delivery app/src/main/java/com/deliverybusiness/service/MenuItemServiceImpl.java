package com.deliverybusiness.service;

import com.deliverybusiness.Dao.IMenuItemDao;
import com.deliverybusiness.exception.WrongIdException;
import com.deliverybusiness.model.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuItemServiceImpl implements IMenuItemService{
    @Autowired
    private IMenuItemDao iMenuItemDao;

    @Override
    public List<MenuItem> findAll() {
        return iMenuItemDao.findAll();
    }

    @Override
    public MenuItem findById(int id) throws WrongIdException {
        Optional<MenuItem> optional = iMenuItemDao.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }else {
            throw  new WrongIdException("MenuItem with " + id + " doesnt exist");
        }
    }
}
