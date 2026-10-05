package com.aniruddha.draftai.controller;

import com.aniruddha.draftai.dto.DocumentRequestDTO;
import com.aniruddha.draftai.dto.DocumentResponseDTO;
import com.aniruddha.draftai.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/document")
public class DocumentController {

    private final DocumentService documentService;

    @PostMapping
    public ResponseEntity<DocumentResponseDTO> createDocument(@RequestBody DocumentRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(documentService.createDocument(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DocumentResponseDTO> updateDocument(@RequestBody DocumentRequestDTO dto,@PathVariable Integer id){
        return ResponseEntity.ok(documentService.updateDocument(dto,id));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteDocument(@RequestParam Integer id){
        documentService.deleteDocument(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<DocumentResponseDTO> getDocumentById(@PathVariable Integer id){
        return ResponseEntity.ok(documentService.getDocumentById(id));
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<DocumentResponseDTO> getDocumentByTitle(@PathVariable String title) {
        return ResponseEntity.ok(documentService.getDocumentByTitle(title));
    }

    @GetMapping
    public ResponseEntity<List<DocumentResponseDTO>> getAllDocuments(){
        return ResponseEntity.ok(documentService.getAllDocuments());
    }

}
