package com.deliverybusiness.service;

import com.deliverybusiness.model.Orders;

import java.time.LocalDate;
import java.util.List;

public interface IOrdersService {
    List<Orders> findOrdersByDate(LocalDate firstDate, LocalDate secondDate);

}
