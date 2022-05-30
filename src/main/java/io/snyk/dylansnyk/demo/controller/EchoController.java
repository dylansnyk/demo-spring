package io.snyk.dylansnyk.demo.controller;

import io.snyk.dylansnyk.demo.model.EchoDto;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class EchoController {

    @SneakyThrows
    @GetMapping("/echo")
    public EchoDto getEcho(@RequestParam String echo) {
        String[] command = {echo};
        executeCommand(command);
        return EchoDto.builder()
                .echo(echo)
                .build();
    }

    private void executeCommand(@NonNull final String[] command) throws IOException {
        Process process = new ProcessBuilder(command).start();
    }
}
