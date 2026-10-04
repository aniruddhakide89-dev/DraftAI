package com.aniruddha.draftai.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class DocumentResponseDTO {
    private Integer id;
    private String title;
    private String content;
    private Instant lastUpdated;
}
