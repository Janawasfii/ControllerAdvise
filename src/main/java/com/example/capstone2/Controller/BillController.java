package com.example.capstone2.Controller;

import com.example.capstone2.Model.Bill;
import com.example.capstone2.Model.Food;
import com.example.capstone2.Service.BillService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/bill")

public class BillController {
    private final BillService billService;
   @GetMapping("/get")
    public ResponseEntity getBill(){
        return ResponseEntity.status(200).body(billService.getBill());
    }

    @PostMapping("/add")
    public ResponseEntity addBill(@Valid @RequestBody Bill bill){
        billService.addBill(bill);
        return ResponseEntity.status(200).body("Successfully added bill");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateBill(@PathVariable Integer id, @Valid @RequestBody Bill bill){
        billService.updateBill(id, bill);
        return ResponseEntity.status(200).body("Successfully updated bill");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBill(@PathVariable Integer id){
        billService.deleteBill(id);
        return ResponseEntity.status(200).body("Successfully deleted bill");
    }

    @GetMapping("/findBillByOrderId/{orderId}")
    public ResponseEntity getBillByOrderId(@PathVariable Integer orderId){
        return ResponseEntity.status(200).body(billService.findBillByOrderId(orderId));
    }
}
