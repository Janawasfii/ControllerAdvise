package com.example.capstone2.Controller;

import com.example.capstone2.Model.MealFood;
import com.example.capstone2.Model.Restaurants;
import com.example.capstone2.Service.MealFoodService;
import com.example.capstone2.Service.RestaurantsService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/restaurants")

public class RestaurantsController {
    private final RestaurantsService restaurantsService;

    @GetMapping("/get")
    public ResponseEntity getRestaurants() {
        return ResponseEntity.status(200).body(restaurantsService.getRestaurants());
    }

    @PostMapping("/add")
    public ResponseEntity addRestaurants(@Valid @RequestBody Restaurants restaurants) {
        restaurantsService.addRestaurants(restaurants);
        return ResponseEntity.status(200).body("Successfully added restaurants");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateRestaurants(@PathVariable Integer id, @Valid @RequestBody Restaurants restaurants) {
        restaurantsService.updateRestaurants(id, restaurants);
        return ResponseEntity.status(200).body("Successfully updated restaurants");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteRestaurants(@PathVariable Integer id) {
        restaurantsService.deleteRestaurants(id);
        return ResponseEntity.status(200).body("Successfully deleted restaurants");
    }

    @GetMapping("/set-price/{userId}/{resID}/{orderId}")
    public ResponseEntity discountRestaurants(@PathVariable Integer userId, @PathVariable Integer resID, @PathVariable Integer orderId) {
        restaurantsService.discountRestaurants(userId, resID, orderId);
        return ResponseEntity.status(200).body("Successfully updated");
    }
    @GetMapping("/search-res/{mealFoodId}")
    public ResponseEntity findRestaurantsByMealFoodId(@PathVariable Integer mealFoodId) {
        return ResponseEntity.status(200).body(restaurantsService.findRestaurantsByMealFoodId(mealFoodId));
    }

}


