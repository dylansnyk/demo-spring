package io.snyk.dylansnyk.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class UtilService {

    public void executeCommand(String command) throws IOException {
        String[] commandArr = {command};
        Process process = new ProcessBuilder(commandArr).start();
    }
}
