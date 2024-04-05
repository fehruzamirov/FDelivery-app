package com.deliverybusiness.model.dto;

import javax.validation.constraints.NotBlank;

public class CustomerSearchDTO {
    @NotBlank(message = "This field can not be empty")

    private String cityName;
    @NotBlank(message = "This field can not be empty")
    private String address;

    public CustomerSearchDTO() {
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
