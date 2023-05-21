package com.MCT.BloggingPlatform.dao;

import com.MCT.BloggingPlatform.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comments, Integer> {
}
