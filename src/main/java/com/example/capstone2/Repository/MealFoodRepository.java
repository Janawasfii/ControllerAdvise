package com.example.capstone2.Repository;

import com.example.capstone2.Model.MealFood;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealFoodRepository extends JpaRepository<MealFood, Integer> {
    MealFood findMealFoodById(Integer id);

    MealFood findMealFoodByUserId(Integer userId);

}
