package com.MCT.BloggingPlatform.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ManyToAny;

import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "post_table")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "postId")
    private int postId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user")
    private User user;
    @NotBlank(message = "Name of post should be provided")
    @Column(name = "postname")
    private String postName;
    @NotBlank(message = "Description should be provided for better experience")
    @Column(name = "description")
    private String postDescription;
    @Column(name = "createddate")
    private Timestamp createdDate;

    @Column(name = "views")
    private int views;
    @Column(name = "likes")
    private int likes;
}
