package com.example.capstone2.Service;

import com.example.capstone2.APIResponse.APIException;
import com.example.capstone2.Model.Bill;
import com.example.capstone2.Model.Orders;
import com.example.capstone2.Model.Restaurants;
import com.example.capstone2.Repository.BillRepository;
import com.example.capstone2.Repository.OrdersRepository;
import com.example.capstone2.Repository.UserRepository;
import jakarta.persistence.criteria.Order;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class BillService {
    private final BillRepository billRepository;
    private final OrdersRepository ordersRepository;
    private final UserRepository userRepository;
    public List<Bill> getBill() {

        return billRepository.findAll();
    }

    public void addBill(Bill bill){
        Orders o = ordersRepository.findOrderById(bill.getOrderId());
        if(o==null){
            throw new APIException("Order id not found");
        }
        billRepository.save(bill);}

    public void updateBill(Integer id , Bill bill){
        Bill b = billRepository.findBillById(id);
        if(b == null){
            throw new APIException("Can't found bill with id: " + id);}
        b.setTotalAmount(bill.getTotalAmount());
        b.setDate(bill.getDate());
        billRepository.save(b);}

    public void deleteBill(Integer id){
        Bill b = billRepository.findBillById(id);
        if(b == null){
            throw new APIException("Cannot find bill with id " + id);
        }
        billRepository.delete(b);
    }

    public List<Bill> findBillByOrderId(Integer orderId){
        Bill b = billRepository.findBillById(orderId);
        if(b == null){
            throw new APIException("Can't find bill with id " + orderId);
        }
        return billRepository.findBillByOrderId(orderId);

    }





    }










