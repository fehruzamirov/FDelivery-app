package com.deliverybusiness.controller;

import com.deliverybusiness.model.OpeningHours;
import com.deliverybusiness.service.OpeningHoursServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/openingHours")
public class OpeningHoursController {
    private OpeningHoursServiceImpl openingHoursService;

    @Autowired
    public OpeningHoursController(OpeningHoursServiceImpl openingHoursService) {
        this.openingHoursService = openingHoursService;
    }
    @PostMapping
    public OpeningHours createOpeningHours(@RequestBody @Valid OpeningHours openingHours){
        return this.openingHoursService.createOpeningHours(openingHours);
    }
}
