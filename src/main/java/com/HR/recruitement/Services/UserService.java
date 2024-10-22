package com.HR.recruitement.Services;

import com.HR.recruitement.Entities.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    public List<User> getUser();
    User getUser(Long id);
    ResponseEntity<String> deleteUser(Long id);
    ResponseEntity<String> updateUser(Long id, User user);
}
