package com.delivery.foodcatalogueservice.service;

import com.delivery.foodcatalogueservice.dto.FoodCataloguePage;
import com.delivery.foodcatalogueservice.dto.FoodItemDTO;
import com.delivery.foodcatalogueservice.entity.FoodItem;
import com.delivery.foodcatalogueservice.mapper.FoodItemMapper;
import com.delivery.foodcatalogueservice.repository.FoodItemRepository;
import com.delivery.foodcatalogueservice.vo.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FoodCatalogueService {

    @Autowired
    FoodItemRepository foodItemRepository;

    @Autowired
    RestTemplate restTemplate;


    public FoodItemDTO addFoodItem(FoodItemDTO foodItemDTO) {
        FoodItem foodItemSavedInDb = foodItemRepository.save(FoodItemMapper.INSTANCE.mapFoodItemDTOToFoodItem(foodItemDTO));
        return FoodItemMapper.INSTANCE.mapFoodItemToFoodItemDTO(foodItemSavedInDb);
    }

    public FoodCataloguePage fetchFoodCataloguePageDetails(Integer restaurantId) {

        List<FoodItem> foodItemList = fetchFoodItemList(restaurantId);
        Restaurant restaurant = fetchRestaurantDetailsFromRestaurantMS(restaurantId);
        return createFoodCataloguePage(foodItemList, restaurant);
    }

    private FoodCataloguePage createFoodCataloguePage(List<FoodItem> foodItemList, Restaurant restaurant) {

        FoodCataloguePage foodCataloguePage = new FoodCataloguePage();
        foodCataloguePage.setFootItemsList(foodItemList);
        foodCataloguePage.setRestaurant(restaurant);
        return foodCataloguePage;
    }

    private Restaurant fetchRestaurantDetailsFromRestaurantMS(Integer restaurantId) {
        return restTemplate.getForObject("http://RESTAURANT-SERVICE/restaurant/fetchById/"+restaurantId, Restaurant.class);
    }

    private List<FoodItem> fetchFoodItemList(Integer restaurantId) {
        return foodItemRepository.findByRestaurantId(restaurantId);
    }
}
