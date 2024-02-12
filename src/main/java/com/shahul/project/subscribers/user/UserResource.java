package com.shahul.project.subscribers.user;

import java.net.URI;
import java.util.List;

import com.shahul.project.subscribers.exception.UserNotFoundException;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {
    
    private final UserDaoService service;

    public UserResource(UserDaoService service){
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return service.listAll();
    }

    @GetMapping("/users/{userId}")
    public User retrieveUser(@PathVariable String userId ) {
        User user = service.findUser(userId);
        if (user == null)
            throw new UserNotFoundException("userId " + userId + " is not found on database!");
        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        service.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(user.getUserId())
                        .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable String userId ) {
        User user = service.findUser(userId);
        if (user == null){
            throw new UserNotFoundException("userId " + userId + " is not found on database!");
        } else {
            service.deleteByUserid(userId);
        }
    }
}
