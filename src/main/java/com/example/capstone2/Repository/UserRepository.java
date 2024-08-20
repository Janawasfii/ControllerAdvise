package com.example.capstone2.Repository;

import com.example.capstone2.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserById(Integer id);

    @Query("select u from User u where u.username=?1 and u.password=?2")
    User findUserByUsernameAndPassword(String username , String Pasword);

}


