package com.deliverybusiness.service;

import com.deliverybusiness.model.Category;
import com.deliverybusiness.model.ItemCategory;
import com.deliverybusiness.model.MenuItem;

import java.util.List;

public interface IItemCategoryService {
    List<ItemCategory> findByCategory(Category category);
    List<ItemCategory> findByMenuItem(MenuItem menuItem);
}
