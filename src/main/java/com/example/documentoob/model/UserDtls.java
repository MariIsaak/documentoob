package com.example.documentoob.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class UserDtls {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String qualification;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String role;

}