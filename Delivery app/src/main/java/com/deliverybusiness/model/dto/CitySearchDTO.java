package com.deliverybusiness.model.dto;

import javax.validation.constraints.NotBlank;

public class CitySearchDTO {
    @NotBlank(message = "In order to find a City, name is required")
    private String name;

    private String zipCode;

    public CitySearchDTO() {
    }

    public CitySearchDTO(String name, String zipCode) {
        this.name = name;
        this.zipCode = zipCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
