package com.example.capstone2.Controller;

import com.example.capstone2.Model.Orders;

import com.example.capstone2.Service.OrderService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/order")


public class OrderController {
    private final OrderService orderService;

    @GetMapping("/get")
    public ResponseEntity getOrder(){

        return ResponseEntity.status(200).body(orderService.getOrder());
    }

    @PostMapping("/add")
    public ResponseEntity addOrder(@Valid @RequestBody Orders orders){
        orderService.addOrder(orders);
        return ResponseEntity.status(200).body("Successfully added order");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateOrder(@PathVariable Integer id, @Valid @RequestBody Orders orders){
        orderService.updateOrder(id, orders);
        return ResponseEntity.status(200).body("Successfully updated order");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteOrder(@PathVariable Integer id){
        orderService.deleteOrder(id);
        return ResponseEntity.status(200).body("Successfully deleted order");
    }
//    @GetMapping("/discount/{orderId}/{userId}")
//    public ResponseEntity discount(@PathVariable Integer orderId, @PathVariable Integer userId){
//        orderService.discountForMember(orderId, userId);
//        return ResponseEntity.status(200).body("Successfully discounted order");
//    }

    @GetMapping("/findOrderByUserId/{userId}")
    public ResponseEntity findOrderByUserId(@PathVariable Integer userId){
        return ResponseEntity.status(200).body(orderService.findOrderByUserId(userId));
    }

}
