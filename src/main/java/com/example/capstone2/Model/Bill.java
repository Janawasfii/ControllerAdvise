package com.example.capstone2.Model;

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

public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Order ID must not be null")
    @Column(columnDefinition = "int not null")
    private Integer orderId;

    @NotNull(message = "Amount must not be null")
    @Column(columnDefinition = "DOUBLE default 0 not null")
    private double totalAmount;


    @NotNull(message = "Date must not be null")
    @Column(columnDefinition = "DATETIME default (CURRENT_TIMESTAMP)")
    private LocalDate date;





}
