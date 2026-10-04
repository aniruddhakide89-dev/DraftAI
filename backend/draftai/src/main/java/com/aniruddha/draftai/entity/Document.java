package com.aniruddha.draftai.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    private Instant createdAt;

    private Instant lastUpdated;

    @PrePersist
    public void onCreate(){
        createdAt = Instant.now();
        lastUpdated = Instant.now();
    }

    @PreUpdate
    public void onUpdate(){
        lastUpdated = Instant.now();
    }
}
