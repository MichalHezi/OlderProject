package com.userLogin.controller;

import com.userLogin.model.CustomUser;
import com.userLogin.model.CustomUserRequest;
import com.userLogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/public/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    @CrossOrigin
    public ResponseEntity<?> createUser(@RequestBody CustomUserRequest customUser){
        try{
           userService.createUser(customUser);
           return null;
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }

    @DeleteMapping("/delete")
    public String deleteUserById (@RequestParam int id){
        userService.deleteUserById(id);
        return "User deleted";
    }
    @PutMapping("/password")
    public String updateUserPassword(@RequestBody CustomUser customUser){
        userService.updateUserPassword(customUser.getPassword(),customUser.getId());
        return "User's password was updated";
    }
    @PutMapping("/username")
    public String updateUsername(@RequestBody CustomUser customUser){
        userService.updateUsername(customUser.getUsername(),customUser.getId());
        return "User's username was updated";
    }
}



