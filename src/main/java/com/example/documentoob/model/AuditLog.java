package com.example.documentoob.model;

import jakarta.persistence.*;
import lombok.Data;

import java.security.Timestamp;


@Data
@Entity
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private UserDtls user;

    @Column(nullable = false)
    private String action;

    @ManyToOne
    @JoinColumn(name = "documentId")
    private Documents document;

    @Column(nullable = false)
    private Timestamp actionDate;

}
