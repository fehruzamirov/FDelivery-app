package com.deliverybusiness.Dao;

import com.deliverybusiness.model.Category;
import com.deliverybusiness.model.ItemCategory;
import com.deliverybusiness.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IItemCategoryDao extends JpaRepository<ItemCategory, Integer> {
    List<ItemCategory> findByCategory(Category category);
    List<ItemCategory> findByMenuItem(MenuItem menuItem);

}
