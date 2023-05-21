package com.MCT.BloggingPlatform.controller;

import com.MCT.BloggingPlatform.model.Post;
import com.MCT.BloggingPlatform.model.User;
import com.MCT.BloggingPlatform.service.UserService;
import com.MCT.BloggingPlatform.util.UserValidation;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserValidation userValidation;
    @Autowired
    UserService userService;

    @PostMapping("/postUser")
    public ResponseEntity saveUser(@RequestBody String userData){
        User user = userValidation.setUser(userData);
        int userId = userService.postUser(user);
        return new ResponseEntity<>("User is added with userId " +userId, HttpStatus.CREATED);
    }

    @PutMapping("/updateUser")
    public ResponseEntity updatePost(@RequestParam String userId, @RequestBody String userData){
        JSONObject responseJson = userValidation.validatingUser(userData);
        if(responseJson.has("Access Denied")){
            return new ResponseEntity<>(responseJson.toString(), HttpStatus.NOT_FOUND);
        }else{
            User user = userValidation.setUser(userData);
            userService.putUser(userId, user);
            return new ResponseEntity<>("User is Updated", HttpStatus.OK);
        }
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity getAllUsers(){
        return new ResponseEntity<>(userService.getAllUser().toString(), HttpStatus.OK);
    }
    @GetMapping("/getUserByUserId")
    public ResponseEntity getUserById(@RequestParam String userId){
        JSONArray responseArray = userService.getUser(userId);
        return new ResponseEntity<>(responseArray.toString(), HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser")
    public ResponseEntity deleteUser(@RequestParam String userId){
        userService.delete(userId);
        return new ResponseEntity<>("User is deleted", HttpStatus.OK);
    }

}
