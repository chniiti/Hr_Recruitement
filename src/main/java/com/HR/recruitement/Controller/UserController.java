package com.HR.recruitement.Controller;

import com.HR.recruitement.Entities.User;
import com.HR.recruitement.Services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
@Slf4j

public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("/all")
    List<User> getAllUsers() {
        return userService.getUser();
    }

    @GetMapping("/{id}")
    User getUserById(@RequestParam Long id) {
        return userService.getUser(id);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> deleteUserById(@RequestParam Long id) {
        return userService.deleteUser(id);
    }

    @PutMapping("/update/{id}")
    ResponseEntity<String> updateUser(@RequestParam Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }
}
