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
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

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

    public void executeCommand(@NonNull final String[] command) throws IOException {
        Process process = new ProcessBuilder(command).start();
    }
    
    @SneakyThrows
    @GetMapping("/ssrf")
    public void makeRequest(@RequestParam String url) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();
    }
}
