package com.furnapp.service;

import com.furnapp.exceptions.FurnitureNotFoundException;
import com.furnapp.model.Furniture;
import com.furnapp.model.Style;
import com.furnapp.repository.IFurnitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FurnitureServiceImpl implements IFurnitureService{
    private IFurnitureRepository furnitureRepository;
    @Autowired
    public void setFurnitureRepository(IFurnitureRepository furnitureRepository) {
        this.furnitureRepository = furnitureRepository;
    }


    @Override
    public void addFurniture(Furniture furniture) {
        furnitureRepository.save(furniture);
    }

    @Override
    public void deleteFurniture(int furnitureId) {
        furnitureRepository.deleteById(furnitureId);
    }

    @Override
    public void updateFurniture(Furniture furniture) {
        furnitureRepository.save(furniture);
    }

    @Override
    public Furniture getById(int furnitureId) throws FurnitureNotFoundException {
        return furnitureRepository.findById(furnitureId).get();
    }

    @Override
    public List<Furniture> findByMaterial(String material) {
        return furnitureRepository.findByMaterial(material);
    }

    @Override
    public List<Furniture> findByRoomType(String type) {
        return furnitureRepository.findByRoomType(type);
    }

    @Override
    public List<Furniture> findByCategory(String category) {
        return furnitureRepository.findByCategory(category);
    }

    @Override
    public List<Furniture> findByStyle(Style style) {
        return furnitureRepository.findByStyle(style);
    }

    @Override
    public List<Furniture> findByBrand(String brand) {
        return furnitureRepository.findByBrand(brand);
    }

    @Override
    public List<Furniture> findByStorageAvailable(boolean storage) {
        return furnitureRepository.findByStorageAvailable(storage);
    }

    @Override
    public List<Furniture> findFurnitureByAnything(Furniture furniture) {
        return null;
    }

    @Override
    public List<Furniture> findByPriceRange(double minPrice, double maxPrice) {
        return furnitureRepository.findByPriceRange(minPrice, maxPrice);
    }

    @Override
    public List<Furniture> findByMatAndBrand(String material, String brand) {
        return furnitureRepository.findByMatAndBrand(material, brand);
    }

    @Override
    public List<Furniture> findByRoomAndCategory(String roomType, String category) {

        return furnitureRepository.findByRoomAndCategory(roomType, category);
    }


}
