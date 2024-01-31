package com.userLogin.controller;

import com.userLogin.model.CustomUser;
import com.userLogin.model.CustomUserRequest;
import com.userLogin.model.FavoriteList;
import com.userLogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/favorite-list")
    public List<FavoriteList>getFavoriteList(@RequestParam Long id){
        return userService.getFavoriteList(id);
    }
    @PostMapping("/add-to-favorite-list")
    public String addToFavoriteList(@RequestParam Long userId, @RequestParam Long itemId){
        userService.addToFavoriteList(userId, itemId);
        return "Added to favorites list";
    }

    @DeleteMapping("/remove-from-favorite-list")
    public ResponseEntity<String> removeFromFavorites(@RequestParam Long userId, @RequestParam Long itemId) {
        userService.removeFromFavoriteList(userId, itemId);
        return ResponseEntity.ok("Item removed from favorites!");
    }
}



