package com.example.capstone2.Repository;

import com.example.capstone2.Model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
    Schedule findScheduleById(Integer id);

  @Query("select s from Schedule s where s.scheduleDate=?1")
    List<Schedule> findScheduleByDate(LocalDate date);


  @Query("select s from Schedule s where s.mealName=?1")
  List<Schedule> findScheduleByMealName(String mealName);
}
