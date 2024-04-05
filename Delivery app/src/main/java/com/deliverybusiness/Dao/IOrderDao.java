package com.deliverybusiness.Dao;

import com.deliverybusiness.model.Customer;
import com.deliverybusiness.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface IOrderDao extends JpaRepository<Orders, Integer> {
    @Query("Select distinct o.customer from Orders o where o.price=:price")
    List<Customer> findCustomerByOrder(double price);

    @Query("Select o from Orders o, Customer c where o.customer=c and o.customer=:customer")
    List<Orders> findByCustomer(@Param("customer")Customer customer);

    @Query("Select o from Orders o where o.orderDate between :firstDate and :secondDate")
    List<Orders> findOrdersByDate(LocalDate firstDate, LocalDate secondDate);
}
