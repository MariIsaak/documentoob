package com.example.documentoob.model;

import jakarta.persistence.*;
import lombok.Data;

import java.security.Timestamp;


@Data
@Entity
public class Documents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Timestamp uploadDate;

    @Column(nullable = false)
    private int fileSize;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FileType fileType;

    @Column(nullable = false)
    private String filePath;

    @Lob
    @Column
    private String textContent;

    @ManyToOne
    @JoinColumn(name = "uploadedBy", nullable = false)
    private UserDtls uploadedBy;

    // Enum для типов файлов
    public enum FileType {
        PDF, JPG, JPEG
    }
}
