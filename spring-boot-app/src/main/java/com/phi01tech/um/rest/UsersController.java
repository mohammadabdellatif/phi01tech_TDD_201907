package com.phi01tech.um.rest;

import com.phi01tech.um.handlers.AddUserHandler;
import com.phi01tech.um.handlers.AddUserInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    @Autowired
    private AddUserHandler handler;

    @PostMapping("/users")
    public ResponseEntity add(@RequestBody AddUserInput input) {
        try {
            handler.execute(input);
            return ResponseEntity.ok("success");
        } catch (Exception e) {
            String message = e.getMessage();
            return ResponseEntity.badRequest().body(null == message ? e.getClass().getSimpleName() : message);
        }
    }
}
