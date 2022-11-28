package com.example.domain;


import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Address {
    private String city;
    private String street;
    private String zipccode;

    protected Address() {}

    public Address(String city, String street, String zipccode) {
        this.city = city;
        this.street = street;
        this.zipccode = zipccode;
    }
}
