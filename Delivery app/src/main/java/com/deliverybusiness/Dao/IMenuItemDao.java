package com.deliverybusiness.Dao;

import com.deliverybusiness.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMenuItemDao extends JpaRepository<MenuItem, Integer> {
}
