package io.snyk.dylansnyk.demo.controller;

import io.snyk.dylansnyk.demo.model.EchoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class EchoController {

    @GetMapping("/echo")
    public EchoDto getEcho(@RequestParam String echo) {
        return EchoDto.builder()
                .echo(echo)
                .build();
    }
}
