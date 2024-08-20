package com.example.capstone2.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotNull(message="User Id must not be null")
    @Column(columnDefinition = "int not null")
    private Integer userId;

    @NotNull(message = "Restaurant ID must not be null")
    @Column(columnDefinition = "int not null")
    private Integer restaurantId;


//    @NotNull(message = "Schedule ID must not be null")
//    @Column(columnDefinition = "int not null")
//    private Integer scheduleId;
//
//
//    @NotNull(message = "Workouts ID must not be null")
//    @Column(columnDefinition = "int not null")
//    private Integer workoutsId;


    @NotNull(message = "Total price must not be null")
    @Column(columnDefinition = "DOUBLE not null")
    private double totalPrice;
}
