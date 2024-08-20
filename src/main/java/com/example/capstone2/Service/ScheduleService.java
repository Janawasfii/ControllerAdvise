package com.example.capstone2.Service;

import com.example.capstone2.APIResponse.APIException;
import com.example.capstone2.Model.Schedule;
import com.example.capstone2.Model.Workouts;
import com.example.capstone2.Repository.ScheduleRepository;
import com.example.capstone2.Repository.WorkoutsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor

public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public List<Schedule> getSchedule(){
        return scheduleRepository.findAll();
    }
    public void addSchedule(Schedule schedule){
        scheduleRepository.save(schedule);
    }
    public void updateSchedule(Integer id ,Schedule schedule){
        Schedule s = scheduleRepository.findScheduleById(id);;
        if(s == null){
            throw new APIException("Cannot find schedule with id "+id);
        }
        s.setMealName(schedule.getMealName());
        s.setScheduleDate(schedule.getScheduleDate());
        scheduleRepository.save(s);
    }

    public void deleteSchedule(Integer id){
        Schedule s = scheduleRepository.findScheduleById(id);
        if(s == null){
            throw new APIException("Cannot find schedule with id "+id);}
        scheduleRepository.delete(s);}

    public List<Schedule> findScheduleByDate(LocalDate date){
        List<Schedule> schedules = scheduleRepository.findScheduleByDate(date);
        if(schedules == null){
            throw new APIException("Cannot find schedule with date: "+date);
        }
        return schedules;
    }
    public List<Schedule> findScheduleByMealName(String mealName){
        List<Schedule> schedules = scheduleRepository.findScheduleByMealName(mealName);
        if(schedules == null){
            throw new APIException("Cannot find schedule with name: "+mealName);
        }
        return schedules;
    }

}
