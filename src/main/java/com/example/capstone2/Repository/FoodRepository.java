package com.example.capstone2.Repository;

import com.example.capstone2.Model.Food;
import com.example.capstone2.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface FoodRepository extends JpaRepository<Food, Integer> {

    Food findFoodById(Integer id);

    Food searchFoodByFoodName(String foodName);
}
