package com.example.capstone2.Service;
import com.example.capstone2.APIResponse.APIException;
import com.example.capstone2.Model.MealFood;
import com.example.capstone2.Model.User;
import com.example.capstone2.Repository.MealFoodRepository;
import com.example.capstone2.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class UserService {
    private final UserRepository userRepository;
    private final MealFoodRepository mealFoodRepository;

    public List<User> getUser() {

        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(Integer id, User user) {
        User u = userRepository.findUserById(id);
        ;
        if (u == null) {
            throw new APIException("Cannot find user with id " + id);
        }
        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        u.setEmail(user.getEmail());
        u.setAge(user.getAge());
        u.setWeight(user.getWeight());
        u.setHeight(user.getHeight());
        u.setActivityLevel(user.getActivityLevel());
        //u.setGoalWeight(user.getGoalWeight());
//        u.setDailyCalorieNeeds(user.getDailyCalorieNeeds());
        userRepository.save(u);
    }

    public void deleteUser(Integer id) {
        User u = userRepository.findUserById(id);
        if (u == null) {
            throw new APIException("Cannot find user with id " + id);}
             userRepository.delete(u);}


    public User changeActivityLevel(Integer id){
        User u = userRepository.findUserById(id);
        if (u == null) {
            throw new APIException("Cannot find user with id " + id);}
        if(u.getDaysOfExercise()==0){
            u.setActivityLevel("Sedentary");}
        if(u.getDaysOfExercise()>= 1 && u.getDaysOfExercise()<=3){
            u.setActivityLevel("Light");}
        if(u.getDaysOfExercise()>=4 && u.getDaysOfExercise()<=5){
            u.setActivityLevel("Moderate");}
        if(u.getDaysOfExercise()>=6 && u.getDaysOfExercise()<=7){
            u.setActivityLevel("Active");}
            userRepository.save(u);
            return u;}


    public User findUserByUsernameAndPassword(String username, String password) {
        User u = userRepository.findUserByUsernameAndPassword(username, password);
        if (u == null) {
            throw new APIException("Cannot find user ");
        }
        return u;
    }

}







