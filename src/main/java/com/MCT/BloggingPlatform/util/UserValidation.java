package com.MCT.BloggingPlatform.util;

import com.MCT.BloggingPlatform.dao.UserRepository;
import com.MCT.BloggingPlatform.model.User;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserValidation {
    @Autowired
    UserRepository userRepository;

    public JSONObject validatingUser(String userData){
        JSONObject jsonUser = new JSONObject(userData);
        JSONObject json = new JSONObject();
        String userName = jsonUser.getString("userName");
        String password = jsonUser.getString("password");
        List<User> userList = userRepository.findUserByUserName(userName);
        if(userList.isEmpty()){
            json.put("Access Denied", "UserName doesn't exists");
        }else{
            User user = userList.get(0);
            if(password.equals(user.getPassword())){
                json.put("Access Granted", "You are allowed to update User");
            }else{
                json.put("Access Denied", "Enter correct password");
            }
        }
        return json;
    }

    public User setUser(String userData) {
        JSONObject json = new JSONObject(userData);
        User settingUser = new User();
        settingUser.setUserName(json.getString("userName"));
        settingUser.setFirstName(json.getString("firstName"));
        settingUser.setLastName(json.getString("lastName"));
        settingUser.setEmail(json.getString("email"));
        settingUser.setPassword(json.getString("password"));
        settingUser.setFollowers(json.getInt("followers"));
        return settingUser;
    }


}
