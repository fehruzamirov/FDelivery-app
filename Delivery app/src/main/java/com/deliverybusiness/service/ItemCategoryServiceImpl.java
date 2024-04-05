package com.deliverybusiness.service;

import com.deliverybusiness.Dao.IItemCategoryDao;
import com.deliverybusiness.model.Category;
import com.deliverybusiness.model.ItemCategory;
import com.deliverybusiness.model.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemCategoryServiceImpl implements IItemCategoryService{

    @Autowired
    private IItemCategoryDao iItemCategoryDao;

    public ItemCategoryServiceImpl(IItemCategoryDao iItemCategoryDao) {
        this.iItemCategoryDao = iItemCategoryDao;
    }

    @Override
    public List<ItemCategory> findByCategory(Category category) {
        return iItemCategoryDao.findByCategory(category);
    }

    @Override
    public List<ItemCategory> findByMenuItem(MenuItem menuItem) {
        return iItemCategoryDao.findByMenuItem(menuItem);
    }
}
