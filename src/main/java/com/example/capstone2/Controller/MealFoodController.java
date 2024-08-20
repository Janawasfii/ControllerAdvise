package com.example.capstone2.Controller;
import com.example.capstone2.Model.MealFood;
import com.example.capstone2.Service.MealFoodService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/meal-food")

public class MealFoodController {
    private final MealFoodService mealFoodService;
    @GetMapping("/get")
    public ResponseEntity getMealFood(){
        return ResponseEntity.status(200).body(mealFoodService.getMealFood());
    }

    @PostMapping("/add")
    public ResponseEntity addMealFood(@Valid @RequestBody MealFood mealFood){
        mealFoodService.addMealFood(mealFood);
        return ResponseEntity.status(200).body("Successfully added Meal food");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateMealFood(@PathVariable Integer id, @Valid @RequestBody MealFood mealFood){
        mealFoodService.updateMealFood(id, mealFood);
        return ResponseEntity.status(200).body("Successfully updated Meal food");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMealFood(@PathVariable Integer id){
        mealFoodService.deleteMealFood(id);
        return ResponseEntity.status(200).body("Successfully deleted Meal food");
    }
    @GetMapping("/set-bmr/{id}")
    public ResponseEntity changeBMR(@PathVariable Integer id){
        return ResponseEntity.status(200).body(mealFoodService.changeBMR(id));
    }

    @GetMapping("/daily-calorie/{id}")
    public ResponseEntity getMealFood(@PathVariable Integer id){
        mealFoodService.calculateDailyCalorieNeeds(id);
        return ResponseEntity.status(200).body(mealFoodService.calculateDailyCalorieNeeds(id));
    }

}
