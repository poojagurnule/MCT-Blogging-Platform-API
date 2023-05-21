package com.MCT.BloggingPlatform.controller;

import com.MCT.BloggingPlatform.model.Comments;
import com.MCT.BloggingPlatform.service.CommentService;
import com.MCT.BloggingPlatform.util.CommentValidation;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    @Autowired
    CommentService commentService;
    @Autowired
    CommentValidation commentValidation;

    @PostMapping("postComment")
    public ResponseEntity saveComment(@RequestBody String commentData){
        Comments comments = commentValidation.setComment(commentData);
        int commentId = commentService.postComment(comments);
        return new ResponseEntity<>("Comments are added with Id " + commentId, HttpStatus.CREATED);
    }

    @GetMapping("getAllComments")
    public ResponseEntity getComments(){
        JSONArray response = commentService.getAllComment();
        return new ResponseEntity<>(response.toString(), HttpStatus.OK);
    }

    @GetMapping("/getCommentsById")
    public ResponseEntity getCommentsById(@RequestParam String postId, @RequestParam String commentId){
        JSONArray responseArray = commentService.getById(postId, commentId);
        return new ResponseEntity<>(responseArray.toString(), HttpStatus.OK);
    }

    @PutMapping("/updateComments")
    public ResponseEntity updateComments(@RequestParam String commentId, @RequestBody String commentData ){
        Comments updateComment = commentValidation.setComment(commentData);
        commentService.put(commentId, updateComment);
        return new ResponseEntity<>("Comment is updated", HttpStatus.OK);
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity deleteComment(@RequestParam String commentId){
        commentService.delete(commentId);
        return new ResponseEntity<>("Comment is deleted", HttpStatus.OK);
    }

}
