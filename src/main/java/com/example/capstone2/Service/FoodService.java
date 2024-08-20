package com.example.capstone2.Service;
import com.example.capstone2.APIResponse.APIException;
import com.example.capstone2.Model.Food;
import com.example.capstone2.Repository.FoodRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class FoodService {
    private final FoodRepository foodRepository;;
    public List<Food> getFood(){

        return foodRepository.findAll();
    }
    public void addFood(Food food){
        foodRepository.save(food);
    }

    public void updateFood(Integer id ,Food food){
        Food f = foodRepository.findFoodById(id);;
        if(f == null){
            throw new APIException("Can't find food with id: " + id);
        }
         f.setFoodName(food.getFoodName());
         f.setTotalCalories(food.getTotalCalories());
         f.setProtienInGram(food.getProtienInGram());
         f.setCarbsInGram(food.getCarbsInGram());
         f.setFatInGram(food.getFatInGram());
         f.setProtienPercantege(food.getProtienPercantege());
         f.setCarbsPercantege(food.getCarbsPercantege());
         f.setFatPercantege(food.getFatPercantege());

        foodRepository.save(f);
    }

    public void deleteFood(Integer id){
        Food f = foodRepository.findFoodById(id);
        if(f == null){
            throw new APIException("Cannot find food with id " + id);
        }
        foodRepository.delete(f);
    }
    public Food searchFoodByFoodName(String foodName){
        Food f = foodRepository.searchFoodByFoodName(foodName);
        if(f == null){
            throw new APIException("Can't find food with name " + foodName);
        }
        return f;
    }

    public Food calculateCaloriesForMeal(Integer id){
        Food f = foodRepository.findFoodById(id);
        if(f == null){
            throw new APIException("Cannot find food with id " + id);
        }f.setTotalCalories(f.getFatInGram()*9 + f.getCarbsInGram()*4 + f.getProtienInGram()*4);
        foodRepository.save(f);
        return f;
    }
    public Food calculateCaloriesPerServing(Integer id){
        Food f = foodRepository.findFoodById(id);
        if(f == null){
            throw new APIException("Cannot find food with id " + id);
        }
        f.setCaloriesPerServing(f.getTotalCalories()/f.getNumberOfServing());
        foodRepository.save(f);
        return f;
    }
    public Food calculatePercentegeFat(Integer id){
        Food f = foodRepository.findFoodById(id);
        if(f == null){
            throw new APIException("Cannot find food with id " + id);
        }
        f.setFatPercantege((f.getFatInGram()*9/f.getTotalCalories())*100);
        foodRepository.save(f);
        return f;
    }

    public Food calculatePercentegeCarb(Integer id){
        Food f = foodRepository.findFoodById(id);
        if(f == null){
            throw new APIException("Cannot find food with id " + id);
        }
        f.setCarbsPercantege((f.getCarbsInGram()*4/f.getTotalCalories())*100);
        foodRepository.save(f);
        return f;
    }
    public Food calculatePercentageProtien(Integer id){
        Food f = foodRepository.findFoodById(id);
        if(f == null){
            throw new APIException("Cannot find food with id " + id);
        }
        f.setProtienPercantege((f.getProtienInGram()*4/f.getTotalCalories())*100);
        foodRepository.save(f);
        return f;
    }




}
