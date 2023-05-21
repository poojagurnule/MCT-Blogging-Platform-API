package com.MCT.BloggingPlatform.service;

import com.MCT.BloggingPlatform.dao.CommentRepository;
import com.MCT.BloggingPlatform.model.Comments;
import com.MCT.BloggingPlatform.util.CommentValidation;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    CommentValidation commentValidation;
    public int postComment(Comments comments) {
        return commentRepository.save(comments).getCommentId();
    }

    public JSONArray getById(String postId, String commentId) {
        JSONArray responseArray = new JSONArray();
        if(null!=commentId && commentRepository.findById(Integer.valueOf(commentId)).isPresent()){
            Comments comments = commentRepository.findById(Integer.valueOf(commentId)).get();
            JSONObject json = commentValidation.convertingComment(comments);
            responseArray.put(json);
        }
        return responseArray;
    }

    public JSONArray getAllComment() {
        JSONArray response = new JSONArray();
        List<Comments> commentList = commentRepository.findAll();
        for(Comments comments : commentList){
            JSONObject json = commentValidation.convertingComment(comments);
            response.put(json);
        }
        return response;
    }

    public void put(String commentId, Comments updateComment) {
        if(null!=commentId && commentRepository.findById(Integer.valueOf(commentId)).isPresent()){
            Comments olderComment = commentRepository.findById(Integer.valueOf(commentId)).get();
            olderComment.setDescription(updateComment.getDescription());
            olderComment.setCreatedDate(new Timestamp(System.currentTimeMillis()));
            olderComment.setPost(updateComment.getPost());
            olderComment.setCommentLikes(updateComment.getCommentLikes());
            commentRepository.save(olderComment);
        }
    }

    public void delete(String commentId) {
        commentRepository.deleteById(Integer.valueOf(commentId));
    }
}
