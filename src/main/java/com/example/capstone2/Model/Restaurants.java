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

public class Restaurants {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message="Restaurant name must not be empty")
    @Column(columnDefinition = "varchar(100) not null")
    private String name;

    @NotEmpty(message = "Location must not be empty")
    @Column(columnDefinition = "varchar(255) not null")
    private String location;


    @NotNull(message = "Food ID must not be null")
    @Column(columnDefinition = "varchar(255) not null")
    private String foodId;


    @NotNull(message = "Meal food ID must not be null")
    @Column(columnDefinition = "varchar(255) not null")
    private String mealFoodId;


    //@NotNull(message = "Price must not be null")
    @Column(columnDefinition = "int not null")
    private double price =150;











}
