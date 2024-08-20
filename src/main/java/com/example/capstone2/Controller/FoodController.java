package com.example.capstone2.Controller;
import com.example.capstone2.Model.Food;
import com.example.capstone2.Service.FoodService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/food")

public class FoodController {
    private final FoodService foodService;
    @GetMapping("/get")
    public ResponseEntity getFood(){
        return ResponseEntity.status(200).body(foodService.getFood());
    }

    @PostMapping("/add")
    public ResponseEntity addFood(@Valid @RequestBody Food food){
        foodService.addFood(food);
        return ResponseEntity.status(200).body("Successfully added food");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateFood(@PathVariable Integer id, @Valid @RequestBody Food food){
        foodService.updateFood(id, food);
        return ResponseEntity.status(200).body("Successfully updated food");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteFood(@PathVariable Integer id){
        foodService.deleteFood(id);
        return ResponseEntity.status(200).body("Successfully deleted food");
    }

    @GetMapping("/gets-totalCalorie/{id}")
    public ResponseEntity getFoodTotalCalorie(@PathVariable Integer id){
        return ResponseEntity.status(200).body(foodService.calculateCaloriesForMeal(id));
    }

    @GetMapping("/set-CaloriesPerServing/{id}")
    public ResponseEntity setCaloriesPerServing(@PathVariable Integer id){
        return ResponseEntity.status(200).body(foodService.calculateCaloriesPerServing(id));
    }

    @GetMapping("/get-food/{foodName}")
    public ResponseEntity getFood(@PathVariable String foodName){
     return ResponseEntity.status(200).body(foodService.searchFoodByFoodName(foodName));
    }

  @GetMapping("/percentageFat/{id}")
    public ResponseEntity calculatePercentegeFat(@PathVariable Integer id){
        return ResponseEntity.status(200).body(foodService.calculatePercentegeFat(id));
  }

    @GetMapping("/percentageCarb/{id}")
    public ResponseEntity calculatePercentegeCarb(@PathVariable Integer id){
        return ResponseEntity.status(200).body(foodService.calculatePercentegeCarb(id));
    }

    @GetMapping("/percentageProtien/{id}")
    public ResponseEntity calculatePercentageProtien(@PathVariable Integer id){
        return ResponseEntity.status(200).body(foodService.calculatePercentageProtien(id));
    }




}
