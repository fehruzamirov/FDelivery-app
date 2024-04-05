package com.deliverybusiness.Dao;

import com.deliverybusiness.model.OpeningHours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IOpeningHoursDao extends JpaRepository<OpeningHours, Integer> {

    @Query("Select o from OpeningHours o where o.dayOfWeek = com.deliverybusiness.enums.DayOfWeek.MONDAY")
    List<OpeningHours> findWorkingHoursOnMonday();
}
