package com.example.capstone2.Service;

import com.example.capstone2.APIResponse.APIException;
import com.example.capstone2.Model.*;
import com.example.capstone2.Repository.BillRepository;
import com.example.capstone2.Repository.OrdersRepository;
import com.example.capstone2.Repository.RestaurantsRepository;
import com.example.capstone2.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class RestaurantsService {
    private final RestaurantsRepository restaurantsRepository;
    private final OrdersRepository ordersRepository;
    private final UserRepository userRepository;
    private final BillRepository billRepository;
    public List<Restaurants> getRestaurants() {

        return restaurantsRepository.findAll();
    }

    public void addRestaurants(Restaurants restaurants){
        restaurantsRepository.save(restaurants);}


    public void updateRestaurants(Integer id ,Restaurants restaurants){
        Restaurants r = restaurantsRepository.findRestaurantsById(id);
        if(r == null){
            throw new APIException("Can't restaurants with id: " + id);}
        r.setName(restaurants.getName());
        r.setLocation(restaurants.getLocation());
        restaurantsRepository.save(r);}

    public void deleteRestaurants(Integer id){
        Restaurants r = restaurantsRepository.findRestaurantsById(id);
        if(r == null){
            throw new APIException("Cannot find restaurants with id " + id);
        }
        restaurantsRepository.delete(r);
    }
public void discountRestaurants(Integer userId,Integer resID,Integer orderId){
    User   u=userRepository.findUserById(userId);
    Restaurants restaurants=restaurantsRepository.findRestaurantsById(resID);
    Orders o=ordersRepository.findOrderById(orderId);
    Bill b = billRepository.findBillById(orderId);
    if(restaurants == null||o == null||u==null ){
        throw new APIException("Can't find restaurants with id " + resID);}
    if(u.getParticipation().equalsIgnoreCase("Fitness Starter")){
        b.setTotalAmount(o.getTotalPrice()*0.10);
    } if(u.getParticipation().equalsIgnoreCase("Fitness Pro")){
            b.setTotalAmount(o.getTotalPrice()*0.15);}
        if(u.getParticipation().equalsIgnoreCase("Wellness Enthusiast")){
            b.setTotalAmount(o.getTotalPrice()*0.20);}
        if(u.getParticipation().equalsIgnoreCase("Weight Loss Plan")){
            b.setTotalAmount(o.getTotalPrice()*0.25);}
        o.setTotalPrice(restaurants.getPrice());
        ordersRepository.save(o);
        billRepository.save(b);

}
    public Restaurants findRestaurantsByMealFoodId(Integer mealFoodId) {
        Restaurants r = restaurantsRepository.findRestaurantsById(mealFoodId);
        if(r == null){
            throw new APIException("Can't find restaurants with id " + mealFoodId);
        }
        return r;
    }

}
