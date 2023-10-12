//package com.example.final_titv.entity;
//
//import jakarta.persistence.*;
//import lombok.Data;
//
//
//@Data
//@Entity
//@Table(name = "users")
//public class User {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//    @Id
//    @Column(nullable = false, unique = true, length = 45)
//    private String username;
//
//    @Column(nullable = false, length = 64)
//    private String password;
//
//    private boolean enabled;
//
////    @Column(name = "first_name", nullable = false, length = 20)
////    private String firstName;
////
////    @Column(name = "last_name", nullable = false, length = 20)
////    private String lastName;
//
//    // getters and setters are not shown
//}