package com.account_service.controllers;

import com.account_service.dtos.PongResponseDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
@Tag(name = "Ping")
@RestController
@RequestMapping("api/v1/ping")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 2900)
public class PingController {

    @PostMapping
    public ResponseEntity<PongResponseDTO> pong() {
        return ResponseEntity.status(HttpStatus.OK).body(new PongResponseDTO("pong"));
    }
}
