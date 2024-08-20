package com.example.capstone2.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name="User")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message="User name must not be empty")
    @Column(columnDefinition = "varchar(50) unique not null")
    private String username;

    @NotEmpty(message = "Password should not be empty")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$")
    @Column(columnDefinition = "varchar(255) not null")
    private String password;

    @Email
    @NotEmpty(message="Email must not be empty")
    @Column(columnDefinition = "varchar(50) unique not null")
    private String email;

    @NotNull(message = "Age must not be null")
    @Positive(message = "Age must be a positive number")
    @Column(columnDefinition = "int not null")
    private int age;

    @NotEmpty(message = "Gender must not be empty")
    @Pattern(regexp="^(Female|Male)$",message =" You have only 2 options")
   //@Column(columnDefinition = "varchar(10) not null check (gender= 'FEMALE' or gender= 'MALE')")
    private String gender;

    @NotNull(message = "Weight must not be null")
    @Positive(message = "Weight must be a positive number")
    @Column(columnDefinition = "DECIMAL(5,2) not null")
    private double weight;

    @NotNull(message = "height must not be null")
    @Positive(message = "height must be a positive number")
    @Column(columnDefinition = "DECIMAL(5,2) not null")
    private double height;


    @NotEmpty(message = "Activity level must not be empty")
    @Pattern(regexp="^(Sedentary|Light|Moderate|Active)$",message =" You have only 4 options")
    //@Column(columnDefinition = "varchar(30) not null check (activityLevel='Sedentary' or activityLevel='Light' or activityLevel='Moderate' or activityLevel = 'Active')")
    private String activityLevel;


    @NotNull(message = "Days of exercise must not be null")
    //@Positive(message = "Days of exercise  must be a positive number")
    @Column(columnDefinition = "int not null")
    private int daysOfExercise;

    @NotEmpty(message = "Goal weight must not be empty")
    @Pattern(regexp="^(Weight Loss|Weight Maintenance|Weight Gain)$",message =" You have only 3 options")
   //@Column(columnDefinition = "varchar(60) not null check (weightGoal='Weight Loss' or weightGoal='Weight Maintenance' or weightGoal='Weight Gain' ) ")
    private String weightGoal;

    @NotEmpty(message = "Participation must not be empty")
    @Pattern(regexp="^(Fitness Starter|Fitness Pro|Wellness Enthusiast|Weight Loss Plan)$",message =" You have only 4 options")
    private String participation;


















}
