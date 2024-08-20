package com.example.capstone2.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "User ID must not be null")
    @Column(columnDefinition = "int not null")
    private Integer userId;


    @NotNull(message = "Schedule Date must not be null")
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(columnDefinition = "DATETIME default (CURRENT_TIMESTAMP)")
    private LocalDate scheduleDate;


    @NotEmpty(message="Meal name must not be empty")
    @Column(columnDefinition = "varchar(100) not null")
    private String mealName;


    @NotNull(message = "Workout ID must not be null")
    @Column(columnDefinition = "int not null")
    private Integer workoutId;

    //@NotNull(message = "Price must not be null")
    @Column(columnDefinition = "int not null")
    private double price = 60;


}
