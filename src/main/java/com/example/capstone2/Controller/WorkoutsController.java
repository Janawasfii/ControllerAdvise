package com.example.capstone2.Controller;

import com.example.capstone2.Model.User;
import com.example.capstone2.Model.Workouts;
import com.example.capstone2.Service.WorkoutsService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/workouts")

public class WorkoutsController {
    private final WorkoutsService workoutsService;
    @GetMapping("/get")
    public ResponseEntity getWorkouts(){
        return ResponseEntity.status(200).body(workoutsService.getWorkouts());
    }

    @PostMapping("/add")
    public ResponseEntity addWorkouts(@Valid @RequestBody Workouts workouts){
        workoutsService.addWorkouts(workouts);
        return ResponseEntity.status(200).body("Successfully added workouts");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateWorkouts(@PathVariable Integer id, @Valid @RequestBody Workouts workouts){
        workoutsService.updateWorkouts(id, workouts);
        return ResponseEntity.status(200).body("Successfully updated workouts");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteWorkouts(@PathVariable Integer id){
        workoutsService.deleteWorkouts(id);
        return ResponseEntity.status(200).body("Successfully deleted workouts");
    }

    @GetMapping("/changeWorkouts/{id}")
    public ResponseEntity changeWorkouts(@PathVariable Integer id){
        return ResponseEntity.status(200).body(workoutsService.changeWorkouts(id));
    }

    @GetMapping("/search-duration/{durationMin}")
    public ResponseEntity searchWorkouts(@PathVariable Integer durationMin){
        return ResponseEntity.status(200).body(workoutsService.findWorkoutsByDurationMin(durationMin));
    }

    @GetMapping("/find-workouts/{caloriesBurned}")
    public ResponseEntity findWorkoutsByCaloriesBurned(@PathVariable Integer caloriesBurned){
        return ResponseEntity.status(200).body(workoutsService.findWorkoutsByCaloriesBurned(caloriesBurned));

    }


}
