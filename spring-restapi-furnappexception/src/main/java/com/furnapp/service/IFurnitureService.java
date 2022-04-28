package com.furnapp.service;

import com.furnapp.exceptions.FurnitureNotFoundException;
import com.furnapp.model.Furniture;
import com.furnapp.model.Style;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IFurnitureService {
    void addFurniture(Furniture furniture);
    void deleteFurniture(int furnitureId);
    void updateFurniture(Furniture furniture);
    Furniture getById(int furnitureId) throws FurnitureNotFoundException;

    List<Furniture> findByMaterial(String material);
    List<Furniture> findByRoomType(String type);
    List<Furniture> findByCategory(String category);
    List<Furniture> findByStyle(Style style);
    List<Furniture> findByBrand(String brand);
    List<Furniture> findByStorageAvailable(boolean storage);

    List<Furniture> findFurnitureByAnything(Furniture furniture);
    // Custom query
    List<Furniture> findByPriceRange(double minPrice,double maxPrice);
    List<Furniture> findByMatAndBrand(String material,String brand);
    List<Furniture> findByRoomAndCategory(String roomType,String category);


}
