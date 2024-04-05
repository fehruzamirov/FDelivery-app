package com.deliverybusiness.Dao;

import com.deliverybusiness.model.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ICategoryDao extends JpaRepository<Category, Integer> {

}
