package io.snyk.dylansnyk.demo.service;

import io.snyk.dylansnyk.demo.model.User;
import io.snyk.dylansnyk.demo.model.UserDto;
import io.snyk.dylansnyk.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UtilService utilService;

    public User getUserByUsername(String username) {

        List<User> users = userRepository.findByUsername(username);

        return users.get(0);
    }

    @SneakyThrows
    public User createUserByUsername(String username) {

        User user = User.builder()
                .username(username)
                .build();


        User savedUser = userRepository.save(user);

        utilService.executeCommand(savedUser.getUsername());

        return savedUser;
    }
}
