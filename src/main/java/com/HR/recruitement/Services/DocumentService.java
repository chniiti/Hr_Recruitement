package com.HR.recruitement.Services;

import com.HR.recruitement.Entities.Document;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DocumentService {

    Document getDocument(Long id);
    Document addDocument(Document document);
    List<Document> getDocuments();
    ResponseEntity<String> deleteDocument(Long id);
    ResponseEntity<String> updateDocument(Long id, Document document);
}
