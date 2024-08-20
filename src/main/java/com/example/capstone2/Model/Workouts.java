package com.example.capstone2.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Workouts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message="Workouts name must not be empty")
    @Column(columnDefinition = "varchar(100) not null")
    private String name;

    @NotNull(message = "User ID must not be null")
    @Column(columnDefinition = "int not null")
    private Integer userId;

    @NotNull(message = "Calories burned must not be null")
    @Column(columnDefinition = "DECIMAL(5,2) not null")
    private Double caloriesBurned;

    @NotNull(message = "Duration in minutes must not be null")
    @Column(columnDefinition = "int not null")
    private int durationMin;

//    @NotNull(message = "Price must not be null")
    @Column(columnDefinition = "int not null")
    private double price = 50;






}
