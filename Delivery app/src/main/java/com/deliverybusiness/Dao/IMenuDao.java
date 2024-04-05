package com.deliverybusiness.Dao;

import com.deliverybusiness.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMenuDao extends JpaRepository<Menu, Integer> {
}
