package com.HR.recruitement.Controller;

import com.HR.recruitement.Entities.Document;
import com.HR.recruitement.Services.DocumentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Document")
@RequiredArgsConstructor
@Slf4j

public class DocumentController {

    @Autowired
    DocumentService documentService;

    @PostMapping("/add")
    Document addDocument(@RequestBody Document document) {
        return documentService.addDocument(document);
    }

    @GetMapping("/all")
    List<Document> getAllDocuments() {
        return documentService.getDocuments();
    }

    @GetMapping("/{id}")
    Document getDocumentById(@RequestParam Long id) {
        return documentService.getDocument(id);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> deleteDocumentById(@RequestParam Long id) {
        return documentService.deleteDocument(id);
    }

    @PutMapping("/update/{id}")
    ResponseEntity<String> updateDocument(@RequestParam Long id, @RequestBody Document document) {
        return documentService.updateDocument(id, document);
    }
}
