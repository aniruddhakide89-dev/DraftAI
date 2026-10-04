package com.aniruddha.draftai.repository;

import com.aniruddha.draftai.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DocumentRepository extends JpaRepository<Document,Integer> {
    Optional<Document> findByTitle(String title);
}
