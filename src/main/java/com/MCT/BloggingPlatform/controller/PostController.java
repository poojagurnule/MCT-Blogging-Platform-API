package com.MCT.BloggingPlatform.controller;

import com.MCT.BloggingPlatform.model.Post;
import com.MCT.BloggingPlatform.service.PostService;
import com.MCT.BloggingPlatform.util.PostValidation;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
public class PostController {
    @Autowired
    PostValidation postValidation;
    @Autowired
    PostService postService;

    @PostMapping("/savePost")
    public ResponseEntity addPost(@RequestBody String postData){
        Post post = postValidation.setPost(postData);
        int postId = postService.savePost(post);
        return new ResponseEntity<>("Post is saved with post id " + postId, HttpStatus.CREATED);
    }
    @GetMapping("/getAllPost")
    public ResponseEntity readPost(){
        JSONArray responseArray = postService.getPost();
        return new ResponseEntity<>(responseArray.toString(), HttpStatus.OK);
    }
    @GetMapping("/getPostById")
    public ResponseEntity readById(@RequestParam String userId, @RequestParam String postId){
        JSONArray responseArray = postService.getByID(userId, postId);
        return new ResponseEntity<>(responseArray.toString(), HttpStatus.OK);
    }

    @PutMapping("/updatePost")
    public ResponseEntity updatePost(@RequestParam String postId, @RequestBody String postData){
        JSONObject responseJson = postValidation.validatingUser(postData);
        if(responseJson.has("Access Denied")){
            return new ResponseEntity<>(responseJson.toString(), HttpStatus.NOT_FOUND);
        }else{
            Post post = postValidation.setPost(postData);
            postService.putPost(postId, post);
            return new ResponseEntity<>("Post is Updated", HttpStatus.OK);
        }
    }

    @DeleteMapping("deletePost")
    public ResponseEntity deletePost(@RequestParam String postId){
        postService.delete(postId);
        return new ResponseEntity<>("Post is Deleted", HttpStatus.OK);
    }
}
