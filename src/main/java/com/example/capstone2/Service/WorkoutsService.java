package com.example.capstone2.Service;
import com.example.capstone2.APIResponse.APIException;
import com.example.capstone2.Model.User;
import com.example.capstone2.Model.Workouts;
import com.example.capstone2.Repository.UserRepository;
import com.example.capstone2.Repository.WorkoutsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class WorkoutsService {
    private final WorkoutsRepository workoutsRepository;
    private final UserService userService;
    private final UserRepository userRepository;

    public List<Workouts> getWorkouts(){
        return workoutsRepository.findAll();
    }
    public void addWorkouts(Workouts workouts){
        workoutsRepository.save(workouts);
    }

    public void updateWorkouts(Integer id ,Workouts workouts){
        Workouts wo = workoutsRepository.findWorkoutsById(id);;
        if(wo == null){
            throw new APIException("Cannot find workouts with id "+id);
        }
        wo.setName(workouts.getName());
        wo.setCaloriesBurned(workouts.getCaloriesBurned());
        wo.setDurationMin(workouts.getDurationMin());
        workoutsRepository.save(wo);
    }

    public void deleteWorkouts(Integer id){
        Workouts wo =workoutsRepository.findWorkoutsById(id);
        if(wo == null){
            throw new APIException("Cannot find workouts with id "+id);}
        workoutsRepository.delete(wo);}

    public Workouts changeWorkouts(Integer userId){
        Workouts wo = workoutsRepository.findWorkoutsById(userId);
        User u = userRepository.findUserById(userId);
        if(u == null || wo==null){
            throw new APIException("Cannot find workouts or user");
        }
        if(u.getWeightGoal().equalsIgnoreCase("Weight Loss")){
            wo.setName("Running");
            wo.setCaloriesBurned(300.0);
            wo.setDurationMin(30);
        }
        if(u.getWeightGoal().equalsIgnoreCase("Weight Maintenance")){
            wo.setName("Brisk Walking");
            wo.setCaloriesBurned(200.0);
            wo.setDurationMin(45);
        }
        if(u.getWeightGoal().equalsIgnoreCase("Weight Gain")){
            wo.setName("Weightlifting");
            wo.setCaloriesBurned(400.0);
            wo.setDurationMin(60);
        }
        workoutsRepository.save(wo);
        return wo;
    }


    public List<Workouts> findWorkoutsByDurationMin(int durationMin){
        List<Workouts> workouts = workoutsRepository.findWorkoutsByDurationMin(durationMin);
        if(workouts.isEmpty()){
            throw new APIException("Cannot find workouts with durationMin "+durationMin);
        }
        return workouts;
    }

    public List<Workouts> findWorkoutsByCaloriesBurned(int caloriesBurned){
        List<Workouts> workouts = workoutsRepository.findWorkoutsByCaloriesBurned(caloriesBurned);
        if(workouts.isEmpty()){
            throw new APIException("Cannot find workouts with caloriesBurned "+caloriesBurned);
        }
        return workouts;
    }
}
