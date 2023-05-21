package com.MCT.BloggingPlatform.dao;

import com.MCT.BloggingPlatform.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    @Query(value = "Select * from post_table where post_id =:postId and status =1", nativeQuery = true)
    public List<Post> findByPostId(int postId);


}
