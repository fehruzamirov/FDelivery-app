package com.deliverybusiness.controller;

import com.deliverybusiness.exception.WrongIdException;
import com.deliverybusiness.model.City;
import com.deliverybusiness.model.dto.CitySearchDTO;
import com.deliverybusiness.model.view.View;
import com.deliverybusiness.service.CityServiceImpl;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {

    private CityServiceImpl cityService;
    @Autowired
    public CityController(CityServiceImpl cityService) {
        this.cityService = cityService;
    }

    @JsonView(View.ShowZipCode.class)
    @RequestMapping(method= RequestMethod.GET,produces ="application/json")
    public ResponseEntity<List<City>> getAll(){
        return new ResponseEntity<>(cityService.findAll(), HttpStatus.OK);
    }

    @JsonView(View.ShowAll.class)
    @GetMapping("/{id}")
    public ResponseEntity<City> getById(@PathVariable int id) throws WrongIdException {
        return new ResponseEntity<>(cityService.findById(id), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public String deleteCity(@PathVariable int id){
        return cityService.removeCity(id);
    }
    @PostMapping
    public ResponseEntity<City> addCity(@RequestBody @Valid City city){
        return new ResponseEntity<>(cityService.addCity(city), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public City updateCity(@PathVariable int id, @RequestBody @Valid City city){
        return cityService.updateCity(city,id);
    }
    @JsonView(View.ShowName.class)
    @GetMapping("/name")
    public List<City> findByName(@RequestParam (name = "name", required = true) String name){
        return cityService.findByName(name);
    }
    @PostMapping("/name")
    public List<City> findByNameDTO(@RequestBody @Valid CitySearchDTO citySearchDTO){
        return cityService.findByName(citySearchDTO.getName());
    }

    @GetMapping("/pattern")
    public List<City> findByNameLike(@RequestParam(name = "name", required = true) String pattern){
        return cityService.findByNameLike(pattern);
    }
    @PostMapping("/saveAll")
    public List<City> saveList(@RequestBody @Valid List<City> cityList){
        return cityService.saveList(cityList);
    }
    @JsonView(View.ShowZipCode.class)
    @GetMapping("/zipCode")
    public City findByZipCode(@RequestParam(name = "zipCode", required = true)String zipCode){
        return cityService.findByZipCode(zipCode);
    }
}
