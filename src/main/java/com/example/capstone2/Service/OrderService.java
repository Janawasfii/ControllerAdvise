package com.example.capstone2.Service;

import com.example.capstone2.APIResponse.APIException;

import com.example.capstone2.Model.*;

import com.example.capstone2.Repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class OrderService {

    private final OrdersRepository ordersRepository;
    private final UserRepository userRepository;
    private final RestaurantsRepository restaurantsRepository;
    private final ScheduleRepository scheduleRepository;
    private final WorkoutsRepository workoutsRepository;
    private final BillRepository billRepository;

    public List<Orders> getOrder() {
        return ordersRepository.findAll();
    }

    public void addOrder( Orders orders){
       User u = userRepository.findUserById(orders.getUserId());
       Restaurants r = restaurantsRepository.findRestaurantsById(orders.getRestaurantId());
     //  Schedule s= scheduleRepository.findScheduleById(orders.getScheduleId());
      //  Workouts w = workoutsRepository.findWorkoutsById(orders.getWorkoutsId());

       if(u == null || r == null ){
           throw new APIException("User or Restaurants id not found");}
        ordersRepository.save(orders);}


    public void updateOrder(Integer id ,Orders orders){
        Orders o = ordersRepository.findOrderById(id);
        if(o == null){
            throw new APIException("Can't find order with id: " + id);
        }
        o.setTotalPrice(orders.getTotalPrice());
        ordersRepository.save(o);

    }

    public void deleteOrder(Integer id){
        Orders o = ordersRepository.findOrderById(id);
        if(o == null){
            throw new APIException("Cannot find order with id " + id);
        }
        ordersRepository.delete(o);
    }

//    public void discountForMember(Integer workoutsId,Integer userId){
//        User u = userRepository.findUserById(userId);
//        Workouts w = workoutsRepository.findWorkoutsById(workoutsId);
//        Bill b = billRepository.findBillById(userId);
//        if(w == null || u == null){
//            throw new APIException("Can't find order or user id ");
//        }
//        if(u.getParticipation().equalsIgnoreCase("Fitness Starter")){
//            b.setTotalAmount(o.getTotalPrice()*0.10);}
//        if(u.getParticipation().equalsIgnoreCase("Fitness Pro")){
//            b.setTotalAmount(o.getTotalPrice()*0.15);}
//        if(u.getParticipation().equalsIgnoreCase("Wellness Enthusiast")){
//            b.setTotalAmount(o.getTotalPrice()*0.20);}
//        if(u.getParticipation().equalsIgnoreCase("Weight Loss Plan")){
//            b.setTotalAmount(o.getTotalPrice()*0.25);
//        }
//        billRepository.save(b);

//    }

    public Orders findOrderByUserId(Integer userId){
        Orders o = ordersRepository.findOrderByUserId(userId);
        if(o == null){
            throw new APIException("Can't find order with id " + userId);
        }
        return o;
    }

}
