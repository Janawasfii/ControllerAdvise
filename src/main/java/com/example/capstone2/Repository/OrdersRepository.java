package com.example.capstone2.Repository;


import com.example.capstone2.Model.Orders;
import com.example.capstone2.Model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface OrdersRepository extends JpaRepository<Orders, Integer> {

    @Query("select o from Orders o where o.id=?1")
    Orders findOrderById(Integer orderId);

    @Query("select o from Orders o where o.userId=?1")
    Orders findOrderByUserId(Integer userId);


}
