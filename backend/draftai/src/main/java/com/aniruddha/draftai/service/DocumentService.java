package com.aniruddha.draftai.service;

import com.aniruddha.draftai.dto.DocumentRequestDTO;
import com.aniruddha.draftai.dto.DocumentResponseDTO;
import com.aniruddha.draftai.entity.Document;
import com.aniruddha.draftai.repository.DocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DocumentService {

    private final DocumentRepository documentRepository;

    public DocumentResponseDTO createDocument(DocumentRequestDTO dto){
        return toDTO(documentRepository.save(fromDTO(dto)));
    }

    public DocumentResponseDTO getDocumentById(Integer id){
        return toDTO(documentRepository.findById(id).orElseThrow(() -> new RuntimeException("Invalid Id")));
    }

    public DocumentResponseDTO getDocumentByTitle(String title){
        return toDTO(documentRepository.findByTitle(title).orElseThrow(() -> new RuntimeException("Invalid title")));
    }

    public DocumentResponseDTO updateDocument(DocumentRequestDTO dto, Integer id){
        Document document = documentRepository.findById(id).orElseThrow(() -> new RuntimeException("Cannot find the document"));
        document.setTitle(dto.getTitle());
        document.setContent(dto.getContent());
        return toDTO(documentRepository.save(document));
    }

    public void deleteDocument(Integer id){
        documentRepository.deleteById(id);
    }


    public Document fromDTO(DocumentRequestDTO dto){
        return Document.builder().title(dto.getTitle()).content(dto.getContent()).build();
    }

    public DocumentResponseDTO toDTO(Document document){
        DocumentResponseDTO dto = new DocumentResponseDTO();
        dto.setId(document.getId());
        dto.setTitle(document.getTitle());
        dto.setContent(document.getContent());
        dto.setLastUpdated(document.getLastUpdated());
        return dto;
    }
}
