package com.deliverybusiness.service;

import com.deliverybusiness.Dao.IOpeningHoursDao;
import com.deliverybusiness.model.OpeningHours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpeningHoursServiceImpl implements IOpeningHoursService{
    private IOpeningHoursDao openingHoursDao;

    @Autowired
    public OpeningHoursServiceImpl(IOpeningHoursDao openingHoursDao) {
        this.openingHoursDao = openingHoursDao;
    }

    @Override
    public OpeningHours createOpeningHours(OpeningHours openingHours) {
        if (openingHours.getFromTime() != null || openingHours.getToTime() != null) {
            String[] fromTime = openingHours.getFromTime().split(":");
            String[] toTime = openingHours.getToTime().split(":");
            Integer fromTimeH = Integer.parseInt(fromTime[0]);
            Integer fromTimeM = Integer.parseInt(fromTime[1]);
            Integer toTimeH = Integer.parseInt(toTime[0]);
            Integer toTimeM = Integer.parseInt(toTime[1]);
            if(fromTimeH == toTimeH){
                if(fromTimeM > toTimeM){
                    throw  new RuntimeException("Wrong time");
                }
            }
            if(fromTimeH > toTimeH){
                throw new RuntimeException("Starting hours cant be later than closing hours.");
            }
        }
        return this.openingHoursDao.save(openingHours);
        }

}
