package com.example.capstone2.Controller;

import com.example.capstone2.Model.User;
import com.example.capstone2.Service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/user")

public class UserController {
    private final UserService userService;
    @GetMapping("/get")
    public ResponseEntity getUser(){
        return ResponseEntity.status(200).body(userService.getUser());
    }
    @PostMapping("/add")
    public ResponseEntity addUser(@Valid @RequestBody User user, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body("Successfully added user");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id, @Valid @RequestBody User user){
        userService.updateUser(id, user);
        return ResponseEntity.status(200).body("Successfully updated user");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return ResponseEntity.status(200).body("Successfully deleted user");
    }


    @GetMapping("/set-ActiveLevel/{id}")
    public ResponseEntity changeActivityLevel(@PathVariable Integer id){
        return ResponseEntity.status(200).body(userService.changeActivityLevel(id));
    }

    @GetMapping("/find/{username}/{password}")
    public ResponseEntity findUserByUsernameAndPassword(@PathVariable String username, @PathVariable String password){
        return ResponseEntity.status(200).body(userService.findUserByUsernameAndPassword(username,password));
    }


}
