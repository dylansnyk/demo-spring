package io.snyk.dylansnyk.demo.controller;

import io.snyk.dylansnyk.demo.model.EchoDto;
import io.snyk.dylansnyk.demo.model.UserDto;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {

    private static final Logger logger = LogManager.getLogger(UserController.class);

    @SneakyThrows
    @GetMapping("/user")
    public UserDto getUser(@RequestParam String username) {
        logger.debug("GET /user: {}", username);
        return UserDto.builder()
                .username(username)
                .build();
    }
}
