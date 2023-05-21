package com.MCT.BloggingPlatform.util;

import com.MCT.BloggingPlatform.dao.UserRepository;
import com.MCT.BloggingPlatform.model.Post;
import com.MCT.BloggingPlatform.model.User;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;

@Component
public class PostValidation {
    @Autowired
    UserRepository userRepository;

    public JSONObject validatingUser(String postData){
        JSONObject jsonPost = new JSONObject(postData);
        JSONObject json = new JSONObject();
        String userName = jsonPost.getString("userName");
        String password = jsonPost.getString("password");
        List<User> userList = userRepository.findUserByUserName(userName);
        if(userList.isEmpty()){
            json.put("Access Denied", "UserName doesn't exists");
        }else{
            User user = userList.get(0);
            if(password.equals(user.getPassword())){
                json.put("Access Granted", "You are allowed to update this Post");
            }else{
                json.put("Access Denied", "Enter correct password");
            }
        }
        return json;

    }

    public Post setPost(String postData) {
        JSONObject json = new JSONObject(postData);
        Post settingPost = new Post();
        settingPost.setPostName(json.getString("postName"));
        settingPost.setPostDescription(json.getString("postDescription"));
        settingPost.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        settingPost.setViews(json.getInt("views"));
        settingPost.setLikes(json.getInt("likes"));

        String userId = json.getString("user");
        User currentUser = userRepository.findById(Integer.valueOf(userId)).get();
        settingPost.setUser(currentUser);

        return settingPost;
    }

    public JSONObject convertingPost(Post post){
        JSONObject responseJson = new JSONObject();
        responseJson.put("postId", post.getPostId());
        responseJson.put("postName", post.getPostName());
        responseJson.put("postDescription", post.getPostDescription());
        responseJson.put("createdDate", post.getCreatedDate());
        responseJson.put("views", post.getViews());
        responseJson.put("likes", post.getLikes());

        User user = post.getUser();
        JSONObject userObject = new JSONObject();
        userObject.put("userId", user.getUserId());
        userObject.put("userName", user.getUserName());

        responseJson.put("user", userObject);

        return responseJson;
    }
}
