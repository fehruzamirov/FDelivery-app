package com.deliverybusiness.controller;


import com.deliverybusiness.model.Category;
import com.deliverybusiness.model.ItemCategory;
import com.deliverybusiness.service.CategoryServiceImpl;
import com.deliverybusiness.service.ItemCategoryServiceImpl;
import com.deliverybusiness.service.MenuItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/item_category")
public class ItemCategoryController {

    @Autowired
    private ItemCategoryServiceImpl  itemCategoryService;
    @Autowired
    private CategoryServiceImpl categoryService;
    @Autowired
    private MenuItemServiceImpl menuItemService;

    @GetMapping("/all_categories")
    public List<Category> findAll(){
        return categoryService.findAll();
    }



}
