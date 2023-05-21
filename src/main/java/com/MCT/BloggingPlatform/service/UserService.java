package com.MCT.BloggingPlatform.service;

import com.MCT.BloggingPlatform.dao.UserRepository;
import com.MCT.BloggingPlatform.model.Comments;
import com.MCT.BloggingPlatform.model.Post;
import com.MCT.BloggingPlatform.model.User;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public int postUser(User user) {
        return userRepository.save(user).getUserId();
    }

    public JSONArray getAllUser(){
        JSONArray response = new JSONArray();
        List<User> userList = userRepository.findAll();
        for(User user : userList){
            response.put(user);
        }
        return response;
    }

    public JSONArray getUser(String userId) {
        JSONArray jsonArray = new JSONArray();
        if(null!= userId && userRepository.findById(Integer.valueOf(userId)).isPresent()){
            jsonArray.put(userRepository.findById(Integer.valueOf(userId)).get());
        }else{
            jsonArray.put("UserId is not present");
        }
        return jsonArray;
    }

    public void putUser(String userId, User updateUser) {
        if(null!=userId && userRepository.findById(Integer.valueOf(userId)).isPresent()){
            User oldUser = userRepository.findById(Integer.valueOf(userId)).get();
            updateUser.setUserName(oldUser.getUserName());
            updateUser.setFirstName(oldUser.getFirstName());
            updateUser.setLastName(oldUser.getLastName());
            updateUser.setPassword(oldUser.getPassword());
            updateUser.setEmail(oldUser.getEmail());
            userRepository.save(updateUser);
        }
    }

    public void delete(String userId) {
        userRepository.deleteById(Integer.valueOf(userId));
    }
}
