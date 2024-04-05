package com.deliverybusiness.controller;

import com.deliverybusiness.model.Menu;
import com.deliverybusiness.service.MenuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {
    private MenuServiceImpl menuService;

    @Autowired
    public MenuController(MenuServiceImpl menuService) {
        this.menuService = menuService;
    }
    @RequestMapping(method= RequestMethod.GET,produces ="application/json")
    public List<Menu> getAll(){
        return this.menuService.findAll();
    }
}
