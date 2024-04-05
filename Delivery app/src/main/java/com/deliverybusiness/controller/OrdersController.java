package com.deliverybusiness.controller;

import com.deliverybusiness.model.Orders;
import com.deliverybusiness.service.OrdersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    private OrdersServiceImpl ordersService;

    @Autowired
    public OrdersController(OrdersServiceImpl ordersService) {
        this.ordersService = ordersService;
    }

    @GetMapping("/name")
    public List<Orders> findOrdersByDate(@RequestParam(name = "firstDate", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                             LocalDate firstDate,
                                         @RequestParam(name = "secondDate", required = true)@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                         LocalDate secondDate){
        return ordersService.findOrdersByDate(firstDate, secondDate);
    }
}
