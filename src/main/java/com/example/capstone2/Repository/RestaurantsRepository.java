package com.example.capstone2.Repository;

import com.example.capstone2.Model.Restaurants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface RestaurantsRepository extends JpaRepository<Restaurants,Integer> {

    Restaurants findRestaurantsById(Integer id);

    @Query("select r from Restaurants r where r.mealFoodId=?1")
    Restaurants findRestaurantsByMealFoodId(Integer mealFoodId);
}
