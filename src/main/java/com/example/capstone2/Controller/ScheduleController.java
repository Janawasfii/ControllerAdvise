package com.example.capstone2.Controller;

import com.example.capstone2.Model.Schedule;
import com.example.capstone2.Model.Workouts;
import com.example.capstone2.Service.ScheduleService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/schedule")

public class ScheduleController {
    private final ScheduleService scheduleService;
    @GetMapping("/get")
    public ResponseEntity getSchedule(){
        return ResponseEntity.status(200).body(scheduleService.getSchedule());
    }

    @PostMapping("/add")
    public ResponseEntity addSchedule(@Valid @RequestBody Schedule schedule){
        scheduleService.addSchedule(schedule);
        return ResponseEntity.status(200).body("Successfully added Schedule");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateSchedule(@PathVariable Integer id, @Valid @RequestBody Schedule schedule){
        scheduleService.updateSchedule(id, schedule);
        return ResponseEntity.status(200).body("Successfully updated schedule");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletesSchedule(@PathVariable Integer id){
        scheduleService.deleteSchedule(id);
        return ResponseEntity.status(200).body("Successfully deleted schedule");
    }

    @GetMapping("/get-date/{date}")
    public ResponseEntity findScheduleByDate(@PathVariable LocalDate date){
        return ResponseEntity.status(200).body(scheduleService.findScheduleByDate(date));
    }

    @GetMapping("/gets-mealName/{mealName}")
    public ResponseEntity findScheduleByDate(@PathVariable String mealName ){
        return ResponseEntity.status(200).body(scheduleService.findScheduleByMealName(mealName));
    }
}
