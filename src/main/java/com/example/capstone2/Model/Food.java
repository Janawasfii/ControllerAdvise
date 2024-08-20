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
//@Table(name="Food")

public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message="Food name must not be empty")
    @Column(columnDefinition = "varchar(100) not null")
    private String foodName;


    @NotNull(message = "Protiens must not be null")
    @Positive(message = "Protiens must be a positive number")
    @Column(columnDefinition = "DECIMAL(5,2) not null")
    private Double protienInGram;


    @NotNull(message = "Carbs must not be null")
    @Positive(message = "Carbs must be a positive number")
    @Column(columnDefinition = "DECIMAL(5,2) not null")
    private Double carbsInGram;


    @NotNull(message = "Fats must not be null")
   @Positive(message = "Fats must be a positive number")
    @Column(columnDefinition = "DECIMAL(5,2) not null")
    private double fatInGram;


    @NotNull(message = "Protien percantege must not be null")
    @Positive(message = "Protiens must be a positive number")
    @Column(columnDefinition = "DECIMAL(5,2) not null")
    private Double protienPercantege;


    @NotNull(message = "Carbs percantege must not be null")
    @Positive(message = "Carbs must be a positive number")
    @Column(columnDefinition = "DECIMAL(5,2) not null")
    private Double carbsPercantege;


    @NotNull(message = "Fats percantege must not be null")
     @Positive(message = "Fats must be a positive number")
    @Column(columnDefinition = "DECIMAL(5,2) not null")
    private double fatPercantege;


    @NotNull(message = "Total calories must not be null")
    @Positive(message = "Total calories must be a positive number")
    @Column(columnDefinition = "DECIMAL(5,2) not null")
    private Double totalCalories;


    @NotNull(message = "Number of serving must not be null")
    @Positive(message = "Number of serving must be a positive number")
    @Column(columnDefinition = "DECIMAL(5,2) not null")
    private Double numberOfServing;


    @NotNull(message = "Calories per serving must not be null")
    @Positive(message = "Calories per serving must be a positive number")
    @Column(columnDefinition = "DECIMAL(5,2) not null")
    private Double caloriesPerServing;












}
