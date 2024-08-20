package io.snyk.dylansnyk.demo.controller;

import io.snyk.dylansnyk.demo.model.EchoDto;
import io.snyk.dylansnyk.demo.model.User;
import io.snyk.dylansnyk.demo.model.UserDto;
import io.snyk.dylansnyk.demo.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {

    private static final Logger logger = LogManager.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @SneakyThrows
    @GetMapping("/user")
    public User getUser(@RequestParam String username) {
        logger.debug("GET /user: {}", username);

        return userService.getUserByUsername(username);
    }

    @SneakyThrows
    @PostMapping ("/user")
    public User postUser(@RequestParam String username) {
        logger.debug("POST /user: {}", username);

        return userService.createUserByUsername(username);
    }
}
