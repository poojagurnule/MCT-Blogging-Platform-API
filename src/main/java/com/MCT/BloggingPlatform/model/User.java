package com.MCT.BloggingPlatform.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int userId;
    @NotBlank(message = "username cannot be empty")
    @Column(name = "username")
    private String userName;
    @NotBlank(message = "password id mandatory")
    @Column(name = "password")
    private String password;
    @NotBlank(message = "firstname is mandatory")
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Email(message = "email should be in correct format")
    @Column(name = "email")
    private String email;
    @Column(name = "followers")
    private int followers;



}
