package com.delivery.foodcatalogueservice.vo;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {


    private int id;
    private String name;
    private String address;
    private String city;
    private String restaurantDescription;

}
