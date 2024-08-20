package com.example.capstone2.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MealFood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message="Meal name must not be empty")
    @Column(columnDefinition = "varchar(100) not null")
    private String name;


    @NotEmpty(message="Meal description must not be empty")
    @Column(columnDefinition = "varchar(600) not null")
    private String description;


    @NotNull(message = "User ID must not be null")
    @Column(columnDefinition = "int not null")
    private Integer userId;

    @NotNull(message = "Food ID must not be null")
    @Column(columnDefinition = "int not null")
    private String foodId;

    @NotNull(message = "Serving size must not be null")
    @Positive(message = "Serving size must be a positive number")
    @Column(columnDefinition = "DECIMAL(5,2) not null")
    private Double servingSize;

    @NotNull(message = "BMR must not be null")
    @Column(columnDefinition = "DOUBLE not null")
    private double BMR;


    @NotNull(message = "Daily calorie must not be null")
    @Column(columnDefinition = "DOUBLE not null")
    private double dailyCalorieNeeds;





}
