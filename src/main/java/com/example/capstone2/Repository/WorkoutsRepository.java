package com.example.capstone2.Repository;

import com.example.capstone2.Model.Workouts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface WorkoutsRepository extends JpaRepository<Workouts, Integer> {

    Workouts findWorkoutsById(int id);

    Workouts findWorkoutsByUserId(int userId);


    @Query("select w from Workouts w where w.durationMin=?1")
    List<Workouts> findWorkoutsByDurationMin(int min);


    @Query("select w from Workouts w where w.caloriesBurned>?1")
    List<Workouts> findWorkoutsByCaloriesBurned(int caloriesBurned);

}
