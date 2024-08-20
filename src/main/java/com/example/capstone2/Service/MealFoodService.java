package com.example.capstone2.Service;

import com.example.capstone2.APIResponse.APIException;
import com.example.capstone2.Model.MealFood;
import com.example.capstone2.Model.Restaurants;
import com.example.capstone2.Model.User;
import com.example.capstone2.Repository.MealFoodRepository;
import com.example.capstone2.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MealFoodService {
    private final MealFoodRepository mealFoodRepository;
    private final UserRepository userRepository;


    public List<MealFood> getMealFood() {
        return mealFoodRepository.findAll();}

    public void addMealFood(MealFood mealFood){
        mealFoodRepository.save(mealFood);}

    public void updateMealFood(Integer id ,MealFood mealFood){
       MealFood mf = mealFoodRepository.findMealFoodById(id);
        if(mf == null){
            throw new APIException("Can't find Meal food with id: " + id);}
        mf.setName(mealFood.getName());
        mf.setServingSize(mealFood.getServingSize());
        mf.setDailyCalorieNeeds(mealFood.getDailyCalorieNeeds());
        mf.setBMR(mealFood.getBMR());
        mf.setDailyCalorieNeeds(mealFood.getDailyCalorieNeeds());
        mealFoodRepository.save(mf);}


    public void deleteMealFood(Integer id){
        MealFood mf = mealFoodRepository.findMealFoodById(id);
        if(mf == null){
            throw new APIException("Cannot find Meal food with id " + id);
        }
        mealFoodRepository.delete(mf);
    }

    public MealFood changeBMR(Integer id){
        MealFood mf = mealFoodRepository.findMealFoodById(id);
        User u = userRepository.findUserById(id);
        if (u == null || mf == null) {
            throw new APIException("Cannot find user or meal food ");}
        if(u.getGender().equalsIgnoreCase("Male")){
            mf.setBMR((10.0 * u.getWeight() + (6.25 * u.getHeight()) - (5.0 * u.getAge()) - 5));}
        else if(u.getGender().equalsIgnoreCase("Female")){
            mf.setBMR(10.0 * u.getWeight() + (6.25 * u.getHeight()) - (5.0 * u.getAge()) - 161.0);}
        mealFoodRepository.save(mf);
        userRepository.save(u);
        return mf;}

    public MealFood calculateDailyCalorieNeeds(Integer id) {
        User u = userRepository.findUserById(id);
        MealFood mealFood = mealFoodRepository.findMealFoodByUserId(u.getId());
        if(mealFood == null || u==null){
            throw new APIException("Can't find Meal food or user with id " + id);}
        if(u.getActivityLevel().equalsIgnoreCase("Sedentary")){
            mealFood.setDailyCalorieNeeds(mealFood.getBMR()* 1.2);}
        if(u.getActivityLevel().equalsIgnoreCase("Light")){
            mealFood.setDailyCalorieNeeds(mealFood.getBMR()*1.375);}
        if(u.getActivityLevel().equalsIgnoreCase("Moderate")){
            mealFood.setDailyCalorieNeeds(mealFood.getBMR()*1.55);}
        if(u.getActivityLevel().equalsIgnoreCase("Active")){
            mealFood.setDailyCalorieNeeds(mealFood.getBMR()*1.725);}
        mealFoodRepository.save(mealFood);
        return mealFood;
    }








}
