package com.furnapp.controllers;

import com.furnapp.exceptions.FurnitureNotFoundException;
import com.furnapp.model.Furniture;
import com.furnapp.model.Style;
import com.furnapp.service.IFurnitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/furniture-api")
public class FurnitureController {
    private IFurnitureService iFurnitureService;

    @Autowired
    public void setiFurnitureService(IFurnitureService iFurnitureService) {
        this.iFurnitureService = iFurnitureService;
    }

    @PostMapping("/furnitures")
    ResponseEntity<Void> addFurniture(@RequestBody Furniture furniture) {
        iFurnitureService.addFurniture(furniture);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/furnitures/furnitureId/{furnitureId}")
    ResponseEntity<Void> deleteFurniture(@PathVariable("furnitureId") int furnitureId) {
        iFurnitureService.deleteFurniture(furnitureId);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "deleted using id");
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/furnitures")
    ResponseEntity<Void> updateFurniture(@RequestBody Furniture furniture) {
        iFurnitureService.updateFurniture(furniture);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @GetMapping("/furnitures/furnitureId/{furnitureId}")
    ResponseEntity<Furniture> getById(@PathVariable("furnitureId") int furnitureId) {
        Furniture furniture = iFurnitureService.getById(furnitureId);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "getting By Id ");
        ResponseEntity<Furniture> responseEntity = new ResponseEntity<>(furniture, headers, HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/furnitures/material/{material}")
    ResponseEntity<List<Furniture>> findByMaterial(@PathVariable("material") String material) {
        List<Furniture> furnitures = iFurnitureService.findByMaterial(material);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "getting by material");
        ResponseEntity<List<Furniture>> responseEntity = new ResponseEntity<>(furnitures, headers, HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/furnitures/roomType/{roomType}")
    ResponseEntity<List<Furniture>> findByRoomType(@PathVariable("roomType") String type) {
        List<Furniture> furnitures = iFurnitureService.findByRoomType(type);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "getting by roomType");
        ResponseEntity<List<Furniture>> responseEntity = new ResponseEntity<>(furnitures, headers, HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/furnitures/category/{category}")
    ResponseEntity<List<Furniture>> findByCategory(@PathVariable("category") String category) {
        List<Furniture> furnitures = iFurnitureService.findByCategory(category);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "getting by category");
        ResponseEntity<List<Furniture>> responseEntity = new ResponseEntity<>(furnitures, headers, HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/furnitures/style/{style}")
    ResponseEntity<List<Furniture>> findByStyle(@PathVariable("style") Style style) {
        List<Furniture> furnitures = iFurnitureService.findByStyle(style);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "getting by style");
        ResponseEntity<List<Furniture>> responseEntity = new ResponseEntity<>(furnitures, headers, HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/furnitures/brand/{brand}")
    ResponseEntity<List<Furniture>> findByBrand(@PathVariable("brand") String brand) {
        List<Furniture> furnitures = iFurnitureService.findByBrand(brand);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "getting by brand");
        ResponseEntity<List<Furniture>> responseEntity = new ResponseEntity<>(furnitures, headers, HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/furnitures/storage/{storage}")
    ResponseEntity<List<Furniture>> findByStorageAvailable(@PathVariable("storage") boolean storage) {
        List<Furniture> furnitures = iFurnitureService.findByStorageAvailable(storage);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "getting by storage");
        ResponseEntity<List<Furniture>> responseEntity = new ResponseEntity<>(furnitures, headers, HttpStatus.OK);
        return responseEntity;
    }

    // Custom query
    @GetMapping("/furnitures/minPrice/{minPrice}/maxPrice/{maxPrice}")
    ResponseEntity<List<Furniture>> findByPriceRange(@PathVariable("minPrice") double minPrice, @PathVariable("maxPrice") double maxPrice) {
        List<Furniture> furnitures = iFurnitureService.findByPriceRange(minPrice, maxPrice);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "getting by minPrice " + minPrice + "maxPrice" + maxPrice);
        ResponseEntity<List<Furniture>> responseEntity = new ResponseEntity<>(furnitures, headers, HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/furnitures/material/{material}/brand/{brand}")
    ResponseEntity<List<Furniture>> findByMatAndBrand(@PathVariable("material") String material, @PathVariable("brand") String brand) {
        List<Furniture> furnitures = iFurnitureService.findByMatAndBrand(material, brand);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "getting by material " + material + "brand" + brand);
        ResponseEntity<List<Furniture>> responseEntity = new ResponseEntity<>(furnitures, headers, HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/furnitures/roomType/{roomType}/category/{category}")
    ResponseEntity<List<Furniture>> findByRoomAndCategory(@PathVariable("roomType") String roomType, @PathVariable("category") String category) {
        List<Furniture> furnitures = iFurnitureService.findByRoomAndCategory(roomType, category);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "getting by roomType " + roomType + "category" + category);
        ResponseEntity<List<Furniture>> responseEntity = new ResponseEntity<>(furnitures, headers, HttpStatus.OK);
        return responseEntity;
    }

}
