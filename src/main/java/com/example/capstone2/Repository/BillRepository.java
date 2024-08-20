package com.example.capstone2.Repository;

import com.example.capstone2.Model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface BillRepository extends JpaRepository<Bill, Integer> {

    Bill findBillById(int id);


    @Query("select b from Bill b where b.orderId=?1")
    List<Bill> findBillByOrderId(Integer orderId);
}
