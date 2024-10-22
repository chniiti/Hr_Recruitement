package com.HR.recruitement.ServicesImplementations;

import com.HR.recruitement.Entities.User;
import com.HR.recruitement.Repositories.UserRepository;
import com.HR.recruitement.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserRepository userRepository;



    @Override
    public List<User> getUser() {
        return userRepository.findAll();
    }

    @Override
    public ResponseEntity<String> deleteUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.delete(user.get());
            return ResponseEntity.ok("User deleted successfully");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public ResponseEntity<String> updateUser(Long id, User user) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user1=userOptional.get();
            user1.setFirstName(user.getFirstName());
            user1.setLastName(user.getLastName());
            user1.setEmail(user.getEmail());
            user1.setPassword(user.getPassword());
            user1.setCin(user.getCin());
            user1.setPassword(user.getPassword());
            user1.setDateOfBirth(user.getDateOfBirth());
            user1.setPhone(user.getPhone());
            user1.setDocuments(user.getDocuments());

            userRepository.save(user1);
            return ResponseEntity.ok("User updated successfully");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }
}
