package com.delivery.foodcatalogueservice.dto;

import com.delivery.foodcatalogueservice.entity.FoodItem;
import com.delivery.foodcatalogueservice.vo.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodCataloguePage {

    private List<FoodItem> footItemsList;
    private Restaurant restaurant;

}
