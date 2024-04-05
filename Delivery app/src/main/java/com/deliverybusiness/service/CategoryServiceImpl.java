package com.deliverybusiness.service;

import com.deliverybusiness.Dao.ICategoryDao;
import com.deliverybusiness.Dao.IItemCategoryDao;
import com.deliverybusiness.exception.WrongIdException;
import com.deliverybusiness.model.Category;
import com.deliverybusiness.model.ItemCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements ICategoryService{
    @Autowired
    private ICategoryDao iCategoryDao;
    @Autowired
    private IItemCategoryDao iItemCategoryDao;

    public CategoryServiceImpl(ICategoryDao iCategoryDao) {
        this.iCategoryDao = iCategoryDao;
    }

    @Override
    public List<Category> findAll() {
        return this.iCategoryDao.findAll();
    }

    @Override
    public Category findById(int id) throws WrongIdException {
        Optional<Category> optionalCategory = iCategoryDao.findById(id);
        if(optionalCategory.isPresent()){
           Category category = optionalCategory.get();
           List<ItemCategory> lista = iItemCategoryDao.findByCategory(category);
           category.setItems(lista);
           return category;
        }else {
            throw new WrongIdException("Wrong id");}
    }
}
