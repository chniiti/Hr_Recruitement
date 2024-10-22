package com.HR.recruitement.ServicesImplementations;

import com.HR.recruitement.Entities.Document;
import com.HR.recruitement.Repositories.DocumentRepository;
import com.HR.recruitement.Services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentServiceImp implements DocumentService {

    @Autowired
    DocumentRepository documentRepository;

    @Override
    public Document addDocument(Document document) {
        return documentRepository.save(document);
    }

    public Document getDocument(Long id) {
        return documentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Document> getDocuments() {
        return documentRepository.findAll();
    }

    @Override
    public ResponseEntity<String> deleteDocument(Long id) {

        Optional<Document> document = documentRepository.findById(id);
        if (document.isPresent()) {
            documentRepository.delete(document.get());

            return ResponseEntity.ok("Document deleted successfully");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Document not found");
        }
    }

    public ResponseEntity<String> updateDocument(Long id, Document document) {
        Optional<Document> document1= documentRepository.findById(id);
        if (document1.isPresent()) {
            Document document2=document1.get();
            document2.setFilePath(document.getFilePath());
            document2.setDescription(document.getDescription());

            documentRepository.save(document2);
            return ResponseEntity.ok("Document updated successfully");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Document not found");
        }
    }
}
