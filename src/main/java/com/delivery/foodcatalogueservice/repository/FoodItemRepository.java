package com.delivery.foodcatalogueservice.repository;

import com.delivery.foodcatalogueservice.entity.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem, Integer> {


    List<FoodItem> findByRestaurantId(Integer restaurantId);
}
