package com.deliverybusiness.service;

import com.deliverybusiness.Dao.IOrderDao;
import com.deliverybusiness.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class OrdersServiceImpl implements IOrdersService {
    private IOrderDao iOrderDao;

@Autowired
    public OrdersServiceImpl(IOrderDao iOrderDao) {
        this.iOrderDao = iOrderDao;
    }

    @Override
    public List<Orders> findOrdersByDate(LocalDate firstDate, LocalDate secondDate) {
        return this.iOrderDao.findOrdersByDate(firstDate, secondDate);
    }
}
