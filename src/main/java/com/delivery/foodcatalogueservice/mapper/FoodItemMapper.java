package com.delivery.foodcatalogueservice.mapper;

import com.delivery.foodcatalogueservice.dto.FoodItemDTO;
import com.delivery.foodcatalogueservice.entity.FoodItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodItemMapper {

    FoodItemMapper INSTANCE = Mappers.getMapper(FoodItemMapper.class);

    FoodItem mapFoodItemDTOToFoodItem(FoodItemDTO foodItemDto);
    FoodItemDTO mapFoodItemToFoodItemDTO(FoodItem foodItem);
}
